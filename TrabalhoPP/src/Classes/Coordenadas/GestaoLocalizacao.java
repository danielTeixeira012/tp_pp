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
 * @author aluno
 */
public class GestaoLocalizacao extends ContainerOfObjects {

    /**
     *
     * @param objects
     */
    public GestaoLocalizacao(Object[] objects) {
        super(objects);
    }

    /**
     *
     */
    public GestaoLocalizacao() {
    }

    /**
     *
     * @param size
     */
    public GestaoLocalizacao(int size) {
        super(size);
    }

    /**
     *
     * @param newLocal
     * @return
     */
    public boolean addLocalizacao(Localizacao newLocal) {
        return super.addObject(newLocal);
    }

}
