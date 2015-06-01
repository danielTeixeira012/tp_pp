/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mapeamento;

import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
import Resources.ContainerOfObjects;

/**
 *
 * @author danielteixeira
 */
public class MapeamentoDemo {

    private GestaoMapeamento[] MapsContainer;

    public MapeamentoDemo(UnidadeTerritorial[] uts) {

        //vetor de gestao de mapeamento
        ContainerOfObjects ContainerGestaoMapeamentos = new ContainerOfObjects();
        //vetor de NUTS
        GestaoMapeamento nutsMaps = new GestaoMapeamento();
        //vetor de NUTS1
        GestaoMapeamento nuts1Maps = new GestaoMapeamento();
        //vetor de NUTS2
        GestaoMapeamento nuts2Maps = new GestaoMapeamento();
        //vetor de NUTS3
        GestaoMapeamento nuts3Maps = new GestaoMapeamento();
        //vetor de Municipios
        GestaoMapeamento municipiosMaps = new GestaoMapeamento();

        for (UnidadeTerritorial ut : uts) {
            TipoUnidadeTerritorial tut = (TipoUnidadeTerritorial) ut.getTipo();
            if ("NUTS".equals(tut.getTipo())) {
                Mapeamento nutsMap = new Mapeamento(ut);
                nutsMaps.addObject(nutsMap);
            }

            if ("NUTS1".equals(tut.getTipo())) {

                Mapeamento nuts1map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nutsMaps.getObject(nutsMaps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts1map);
                nuts1Maps.addObject(nuts1map);

            }

            if ("NUTS2".equals(tut.getTipo())) {
                Mapeamento nuts2map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts1Maps.getObject(nuts1Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts2map);
                nuts2Maps.addObject(nuts2map);

            }

            if ("NUTS3".equals(tut.getTipo())) {
                Mapeamento nuts3map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts2Maps.getObject(nuts2Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts3map);
                nuts3Maps.addObject(nuts3map);

            }

            if ("MUNICIPIO".equals(tut.getTipo())) {
                Mapeamento municipiomap = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts3Maps.getObject(nuts3Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(municipiomap);
                municipiosMaps.addObject(municipiomap);
            }

        }

        //Popular vetor de armazenamento de gestor de mapeamentos
        //adicionar container de mapeamento de nuts
        ContainerGestaoMapeamentos.addObject(nutsMaps);
        //adicionar container de mapeamento de nuts1
        ContainerGestaoMapeamentos.addObject(nuts1Maps);
        //adicionar container de mapeamento de nuts2
        ContainerGestaoMapeamentos.addObject(nuts2Maps);
        //adicionar container de mapeamento de nuts3
        ContainerGestaoMapeamentos.addObject(nuts3Maps);
        //adicionar container de mapeamento de municipios
        ContainerGestaoMapeamentos.addObject(municipiosMaps);

        //armazenamento na variavel de instancia todos os gestao de mapeamento
        this.MapsContainer = GestaoMapeamento.castToGestaoMapeamento(ContainerGestaoMapeamentos.getObjects());

    }

    public ContainerOfObjects[] getMapsContainers() {
        return this.MapsContainer;
    }

    public void printAll() {
        //Precorre vetor de gestao de mapeamentos
        for (GestaoMapeamento mapContainer : (GestaoMapeamento[]) this.MapsContainer) {
            //precorre vetor de mapas de cada gestao de mapeamentos
            for (Mapeamento map : (Mapeamento[]) mapContainer.getMaps()) {
                System.out.println(map.getUt().toString());
            }

        }
    }

}
