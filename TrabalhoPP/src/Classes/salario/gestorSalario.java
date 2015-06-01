/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.salario;

import Classes.unidade_territorial.GestaoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
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
        boolean toReturn = this.addObject(o);
        if (toReturn == true) {
            System.out.println("O salario foi adicionado com sucesso");
            return toReturn;
        } else {
            System.out.println("O salario não foi adicionado!!!");
            return toReturn;
        }
    }

    @Override
    public Object[] getSalarios(UnidadeTerritorialContrato[] utcs, Object[] os, Object[] os1) throws RegistoSalarioException {
        gestorSalario tempContainer1 = new gestorSalario();
        //tempContainer1.getObjects();
        gestorSalario tempContainer2 = new gestorSalario();

        for (int i = 0; i < utcs.length; i++) {
            UnidadeTerritorial utTemp = (UnidadeTerritorial) utcs[i];
            Salario[] sTemp = utTemp.getSalarios();
            for (int z = 0; z < os1.length; z++) {
                for (int t = 0; t < sTemp.length; t++) {
                    if (sTemp[z].getGeneroSalario() == os1[z]) {
                        tempContainer1.addObject(sTemp[z]);
                    }
                }
            }
            for (int j = 0; j < os.length; j++) {
                for (int x = 0; x < tempContainer1.countObject(); x++) {
                    if (sTemp[j].getAno() == os[x]) {
                        tempContainer2.addObject(sTemp[j]);
                    }
                }
            }
        }

        return tempContainer2.castVector(os);
    }

    @Override
    public Object[] getSalarios(Object[] os, Object[] os1, TipoUnidadeTerritorialContrato tutc) throws RegistoSalarioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getSalario(int i) throws RegistoSalarioException {
        return this.getObject(i);
    }

}
