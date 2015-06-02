package Classes.Coordenadas;

/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */
import Enumerations.Language;
import Exceptions.CoordinatesNotFound;
import geocoderapi.CalculateCoordinates;
import geocoderapi.Coordinate;
import java.io.IOException;

/**
 *
 * @author danielteixeira
 */
public class Localizacao {

    private String Location;
    private Language language;
    private Coordinate coordinate;

    /**
     *
     * @param Location
     * @param language
     * @throws IOException
     * @throws CoordinatesNotFound
     */
    public Localizacao(String Location, Language language) throws IOException, CoordinatesNotFound {
        this.Location = Location;
        this.language = language;
        try {
            this.coordinate = CalculateCoordinates.getCoordinate(this.Location, language.PT);
        } catch (IOException | CoordinatesNotFound | NullPointerException ex) {

        }
    }

    /**
     *
     * @return
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     *
     * @param coordinate
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return Location;
    }

    /**
     *
     * @param Location
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     *
     * @return
     */
    public Language getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

}
