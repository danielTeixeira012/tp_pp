/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.salario;

import Classes.ano.Ano;
import Classes.ano.GestaoAno;
import static Classes.ano.GestaoAno.castToAnos;
import Classes.genero.Genero;
import Classes.genero.GestaoGenero;
import static Classes.genero.GestaoGenero.castToGeneros;
import Classes.unidade_territorial.GestaoUnidadeTerritorial;
import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
import Exceptions.RegistoSalarioException;
import Interfaces.GestorSalariosContrato;
import Interfaces.TipoUnidadeTerritorialContrato;
import Interfaces.UnidadeTerritorialContrato;
import static java.lang.Float.parseFloat;

/**
 *
 * @author aluno
 */
public class gestorSalario extends Resources.ContainerOfObjects implements GestorSalariosContrato {

    /**
     *
     */
    public gestorSalario() {
    }

    /**
     *
     * @param size
     */
    public gestorSalario(int size) {
        super(size);
    }

    /**
     *
     * @param salarios
     */
    public gestorSalario(Salario[] salarios) {
        super(salarios);
    }

    /**
     *
     * @param o
     * @return
     * @throws RegistoSalarioException
     */
    @Override
    public boolean addRegistoSalario(Object o) throws RegistoSalarioException {
        if (o != null) {
            if (super.findObject(o) == -1) {
                boolean toReturn = this.addObject(o);
                if (toReturn == true) {
                    System.out.println("O salario foi adicionado com sucesso");
                    return toReturn;
                } else {
                    System.out.println("O salario não foi adicionado!!!");
                    return toReturn;
                }
            } else {
                throw new RegistoSalarioException("A unidade territorial já se encontra no vetor");
            }

        } else {
            throw new RegistoSalarioException("Enviou um salário nulo");
        }
    }

    /**
     *
     * @param utcs
     * @param os
     * @param os1
     * @return
     * @throws RegistoSalarioException
     */
    @Override
    public Object[] getSalarios(UnidadeTerritorialContrato[] utcs, Object[] os, Object[] os1) throws RegistoSalarioException {
        gestorSalario tempGestor = new gestorSalario();

        GestaoAno gAno = new GestaoAno(castToAnos(os));
        if (gAno.countObject() == 0) {
            throw new RegistoSalarioException("Não foram enviados anos");
        }

        GestaoGenero gGenero = new GestaoGenero(castToGeneros(os1));
        if (gGenero.countObject() == 0) {
            throw new RegistoSalarioException("Não foram enviados generos");
        }

        GestaoUnidadeTerritorial gut = new GestaoUnidadeTerritorial(utcs);

        if (gut.countObject() == 0) {
            throw new RegistoSalarioException("Não foram enviadas unidades territoriais");
        }

        for (UnidadeTerritorial ut : GestaoUnidadeTerritorial.castToUnidadeTerritorial(utcs)) {
            if (!ut.getTipoUt().equals("Município")) {
                throw new RegistoSalarioException("Existem unidades territorais diferentes de unicipios");
            }

            for (Salario salario : ut.getGestaoSal().getSalarios()) {

                for (Genero genero : (Genero[]) os1) {
                    if (genero.getGenero().equals(salario.getGeneroSalario().getGenero())) {

                        for (Ano ano : (Ano[]) os) {

                            if (os == null) {
                                throw new RegistoSalarioException("Não foram enviados anos");
                            }
                            if (ano.getAno() == salario.getAno().getAno()) {
                                tempGestor.addRegistoSalario(salario);
                            }
                        }
                    }
                }
            }

        }
        if (tempGestor.countObject() == 0) {
            throw new RegistoSalarioException("Não existem salários com os requisitos especificados!!");
        }
        return tempGestor.getSalarios();
    }

    /**
     *
     * @param os
     * @param os1
     * @param tutc
     * @return
     * @throws RegistoSalarioException
     */
    @Override
    public Object[] getSalarios(Object[] os, Object[] os1, TipoUnidadeTerritorialContrato tutc) throws RegistoSalarioException {
        TipoUnidadeTerritorial tutcCasted = (TipoUnidadeTerritorial) tutc;
        gestorSalario tempGestor = new gestorSalario();

        GestaoAno gAno = new GestaoAno(castToAnos(os1));
        if (gAno.countObject() == 0) {
            throw new RegistoSalarioException("Não foram enviados anos");
        }

        GestaoGenero gGenero = new GestaoGenero(castToGeneros(os));
        if (gGenero.countObject() == 0) {
            throw new RegistoSalarioException("Não foram enviados generos");
        }
        if (!"NUTS I".equals(tutcCasted.getTipo()) && !"NUTS II".equals(tutcCasted.getTipo())) {
            throw new RegistoSalarioException("O tipo de unidade territorial não é dos tipos NUTS1 nem Nuts2");
        }

        for (Salario salario : this.getSalarios()) {
            for (Genero genero : (Genero[]) os) {
                if (genero.getGenero().equals(salario.getGeneroSalario().getGenero())) {
                    for (Ano ano : (Ano[]) os1) {
                        if (ano.getAno() == salario.getAno().getAno()) {
                            UnidadeTerritorial ut = (UnidadeTerritorial) salario.getUt();
                            if (ut.getTipoUt().equals(tutcCasted.getTipo())) {
                                tempGestor.addRegistoSalario(salario);
                                if (tempGestor.countObject() == 0) {
                                    throw new RegistoSalarioException("Não existem salários com os requisitos especificados!!");
                                }
                            }
                        }

                    }

                }
            }

        }
        return tempGestor.getSalarios();
    }
    
    /**
     *
     * @return
     */
    public Salario[] getSalarios() {
        return gestorSalario.castToSalarios(this.getObjects());
    }

    /**
     *
     * @param i
     * @return
     * @throws RegistoSalarioException
     */
    @Override
    public Object getSalario(int i) throws RegistoSalarioException {
        if (i > this.countObject() - 1) {
            throw new RegistoSalarioException("A posiçao enviada não existe");
        }
        return this.getObject(i);
    }

    /**
     *
     * @param salario
     * @return
     */
    public String SalarioToString(Salario salario) {
        return salario.toString();
    }

    //Faz o cast de um vetor para um vetor de Gestao de Mapeamento

    /**
     *
     * @param objVector
     * @return
     */
        public static Salario[] castToSalarios(Object[] objVector) {
        Salario[] salarios = new Salario[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            salarios[i] = (Salario) objVector[i];
        }

        return salarios;
    }

    /**
     *
     * @return
     */
    public String SalariosToString() {
        String str = "";
        for (Salario salario : castToSalarios(this.getObjects())) {
            str = str + this.SalarioToString(salario);
        }
        return str;

    }

    /**
     *
     * @param salario
     */
    public void listarSalario(Salario salario) {
        System.out.println(salario.toString());
    }

    /**
     *
     * @param salarios
     */
    public void listarSalarios(Salario[] salarios) {
        for (Salario salario : salarios) {
            listarSalario(salario);
        }
    }

    /**
     *
     * @param str
     * @return
     */
    public static Float StringToFloat(String str) {
        String replace = str.replace(",", ".");
        String replaceVoid = replace.replace(" ", "");
        float salFloat = parseFloat(replaceVoid);
        return salFloat;

    }
}