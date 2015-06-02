/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.Mapeamento;

import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author danielteixeira
 */
public class Mapeamento {

    private UnidadeTerritorialContrato ut;
    private Mapeamento[] mapeamentosFilho;

    /**
     *
     * @param ut
     */
    public Mapeamento(UnidadeTerritorialContrato ut) {
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento();
        this.mapeamentosFilho = gestaoMapeamentosFilho.getMaps();
        this.ut = ut;
    }

    /**
     *
     * @return
     */
    public UnidadeTerritorialContrato getUt() {
        return ut;
    }

    /**
     *
     * @param ut
     */
    public void setUt(UnidadeTerritorialContrato ut) {
        this.ut = ut;
    }

    /**
     *
     * @param mapeamentoFilho
     */
    public void addMapeamentoFilho(Mapeamento mapeamentoFilho) {
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento(this.mapeamentosFilho);
        gestaoMapeamentosFilho.addMap(mapeamentoFilho);
        this.mapeamentosFilho = gestaoMapeamentosFilho.getMaps();
    }

    /**
     *
     * @return
     */
    public Mapeamento[] getMapeamentosFilho() {
        return this.mapeamentosFilho;
    }

    /**
     *
     * @param indice
     * @return
     */
    public Mapeamento getMapeamentoFilho(int indice) {
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento(this.mapeamentosFilho);
        return (Mapeamento) gestaoMapeamentosFilho.getMap(indice);
    }

    @Override
    public String toString() {
        String str = "";
        str = str + this.ut.toString();
        GestaoMapeamento gestaoMapeamentosFilho = new GestaoMapeamento(this.mapeamentosFilho);
        int filhosN = gestaoMapeamentosFilho.countObject();
        if (filhosN != 0) {
            str = str + "\nFilhos:\n";
            for (Mapeamento mapFilho : (Mapeamento[]) this.mapeamentosFilho) {
                str = str + "\n----------------------------------------------------\n";
                str = str + "Filho da Unidade territorial " + this.ut.getNome();
                str = str + "\n----------------------------------------------------";

                str = str + mapFilho.toString();
            }
        } else {
            str = str + "\nEsta unidade Territorial não possui filhos\n";
        }
        return str;
    }

}
