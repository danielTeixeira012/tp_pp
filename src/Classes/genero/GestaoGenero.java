/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.genero;

/**
 *
 * classe de instanciação da classe GestaoGenero
 */
public class GestaoGenero extends Resources.ContainerOfObjects {

    /**
     * consturor ca classe gestaoGeneros
     * @param generos
     */
    public GestaoGenero(Genero[] generos) {
        super(generos);
    }

    /**
     *
     */
    public GestaoGenero() {
    }

    /**
     *
     * @param size
     */
    public GestaoGenero(int size) {
        super(size);
    }

    /**
     *
     * @param objVector
     * @return
     */
    public static Genero[] castToGeneros(Object[] objVector) {
        Genero[] generos = new Genero[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            generos[i] = (Genero) objVector[i];
        }
        return generos;
    }

}
