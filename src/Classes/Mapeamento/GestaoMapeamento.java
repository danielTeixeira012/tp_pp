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

import Classes.unidade_territorial.UnidadeTerritorial;
import Interfaces.UnidadeTerritorialContrato;
import Resources.ContainerOfObjects;

/**
 *
 * class resposavel por fazer a gestao de mapeamentos
 */
public class GestaoMapeamento extends ContainerOfObjects {

    /**
     * construtor que inicializa vetor dinamico da classe pai
     */
    public GestaoMapeamento() {
    }

    /**
     * construtor que inicializa vetor com um outro vetor enviado como parametro
     *
     * @param objects
     */
    public GestaoMapeamento(Mapeamento[] objects) {
        super(objects);
    }

    /**
     * Adiciona um novo mapeamento ao vetor
     *
     * @param map mapa a adicionar ao vetor de mapeamentos
     */
    public void addMap(Mapeamento map) {

        this.addObject(map);

    }

    /**
     * Obtem mapeamentos do vetor
     *
     * @return retorna um vetor de mapeamentos
     */
    public Mapeamento[] getMaps() {
        Mapeamento[] maps = new Mapeamento[super.countObject()];
        for (int i = 0; i < super.countObject(); i++) {
            maps[i] = (Mapeamento) super.getObject(i);
        }

        return maps;
    }

    /**
     * Retorn determinado mapeamento do vetor
     *
     * @param indice posicao do mapeamento
     * @return retorna mapeamento se existir
     */
    public Mapeamento getMap(int indice) {
        return (Mapeamento) super.getObject(indice);
    }

  
    public Mapeamento getMapByUT(UnidadeTerritorial ut) {
        Mapeamento tempMap=null;
        for (Mapeamento map : getMaps()) {
            UnidadeTerritorialContrato tempUt = map.getUt();
            if(tempUt.equals(ut)) tempMap=map;
        }
        
        return tempMap;
    }

}
