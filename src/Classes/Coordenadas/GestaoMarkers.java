/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.Coordenadas;

import Resources.ContainerOfObjects;

/**
 *
 * Gestão dos markers
 */
public class GestaoMarkers extends ContainerOfObjects{

    /**
     *
     * @param objects
     */
    public GestaoMarkers(Object[] objects) {
        super(objects);
    }

    /**
     *
     */
    public GestaoMarkers() {
    }

    /**
     *
     * @param size
     */
    public GestaoMarkers(int size) {
        super(size);
    }

    /**
     *
     * @param newObject
     * @return
     */
    @Override
    public boolean addObject(Object newObject) {
        return super.addObject(newObject); 
    }
    
    
    
}