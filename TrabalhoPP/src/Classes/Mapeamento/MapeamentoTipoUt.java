/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mapeamento;

import Interfaces.UnidadeTerritorialContrato;
import Resources.ContainerOfObjects;

/**
 *
 * @author danielteixeira
 */
public class MapeamentoTipoUt extends ContainerOfObjects {

    private UnidadeTerritorialContrato ut;

    public MapeamentoTipoUt(UnidadeTerritorialContrato ut) {
        super();
        this.ut = ut;
    }

    public UnidadeTerritorialContrato getUt() {
        return ut;
    }

    public void setUt(UnidadeTerritorialContrato ut) {
        this.ut = ut;
    }

    public void addMapeamentoFilho(MapeamentoTipoUt mapeamentoFilho) {
        super.addObject(mapeamentoFilho);
    }

}
