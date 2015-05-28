/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.unidade_territorial;

import Classes.salario.Salario;
import Exceptions.UnidadeTerritorialException;
import Interfaces.TipoUnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class UnidadeTerritorial extends UnidadeTerritorialException implements Interfaces.UnidadeTerritorialContrato {

    private String nome;
    private TipoUnidadeTerritorial tipo;
    private Salario[] salarios;

    public UnidadeTerritorial(String nome, TipoUnidadeTerritorial tipo,Salario[]salarios) {
        this.nome = nome;
        this.tipo = tipo;
        this.salarios=salarios;
    }

    public Salario[] getSalarios() {
        return salarios;
    }

    public void setSalarios(Salario[] salarios) {
        this.salarios = salarios;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String string) {
        this.nome = string;
    }

    @Override
    public void setTipo(TipoUnidadeTerritorialContrato tutc) {
        this.tipo= (TipoUnidadeTerritorial) tutc;
    }

    @Override
    public TipoUnidadeTerritorialContrato getTipo() {
        return this.tipo;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "UnidadeTerritorial{" + "nome=" + nome + ", tipo=" + tipo + '}';
    }
    
    

}
