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
 * Gestão dos anos
 */
public class GestaoAno extends Resources.ContainerOfObjects{

    /**
     *metodo construtor da classe Gestaoano que instancias com um vetor por defeito
     * @param objects 
     */
    public GestaoAno(Object[] objects) {
        super(objects);
    }

    /**
     *metodo construtor da classe Gestaoano
     */
    public GestaoAno() {
    }

    /**
     *metodo construtorr da classe Gestaoano que instancia com um detreminado tamanho
     * @param size 
     */
    public GestaoAno(int size) {
        super(size);
    }
    
    /**
     * converte um vetor de objetos num vetor de anos
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
