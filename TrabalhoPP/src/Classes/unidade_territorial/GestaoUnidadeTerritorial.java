/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.unidade_territorial;

import Exceptions.UnidadeTerritorialException;
import Interfaces.GestorUnidadeTerritorialContrato;
import Interfaces.TipoUnidadeTerritorialContrato;
import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class GestaoUnidadeTerritorial extends Resources.ContainerOfObjects implements GestorUnidadeTerritorialContrato {

    @Override
    public boolean adicionarUT(UnidadeTerritorialContrato utc) throws UnidadeTerritorialException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarUT() throws UnidadeTerritorialException {
        try {
        } catch(Exception e)  {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

    }

    @Override
    public void listarUT(TipoUnidadeTerritorialContrato tutc) throws UnidadeTerritorialException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadeTerritorialContrato getUT(int i) throws UnidadeTerritorialException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadeTerritorialContrato[] getUTsPorTipo(TipoUnidadeTerritorialContrato tutc) throws UnidadeTerritorialException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosicao(UnidadeTerritorialContrato utc) throws UnidadeTerritorialException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
