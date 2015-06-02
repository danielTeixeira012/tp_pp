/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.ano;

import Classes.genero.Genero;

/**
 *
 * @author danielteixeira
 */
public class GestaoAno extends Resources.ContainerOfObjects{

    /**
     *
     * @param objects
     */
    public GestaoAno(Object[] objects) {
        super(objects);
    }

    /**
     *
     */
    public GestaoAno() {
    }

    /**
     *
     * @param size
     */
    public GestaoAno(int size) {
        super(size);
    }
    
    /**
     *
     * @param objVector
     * @return
     */
    public static Ano[] castToAnos(Object[] objVector) {
        Ano[] anos = new Ano[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            anos[i] = (Ano) objVector[i];
        }
        return anos;
    }
    
    
}
