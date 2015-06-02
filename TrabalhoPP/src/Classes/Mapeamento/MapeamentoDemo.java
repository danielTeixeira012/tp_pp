/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.Mapeamento;

import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Interfaces.UnidadeTerritorialContrato;
import Resources.ContainerOfObjects;

/**
 *
 * @author danielteixeira
 */
public class MapeamentoDemo {

    private GestaoMapeamento[] MapsContainer;

    /**
     *
     * @param uts
     */
    public MapeamentoDemo(UnidadeTerritorialContrato[] uts) {

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

        for (UnidadeTerritorialContrato ut : uts) {
            TipoUnidadeTerritorial tut = (TipoUnidadeTerritorial) ut.getTipo();
            if ("NUTS 2013".equals(tut.getTipo())) {
                Mapeamento nutsMap = new Mapeamento(ut);
                nutsMaps.addObject(nutsMap);
            }

            if ("NUTS I".equals(tut.getTipo())) {

                Mapeamento nuts1map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nutsMaps.getObject(nutsMaps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts1map);
                nuts1Maps.addObject(nuts1map);

            }

            if ("NUTS II".equals(tut.getTipo())) {
                Mapeamento nuts2map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts1Maps.getObject(nuts1Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts2map);
                nuts2Maps.addObject(nuts2map);

            }

            if ("NUTS III".equals(tut.getTipo())) {
                Mapeamento nuts3map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts2Maps.getObject(nuts2Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts3map);
                nuts3Maps.addObject(nuts3map);

            }

            if ("Município".equals(tut.getTipo())) {
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

    /**
     *
     * @return
     */
    public GestaoMapeamento[] getMapsContainers() {
        return this.MapsContainer;
    }

    /**
     *
     */
    public void printAll() {

        for (Mapeamento map : this.MapsContainer[0].getMaps()) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println(map.toString());
            System.out.println("-------------------------------------------------------------------------");

        }
    }

    /**
     *
     * @param i
     */
    public void printMap(int i) {
        for (Mapeamento map : this.MapsContainer[i].getMaps()) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println(map.toString());
            System.out.println("-------------------------------------------------------------------------");

        }

    }

}
