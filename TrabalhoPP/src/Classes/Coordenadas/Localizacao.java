package Classes.Coordenadas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Enumerations.Language;
import Exceptions.CoordinatesNotFound;
import geocoderapi.CalculateCoordinates;
import geocoderapi.Coordinate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielteixeira
 */
public class Localizacao {
    private String Location;
    private Language language;
    private Coordinate coordinate;

    public Localizacao(String Location, Language language) throws IOException, CoordinatesNotFound {
        this.Location = Location;
        this.language = language;
        try{
        this.coordinate = CalculateCoordinates.getCoordinate(this.Location, language.PT);
        } catch (IOException| CoordinatesNotFound | NullPointerException ex) {

        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    
    
    
    
    
    
    
}
