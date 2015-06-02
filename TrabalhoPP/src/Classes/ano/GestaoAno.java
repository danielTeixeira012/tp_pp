/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.ano;

import Classes.genero.Genero;

/**
 *
 * @author danielteixeira
 */
public class GestaoAno extends Resources.ContainerOfObjects{

    public GestaoAno(Object[] objects) {
        super(objects);
    }

    public GestaoAno() {
    }

    public GestaoAno(int size) {
        super(size);
    }
    
    public static Ano[] castToAnos(Object[] objVector) {
        Ano[] anos = new Ano[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            anos[i] = (Ano) objVector[i];
        }
        return anos;
    }
    
    
}
