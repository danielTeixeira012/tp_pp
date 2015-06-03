/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.unidade_territorial;

import Exceptions.RegistoSalarioException;
import Exceptions.UnidadeTerritorialException;
import Interfaces.GestorUnidadeTerritorialContrato;
import Interfaces.TipoUnidadeTerritorialContrato;
import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * classe de instanciaçõa da gestaoUnidadeTerritorial
 */
public class GestaoUnidadeTerritorial extends Resources.ContainerOfObjects implements GestorUnidadeTerritorialContrato {

    /**
     * construtor da classe GestaoUnidadeTerritorial que inicia com um vetor
     * UnidadeTerritorialContrato
     *
     * @param objects
     */
    public GestaoUnidadeTerritorial(UnidadeTerritorialContrato[] objects) {
        super(objects);
    }

    /**
     * construtor da classe GestaoUnidadeTerritorial que inicia uma
     * GestaoUnidadeTerritorial
     */
    public GestaoUnidadeTerritorial() {
    }

    /**
     * ocnstrutor da classe GestaoUnidadeTerritorial que inicia uma
     * GestaoUnidadeTerritorial com um tamanho
     *
     * @param size
     */
    public GestaoUnidadeTerritorial(int size) {
        super(size);
    }

    /**
     * metodo responsavel por adicionar uma unidade territorial a uma
     * GestaoUnidadeTerritorial
     *
     * @param utc unidade territorial
     * @return
     * @throws UnidadeTerritorialException
     */
    @Override
    public boolean adicionarUT(UnidadeTerritorialContrato utc) throws UnidadeTerritorialException {
        if (utc != null) {
            if (findObject(utc) == -1) {
                boolean toReturn = this.addObject(utc);
                if (toReturn == true) {
                    //System.out.println("A unidade territorial foi adicionada com sucesso.");
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
     * lista cada unidade territorial individualmente
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
     * listar um array de unidades territoriais
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

    /**
     * obtem a unidade territorial de uma determinada posição
     *
     * @param i posiçao do vetor a retornar
     * @return
     * @throws UnidadeTerritorialException
     */
    @Override
    public UnidadeTerritorialContrato getUT(int i) throws UnidadeTerritorialException {
        if (i > this.countObject() - 1) {
            throw new UnidadeTerritorialException("A posiçao enviada não existe");
        }
        return (UnidadeTerritorialContrato) super.getObject(i);
    }

    /**
     * obtem todas as unidades territoriais de um vetor de unidades territoriais
     *
     * @return
     * @throws UnidadeTerritorialException
     */
    public UnidadeTerritorialContrato[] getUts() throws UnidadeTerritorialException {
        UnidadeTerritorialContrato[] uts = new UnidadeTerritorialContrato[this.getTamanho()];
        for (int i = 0; i < this.getTamanho(); i++) {
            uts[i] = (UnidadeTerritorial) this.getUT(i);
        }

        return uts;
    }

    /**
     * obtem as unidades de um determinado tipo
     *
     * @param tutc
     * @return
     * @throws UnidadeTerritorialException
     */
    @Override
    public UnidadeTerritorialContrato[] getUTsPorTipo(TipoUnidadeTerritorialContrato tutc) throws UnidadeTerritorialException {
        GestaoUnidadeTerritorial tempContainer = new GestaoUnidadeTerritorial();
        tempContainer.getObjects();
        TipoUnidadeTerritorial tut = (TipoUnidadeTerritorial) tutc;
        for (UnidadeTerritorial ut : GestaoUnidadeTerritorial.castToUnidadeTerritorial(this.getUts())) {

            if (ut.getTipoUt().equals(tut.getTipo())) {
                tempContainer.addObject(ut);
            }
        }
        if (tempContainer.countObject() == 0) {
            throw new UnidadeTerritorialException("Não existem unidades territorias do tipo inserido!");
        }
        UnidadeTerritorialContrato[] toReturn = (UnidadeTerritorialContrato[]) tempContainer.getUts();
        return toReturn;

    }

    public UnidadeTerritorial getUtporNome(String nomeUt) throws UnidadeTerritorialException {
        UnidadeTerritorial tempUt = null;
        for (UnidadeTerritorial ut : GestaoUnidadeTerritorial.castToUnidadeTerritorial(this.getUts())) {
            if (nomeUt.equals(ut.getNome())) {
                tempUt = ut;
            }
        }
        return tempUt;

    }

    /**
     * conta o tamanhao de um vetor de gestao de unidades territoriais
     *
     * @return
     */
    @Override
    public int getTamanho() {
        return super.countObject();
    }

    /**
     * obtem a posição de uma unidade territorial
     *
     * @param utc
     * @return
     * @throws UnidadeTerritorialException
     */
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

    /**
     * converte um vetor de objetos num vetor de unidades territoriais
     *
     * @param objVector
     * @return
     */
    public static UnidadeTerritorial[] castToUnidadeTerritorial(Object[] objVector) {
        UnidadeTerritorial[] uts = new UnidadeTerritorial[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            uts[i] = (UnidadeTerritorial) objVector[i];
        }

        return uts;
    }

    /**
     * concatena dois vetores de unidades territoriais
     *
     * @param a
     * @param b
     * @return
     */
    public static UnidadeTerritorial[] concat(UnidadeTerritorial[] a, UnidadeTerritorial[] b) {
        int aLen = a.length;
        int bLen = b.length;
        UnidadeTerritorial[] c = new UnidadeTerritorial[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

}
