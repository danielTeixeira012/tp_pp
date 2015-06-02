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

import Classes.salario.gestorSalario;
import Exceptions.UnidadeTerritorialException;
import Interfaces.TipoUnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class UnidadeTerritorial extends UnidadeTerritorialException implements Interfaces.UnidadeTerritorialContrato {

    private String nome;
    private TipoUnidadeTerritorial tipo;
    private gestorSalario gestaoSal;

    /**
     *
     * @param nome
     * @param tipo
     */
    public UnidadeTerritorial(String nome, TipoUnidadeTerritorial tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public gestorSalario getGestaoSal() {
        return this.gestaoSal;
    }

    /**
     *
     * @param gestaoSal
     */
    public void setGestaoSal(gestorSalario gestaoSal) {
        this.gestaoSal = gestaoSal;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoUnidadeTerritorial tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    @Override
    public String getNome() {
        return this.nome;
    }

    /**
     *
     * @param string
     */
    @Override
    public void setNome(String string) {
        this.nome = string;
    }

    /**
     *
     * @param tutc
     */
    @Override
    public void setTipo(TipoUnidadeTerritorialContrato tutc) {
        this.tipo = (TipoUnidadeTerritorial) tutc;
    }

    /**
     *
     * @return
     */
    @Override
    public TipoUnidadeTerritorialContrato getTipo() {
        return this.tipo;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public String getTipoUt() {

        return this.tipo.getTipo();

    }

    @Override
    public String toString() {
        return "\nUnidadeTerritorial \n" + "nome:" + this.nome + "," + this.tipo.toString() + this.gestaoSal.SalariosToString();

    }

}
