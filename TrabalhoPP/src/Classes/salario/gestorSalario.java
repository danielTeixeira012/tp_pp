/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author aluno
 */
public class gestorSalario extends Resources.ContainerOfObjects implements GestorSalariosContrato {

    public gestorSalario() {
    }

    public gestorSalario(int size) {
        super(size);
    }

    public gestorSalario(Salario[] salarios) {
        super(salarios);
    }

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
            if (ut.getTipoUt() != "MUNICIPIO") {
                throw new RegistoSalarioException("Existem unidades territorais diferentes de municipios");
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
        if (!"NUTS1".equals(tutcCasted.getTipo()) && !"NUTS2".equals(tutcCasted.getTipo())) {
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
        return null;
    }

    public Salario[] getSalarios() {
        return gestorSalario.castToSalarios(this.getObjects());
    }

    @Override
    public Object getSalario(int i) throws RegistoSalarioException {
        if (i > this.countObject() - 1) {
            throw new RegistoSalarioException("A posiçao enviada não existe");
        }
        return this.getObject(i);
    }

    public String SalarioToString(Salario salario) {
        return salario.toString();
    }

    //Faz o cast de um vetor para um vetor de Gestao de Mapeamento
    public static Salario[] castToSalarios(Object[] objVector) {
        Salario[] salarios = new Salario[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            salarios[i] = (Salario) objVector[i];
        }

        return salarios;
    }

    public String SalariosToString() {
        String str = "";
        for (Salario salario : castToSalarios(this.getObjects())) {
            str = str + this.SalarioToString(salario);
        }
        return str;

    }

    public void listarSalario(Salario salario) {
        System.out.println(salario.toString());
    }

    public void listarSalarios(Salario[] salarios) {
        for (Salario salario : salarios) {
            listarSalario(salario);
        }
    }

}
