/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.salario;

import Classes.ano.Ano;
import Classes.genero.Genero;
import Exceptions.RegistoSalarioException;
import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class Salario extends RegistoSalarioException {

    private Ano ano;
    private Genero generoSalario;
    private float salario;
    private UnidadeTerritorialContrato ut;

  
    public Salario(Ano ano, Genero generoSalario, float salario,UnidadeTerritorialContrato ut) {

        this.ano = ano;
        this.generoSalario = generoSalario;
        this.salario = salario;
        this.ut=ut;
    }


    public Ano getAno() {
        return ano;
    }

    public void setAno(Ano ano) {
        this.ano = ano;
    }

    public Genero getGeneroSalario() {
        return generoSalario;
    }

    public void setGeneroSalario(Genero generoSalario) {
        this.generoSalario = generoSalario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public UnidadeTerritorialContrato getUt() {
        return ut;
    }

    public void setUt(UnidadeTerritorialContrato ut) {
        this.ut = ut;
    }
    

    @Override
    public String toString() {
        return "\nSalario:\n" + "ano=" + this.ano.toString() + ", generoSalario=" + this.generoSalario.toString() + ", salario=" + salario ;
    }
    
    
    
    
    
    

}
