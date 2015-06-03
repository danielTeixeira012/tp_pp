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

/**
 *
 * classe de instanciação de um tipo de unidade territorial
 */
public class TipoUnidadeTerritorial implements Interfaces.TipoUnidadeTerritorialContrato {
    private String tipo;

    /**
     *
     * @param tipo
     */
    public TipoUnidadeTerritorial(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "tipo:" + tipo;
    }

    
    
}
