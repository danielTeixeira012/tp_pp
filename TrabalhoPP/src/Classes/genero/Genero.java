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
    private String genero;

    public Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return this.genero;
    }
    
    
}
