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
public class Genero {
    private GeneroEnum genero;

    public Genero(GeneroEnum genero) {
        this.genero = genero;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }
}
