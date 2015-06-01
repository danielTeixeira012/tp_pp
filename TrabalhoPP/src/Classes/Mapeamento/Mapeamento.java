/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mapeamento;

import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author danielteixeira
 */
public class Mapeamento {

    private UnidadeTerritorialContrato ut;
    private Mapeamento[] mapeamentosFilho;

    public Mapeamento(UnidadeTerritorialContrato ut) {
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento();
        this.mapeamentosFilho=gestaoMapeamentosFilho.getMaps();
        this.ut = ut;
    }

    public UnidadeTerritorialContrato getUt() {
        return ut;
    }

    public void setUt(UnidadeTerritorialContrato ut) {
        this.ut = ut;
    }

    public void addMapeamentoFilho(Mapeamento mapeamentoFilho) {
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento(this.mapeamentosFilho);
        gestaoMapeamentosFilho.addMap(mapeamentoFilho);
        this.mapeamentosFilho=gestaoMapeamentosFilho.getMaps();
    }

    public Mapeamento[] getMapeamentosFilho() {
        return this.mapeamentosFilho;
    }

    public Mapeamento getMapeamentoFilho(int indice) {
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento(this.mapeamentosFilho);
        return (Mapeamento) gestaoMapeamentosFilho.getMap(indice);
    }

    @Override
    public String toString() {
        
        return this.ut.toString();
    }
    
    

}
