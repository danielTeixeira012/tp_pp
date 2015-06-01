/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.unidade_territorial;

/**
 *
 * @author aluno
 */
public class TipoUnidadeTerritorial implements Interfaces.TipoUnidadeTerritorialContrato {
    private String tipo;

    public TipoUnidadeTerritorial(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "tipo:" + tipo;
    }

    
    
}
