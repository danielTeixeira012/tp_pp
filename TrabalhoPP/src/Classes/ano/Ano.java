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
 *
 * @author aluno
 */
public class Ano {
    private int ano;

    /**
     *
     * @param ano
     */
    public Ano(int ano) {
        this.ano = ano;
    }

    /**
     *
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     *
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
