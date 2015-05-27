/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.salario;

import Classes.ano.Ano;
import Classes.genero.Genero;
import Classes.unidade_territorial.UnidadeTerritorial;
import Exceptions.RegistoSalarioException;

/**
 *
 * @author aluno
 */
public class Salario extends RegistoSalarioException {

    private UnidadeTerritorial ut;
    private Ano ano;
    private Genero generoSalario;
    private float salario;

  
    public Salario(UnidadeTerritorial ut, Ano ano, Genero generoSalario, float salario) {
        this.ut = ut;
        this.ano = ano;
        this.generoSalario = generoSalario;
        this.salario = salario;
    }

    public UnidadeTerritorial getUt() {
        return ut;
    }

    public void setUt(UnidadeTerritorial ut) {
        this.ut = ut;
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
    
    
    
    

}
