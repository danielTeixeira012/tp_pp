/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
package Classes.ano;

/**
 * classe de instanciação ano
 * 
 */
public class Ano {
    private int ano;

    /**
     * construtor da classe ano
     * @param ano
     */
    public Ano(int ano) {
        this.ano = ano;
    }

    /**
     * obtem o ano
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     * define o ano
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return ""+this.ano; 
    }
    
    
    
    
    
}
