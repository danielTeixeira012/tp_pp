/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.unidade_territorial;

import Exceptions.RegistoSalarioException;
import Exceptions.UnidadeTerritorialException;
import Interfaces.GestorUnidadeTerritorialContrato;
import Interfaces.TipoUnidadeTerritorialContrato;
import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class GestaoUnidadeTerritorial extends Resources.ContainerOfObjects implements GestorUnidadeTerritorialContrato {

    public GestaoUnidadeTerritorial(Object[] objects) {
        super(objects);
    }

    public GestaoUnidadeTerritorial() {
    }

    public GestaoUnidadeTerritorial(int size) {
        super(size);
    }

    @Override
    public boolean adicionarUT(UnidadeTerritorialContrato utc) throws UnidadeTerritorialException {
        if (utc != null) {
            if (findObject(utc) == -1) {
                boolean toReturn = this.addObject(utc);
                if (toReturn == true) {
                    System.out.println("A unidade territorial foi adicionada com sucesso.");
                    return toReturn;
                } else {
                    System.out.println("A unidade territorial não foi adicionada!!!");
                    return toReturn;
                }
            } else {
                throw new UnidadeTerritorialException("O ficheiro ja se encontra no vetor!");
            }

        } else {
            throw new UnidadeTerritorialException("O objeto enviado é nulo!");
        }
    }

    /**
     * *
     * lista cada ut individualmente
     *
     * @param ut recebe uma unidade Territorial
     * @throws UnidadeTerritorialException
     */
    public void listarUTindividual(UnidadeTerritorialContrato ut) throws UnidadeTerritorialException {
        UnidadeTerritorial castedUt = (UnidadeTerritorial) ut;
        System.out.println(castedUt.toString());
    }

    /**
     * lista todas as unidades territoriais
     *
     * @throws UnidadeTerritorialException
     */
    @Override
    public void listarUT() throws UnidadeTerritorialException {
        if (super.countObject() == 0) {
            throw new UnidadeTerritorialException("Não existem elementos no vetor!");
        }
        for (UnidadeTerritorialContrato ut : (UnidadeTerritorialContrato[]) this.getUts()) {
            this.listarUTindividual(ut);
        }

    }

    /**
     * listar um array de uts
     *
     * @param uts
     * @throws UnidadeTerritorialException
     */
    public void listarUTs(UnidadeTerritorialContrato[] uts) throws UnidadeTerritorialException {

        for (UnidadeTerritorialContrato ut : (UnidadeTerritorialContrato[]) uts) {
            this.listarUTindividual(ut);
        }

    }

    /**
     * lista unidades territoriais por tipo
     *
     * @param tutc
     * @throws UnidadeTerritorialException
     */
    @Override
    public void listarUT(TipoUnidadeTerritorialContrato tutc) throws UnidadeTerritorialException {

        this.listarUTs(this.getUTsPorTipo(tutc));
    }

    @Override
    public UnidadeTerritorialContrato getUT(int i) throws UnidadeTerritorialException {
        if (i > this.countObject() - 1) {
            throw new UnidadeTerritorialException("A posiçao enviada não existe");
        }
        return (UnidadeTerritorialContrato) super.getObject(i);
    }

    public UnidadeTerritorialContrato[] getUts() throws UnidadeTerritorialException {
        UnidadeTerritorialContrato[] uts = new UnidadeTerritorialContrato[this.getTamanho()];
        for (int i = 0; i < this.getTamanho(); i++) {
            uts[i] = (UnidadeTerritorial) this.getUT(i);
        }

        return uts;
    }

    @Override
    public UnidadeTerritorialContrato[] getUTsPorTipo(TipoUnidadeTerritorialContrato tutc) throws UnidadeTerritorialException {
        GestaoUnidadeTerritorial tempContainer = new GestaoUnidadeTerritorial();
        tempContainer.getObjects();

        for (UnidadeTerritorialContrato ut : this.getUts()) {
            if (ut.getTipo() == tutc) {
                tempContainer.addObject(ut);
            }
        }
        if (tempContainer.countObject() == 0) {
            throw new UnidadeTerritorialException("Não existem unidades territorias do tipo inserido!");
        }
        UnidadeTerritorialContrato[] toReturn = (UnidadeTerritorialContrato[]) tempContainer.getUts();
        return toReturn;

    }

    @Override
    public int getTamanho() {
        return super.countObject();
    }

    @Override
    public int getPosicao(UnidadeTerritorialContrato utc) throws UnidadeTerritorialException {
        UnidadeTerritorial utcCasted = (UnidadeTerritorial) utc;
        if (this.countObject() == 0) {
            throw new UnidadeTerritorialException("Não existem unidades territoriais");
        }
        if (findObject(utc) == -1) {
            throw new UnidadeTerritorialException("A unidade territoria não se encontra no vetor");
        }

        return findObject(utc);
    }

    public static UnidadeTerritorial[] castToUnidadeTerritorial(Object[] objVector) {
        UnidadeTerritorial[] uts = new UnidadeTerritorial[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            uts[i] = (UnidadeTerritorial) objVector[i];
        }

        return uts;
    }

    
}
