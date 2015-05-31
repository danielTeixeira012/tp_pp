/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mapeamento;

import Resources.ContainerOfObjects;

/**
 *
 * @author ivo
 */
public class GestaoMapeamento extends ContainerOfObjects {

    public GestaoMapeamento() {
    }

    public GestaoMapeamento(Object[] objects) {
        super(objects);
    }

    public void addMap(Mapeamento map) {

        this.addObject(map);

    }

    public Mapeamento[] getMaps() {
        Mapeamento[] maps = new Mapeamento[super.countObject()];
        for (int i = 0; i < super.countObject(); i++) {
            maps[i] = (Mapeamento) super.getObject(i);
        }

        return maps;
    }

    public Mapeamento getMap(int indice) {
        return (Mapeamento) super.getObject(indice);
    }

    //Faz o cast de um vetor para um vetor de Gestao de Mapeamento
    
    public static GestaoMapeamento[] castToGestaoMapeamento(Object[] objVector) {
        GestaoMapeamento[] containers = new GestaoMapeamento[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            containers[i] = (GestaoMapeamento) objVector[i];
        }

        return containers;
    }

}
