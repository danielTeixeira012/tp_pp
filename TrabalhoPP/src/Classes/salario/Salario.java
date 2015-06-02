/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.salario;

import Classes.ano.Ano;
import Classes.genero.Genero;
import Exceptions.RegistoSalarioException;
import Interfaces.UnidadeTerritorialContrato;

/**
 *
 * @author aluno
 */
public class Salario extends RegistoSalarioException {

    private Ano ano;
    private Genero generoSalario;
    private float salario;
    private UnidadeTerritorialContrato ut;

    /**
     *
     * @param ano
     * @param generoSalario
     * @param salario
     * @param ut
     */
    public Salario(Ano ano, Genero generoSalario, float salario, UnidadeTerritorialContrato ut) {

        this.ano = ano;
        this.generoSalario = generoSalario;
        this.salario = salario;
        this.ut = ut;
    }

    /**
     *
     * @return
     */
    public Ano getAno() {
        return ano;
    }

    /**
     *
     * @param ano
     */
    public void setAno(Ano ano) {
        this.ano = ano;
    }

    /**
     *
     * @return
     */
    public Genero getGeneroSalario() {
        return generoSalario;
    }

    /**
     *
     * @param generoSalario
     */
    public void setGeneroSalario(Genero generoSalario) {
        this.generoSalario = generoSalario;
    }

    /**
     *
     * @return
     */
    public float getSalario() {
        return salario;
    }

    /**
     *
     * @param salario
     */
    public void setSalario(float salario) {
        this.salario = salario;
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

    @Override
    public String toString() {
        return "\nSalario:\n" + "ano=" + this.ano.toString() + ", generoSalario=" + this.generoSalario.toString() + ", salario=" + salario;
    }

}
