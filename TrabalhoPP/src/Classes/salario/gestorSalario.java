/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.salario;

import Classes.ano.Ano;
import Classes.genero.Genero;
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
        if(super.findObject(o) == -1 || o == null){
        boolean toReturn = this.addObject(o);
        if (toReturn == true) {
            System.out.println("O salario foi adicionado com sucesso");
            return toReturn;
        } else {
            System.out.println("O salario não foi adicionado!!!");
            return toReturn;
        }
        }else{
            throw new RegistoSalarioException("A unidade territorial já se encontra no vetor");
        }
    }

    @Override
    public Object[] getSalarios(UnidadeTerritorialContrato[] utcs, Object[] os, Object[] os1) throws RegistoSalarioException {
        gestorSalario tempGestor = new gestorSalario();
        for (UnidadeTerritorial ut : (UnidadeTerritorial[]) utcs) {
            for (Salario salario : ut.getGestaoSal().getSalarios()) {
                for (Genero genero : (Genero[]) os1) {
                    if (genero.getGenero().equals(salario.getGeneroSalario().getGenero())) {
                        for (Ano ano : (Ano[]) os) {
                            if (ano.getAno() == salario.getAno().getAno()) {
                                tempGestor.addRegistoSalario(salario);
                            }
                        }
                    }
                }
            }

        }
        return tempGestor.getSalarios();
    }

    @Override
    public Object[] getSalarios(Object[] os, Object[] os1, TipoUnidadeTerritorialContrato tutc) throws RegistoSalarioException {
        TipoUnidadeTerritorial tutcCasted = (TipoUnidadeTerritorial) tutc;
        gestorSalario tempGestor = new gestorSalario();
        for (Salario salario : this.getSalarios()) {
            for (Genero genero : (Genero[]) os) {
                if (genero.getGenero().equals(salario.getGeneroSalario().getGenero())) {
                    for (Ano ano : (Ano[]) os1) {
                        if (ano.getAno() == salario.getAno().getAno()) {
                            UnidadeTerritorial ut = (UnidadeTerritorial) salario.getUt();
                            if (ut.getTipoUt().equals(tutcCasted.getTipo())) {
                                tempGestor.addRegistoSalario(salario);

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

}
