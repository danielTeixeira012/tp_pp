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

/**
 *
 * @author danielteixeira
 */
public class MapeamentoDemo {

    private Mapeamento[] mapeamentos;

    /**
     *
     * @param uts
     */
    public MapeamentoDemo(UnidadeTerritorialContrato[] uts) {

        //vetor de gestao de mapeamento
        GestaoMapeamento ContainerMapeamentos = new GestaoMapeamento();
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
                ContainerMapeamentos.addMap(nutsMap);

            }

            if ("NUTS I".equals(tut.getTipo())) {

                Mapeamento nuts1map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nutsMaps.getObject(nutsMaps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts1map);
                nuts1Maps.addObject(nuts1map);
                ContainerMapeamentos.addMap(nuts1map);

            }

            if ("NUTS II".equals(tut.getTipo())) {
                Mapeamento nuts2map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts1Maps.getObject(nuts1Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts2map);
                nuts2Maps.addObject(nuts2map);
                ContainerMapeamentos.addMap(nuts2map);

            }

            if ("NUTS III".equals(tut.getTipo())) {
                Mapeamento nuts3map = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts2Maps.getObject(nuts2Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(nuts3map);
                nuts3Maps.addObject(nuts3map);
                ContainerMapeamentos.addMap(nuts3map);

            }

            if ("Município".equals(tut.getTipo())) {
                Mapeamento municipiomap = new Mapeamento(ut);
                Mapeamento nutsMapPai = (Mapeamento) nuts3Maps.getObject(nuts3Maps.countObject() - 1);
                nutsMapPai.addMapeamentoFilho(municipiomap);
                municipiosMaps.addObject(municipiomap);
                ContainerMapeamentos.addMap(municipiomap);

            }

        }

        //armazenamento na variavel de instancia todos os gestao de mapeamento
        this.mapeamentos = ContainerMapeamentos.getMaps();

    }

    /**
     *
     * @return
     */
    public Mapeamento[] getMapeamentos() {
        return this.mapeamentos;
    }

    /**
     *
     */
    public void printAll() {
        GestaoMapeamento mapsContainer = new GestaoMapeamento(this.mapeamentos);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println(mapsContainer.getMap(0).toString());
        System.out.println("-------------------------------------------------------------------------");

    }

    /**
     *
     * @param i
     */
    public void printMap(int i) {
        GestaoMapeamento mapsContainer = new GestaoMapeamento(this.mapeamentos);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println(mapsContainer.getMap(i).toString());
        System.out.println("-------------------------------------------------------------------------");

    }

}
