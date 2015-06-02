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

import Resources.ContainerOfObjects;

/**
 *
 * @author ivo
 */
public class GestaoMapeamento extends ContainerOfObjects {

    /**
     *
     */
    public GestaoMapeamento() {
    }

    /**
     *
     * @param objects
     */
    public GestaoMapeamento(Mapeamento[] objects) {
        super(objects);
    }

    /**
     *
     * @param map
     */
    public void addMap(Mapeamento map) {

        this.addObject(map);

    }

    /**
     *
     * @return
     */
    public Mapeamento[] getMaps() {
        Mapeamento[] maps = new Mapeamento[super.countObject()];
        for (int i = 0; i < super.countObject(); i++) {
            maps[i] = (Mapeamento) super.getObject(i);
        }

        return maps;
    }

    /**
     *
     * @param indice
     * @return
     */
    public Mapeamento getMap(int indice) {
        return (Mapeamento) super.getObject(indice);
    }

    //Faz o cast de um vetor para um vetor de Gestao de Mapeamento

    /**
     *
     * @param objVector
     * @return
     */
        public static GestaoMapeamento[] castToGestaoMapeamento(Object[] objVector) {
        GestaoMapeamento[] containers = new GestaoMapeamento[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            containers[i] = (GestaoMapeamento) objVector[i];
        }

        return containers;
    }

}
