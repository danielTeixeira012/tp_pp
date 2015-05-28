/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mapeamento;

import Classes.unidade_territorial.GestaoUnidadeTerritorial;
import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
import Resources.ContainerOfObjects;

/**
 *
 * @author danielteixeira
 */
public class Mapeamento {

    public Mapeamento(GestaoUnidadeTerritorial gut) {

        //Unidades Territoriais
        UnidadeTerritorial[] uts = gut.getUts();

        //vetor de mapeamentos
        ContainerOfObjects mapeamentoContainer = new ContainerOfObjects();

        for (UnidadeTerritorial ut : uts) {
            TipoUnidadeTerritorial tut = (TipoUnidadeTerritorial) ut.getTipo();
            if ("NUTS".equals(tut.getTipo())) {
                MapeamentoTipoUt nutsMap = new MapeamentoTipoUt(ut);
                mapeamentoContainer.addObject(nutsMap);
            }

            if ("NUTS1".equals(tut.getTipo())) {

                MapeamentoTipoUt nuts1map = new MapeamentoTipoUt(ut);
                MapeamentoTipoUt nutsMapPai = (MapeamentoTipoUt) mapeamentoContainer.getObject(mapeamentoContainer.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts1map);
                mapeamentoContainer.addObject(nuts1map);

            }

            if ("NUTS2".equals(tut.getTipo())) {
                MapeamentoTipoUt nuts2map = new MapeamentoTipoUt(ut);
                MapeamentoTipoUt nutsMapPai = (MapeamentoTipoUt) mapeamentoContainer.getObject(mapeamentoContainer.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts2map);
                mapeamentoContainer.addObject(nuts2map);

            }
            
            if ("NUTS3".equals(tut.getTipo())) {
                MapeamentoTipoUt nuts3map = new MapeamentoTipoUt(ut);
                MapeamentoTipoUt nutsMapPai = (MapeamentoTipoUt) mapeamentoContainer.getObject(mapeamentoContainer.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts3map);
                mapeamentoContainer.addObject(nuts3map);

            }
            
            if ("MUNICIPIO".equals(tut.getTipo())) {
                MapeamentoTipoUt municipiomap = new MapeamentoTipoUt(ut);
                MapeamentoTipoUt nutsMapPai = (MapeamentoTipoUt) mapeamentoContainer.getObject(mapeamentoContainer.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(municipiomap);
                mapeamentoContainer.addObject(municipiomap);
            }
            

        }

    }

}
