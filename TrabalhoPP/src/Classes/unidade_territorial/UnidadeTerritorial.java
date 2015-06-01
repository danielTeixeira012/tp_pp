/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.unidade_territorial;

import Classes.salario.gestorSalario;
import Exceptions.UnidadeTerritorialException;
import Interfaces.TipoUnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class UnidadeTerritorial extends UnidadeTerritorialException implements Interfaces.UnidadeTerritorialContrato {

    private String nome;
    private TipoUnidadeTerritorial tipo;
    private gestorSalario gestaoSal;

    public UnidadeTerritorial(String nome, TipoUnidadeTerritorial tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public gestorSalario getGestaoSal() {
        return this.gestaoSal;
    }

    public void setGestaoSal(gestorSalario gestaoSal) {
        this.gestaoSal = gestaoSal;
    }

    public void setTipo(TipoUnidadeTerritorial tipo) {
        this.tipo = tipo;
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
        this.tipo = (TipoUnidadeTerritorial) tutc;
    }

    @Override
    public TipoUnidadeTerritorialContrato getTipo() {
        return this.tipo;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipoUt() {

        return this.tipo.getTipo();

    }

    @Override
    public String toString() {
        return "\nUnidadeTerritorial \n" + "nome:" + this.nome + "," + this.tipo.toString() + this.gestaoSal.SalariosToString();

    }

}
