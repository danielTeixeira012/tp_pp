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
 *  classe de instanciação da classe salario
 */
public class Salario extends RegistoSalarioException {

    private Ano ano;
    private Genero generoSalario;
    private float salario;
    private UnidadeTerritorialContrato ut;

    /**
     * metodo construtor da classe ano
     * @param ano de um determinado salario
     * @param generoSalario de um determinado salario
     * @param salario de um determindao genero e ano par uma determinada ut
     * @param ut unidade territorial a que pertenece um territorio
     */
    public Salario(Ano ano, Genero generoSalario, float salario, UnidadeTerritorialContrato ut) {

        this.ano = ano;
        this.generoSalario = generoSalario;
        this.salario = salario;
        this.ut = ut;
    }

    /**
     * obtem o ano
     * @return ano
     */
    public Ano getAno() {
        return ano;
    }

    /**
     *define ano
     * @param ano
     */
    public void setAno(Ano ano) {
        this.ano = ano;
    }

    /**
     * obtem o genero a que pertence o salario
     * @return
     */
    public Genero getGeneroSalario() {
        return generoSalario;
    }

    /**
     * defien o genero a que pertence o salario
     * @param generoSalario
     */
    public void setGeneroSalario(Genero generoSalario) {
        this.generoSalario = generoSalario;
    }

    /**
     * obtem o salario
     * @return salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * define o salario
     * @param salario
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * obtem a unidade territorial
     * @return unidade territorial
     */
    public UnidadeTerritorialContrato getUt() {
        return ut;
    }

    /**
     * define a unidade territorial
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
