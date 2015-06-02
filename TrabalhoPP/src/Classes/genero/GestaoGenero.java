/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.genero;

/**
 *
 * @author aluno
 */
public class GestaoGenero extends Resources.ContainerOfObjects {

    public GestaoGenero(Genero[] generos) {
        super(generos);
    }

    public GestaoGenero() {
    }

    public GestaoGenero(int size) {
        super(size);
    }

    public static Genero[] castToGeneros(Object[] objVector) {
        Genero[] generos = new Genero[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            generos[i] = (Genero) objVector[i];
        }
        return generos;
    }

}
