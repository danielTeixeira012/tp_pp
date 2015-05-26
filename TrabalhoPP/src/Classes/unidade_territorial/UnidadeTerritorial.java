/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.unidade_territorial;

import Exceptions.UnidadeTerritorialException;
import Interfaces.TipoUnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class UnidadeTerritorial extends UnidadeTerritorialException implements Interfaces.UnidadeTerritorialContrato {

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNome(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTipo(TipoUnidadeTerritorialContrato tutc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoUnidadeTerritorialContrato getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
