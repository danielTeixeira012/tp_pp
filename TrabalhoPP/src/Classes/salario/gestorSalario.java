/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.salario;

import Exceptions.RegistoSalarioException;
import Interfaces.GestorSalariosContrato;
import Interfaces.TipoUnidadeTerritorialContrato;
import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class gestorSalario extends Resources.ContainerOfObjects implements GestorSalariosContrato {

    public gestorSalario() {
    }

    public gestorSalario(int size) {
        super(size);
    }
    
    

    @Override
    public boolean addRegistoSalario(Object o) throws RegistoSalarioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getSalarios(UnidadeTerritorialContrato[] utcs, Object[] os, Object[] os1) throws RegistoSalarioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getSalarios(Object[] os, Object[] os1, TipoUnidadeTerritorialContrato tutc) throws RegistoSalarioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getSalario(int i) throws RegistoSalarioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
