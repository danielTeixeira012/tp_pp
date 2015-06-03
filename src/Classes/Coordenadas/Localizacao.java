/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */

package Classes.Coordenadas;
import Enumerations.Language;
import Exceptions.CoordinatesNotFound;
import geocoderapi.CalculateCoordinates;
import geocoderapi.Coordinate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * classe de instanciamento de uma localização
 */
public class Localizacao {
    private String Location;
    private Language language;
    private Coordinate coordinate;

    /**
     *metodo construtor de uma localização
     * @param Location String com o nome do locar a obter coordenadas
     * @param language linguagem de pesquisa 
     * @throws IOException
     * @throws CoordinatesNotFound
     */
    public Localizacao(String Location, Language language) throws IOException, CoordinatesNotFound {
        this.Location = Location;
        this.language = language;
        try{
        this.coordinate = CalculateCoordinates.getCoordinate(this.Location, language.PT);
        } catch (IOException| CoordinatesNotFound | NullPointerException ex) {

        }
    }

    /**
     * obtem as coordenadas da localização
     * @return a coordenada da localização
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * defina as coordenadas da localização
     * @param coordinate
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * obtem o nome da localização
     * @return o nome da localização
     */
    public String getLocation() {
        return Location;
    }

    /**
     * define o nome da localização
     * @param Location
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * obtem a linguagem de pesquisa
     * @return a linguagem de pesquisa
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * define a linguagem da pesquisa
     * @param language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    
    
    
    
    
    
    
}
