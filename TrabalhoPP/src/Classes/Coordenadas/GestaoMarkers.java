/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Coordenadas;

import Resources.ContainerOfObjects;

/**
 *
 * @author danielteixeira
 */
public class GestaoMarkers extends ContainerOfObjects{

    public GestaoMarkers(Object[] objects) {
        super(objects);
    }

    public GestaoMarkers() {
    }

    public GestaoMarkers(int size) {
        super(size);
    }

    @Override
    public boolean addObject(Object newObject) {
        return super.addObject(newObject); 
    }
    
    
    
}
