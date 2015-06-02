/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopp;

import Classes.Coordenadas.GestaoLocalizacao;
import Classes.Coordenadas.GestaoMarkers;
import Classes.Coordenadas.Localizacao;
import Classes.Mapeamento.MapeamentoDemo;
import Classes.ano.Ano;
import Classes.genero.Genero;
import Classes.salario.gestorSalario;
import Classes.unidade_territorial.GestaoUnidadeTerritorial;
import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
import Enumerations.Language;
import Exceptions.CoordinatesNotFound;
import Exceptions.RegistoSalarioException;
import Exceptions.UnidadeTerritorialException;
import Interfaces.UnidadeTerritorialContrato;
import Resources.Files.Ficheiro;
import googlemapsapis.Gmaps;
import googlemapsapis.MyMarker;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author danielteixeira
 */
public class TrabalhoPP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnidadeTerritorialException, RegistoSalarioException {
        
        TipoUnidadeTerritorial nuts = new TipoUnidadeTerritorial("NUTS2013");
        TipoUnidadeTerritorial nuts1 = new TipoUnidadeTerritorial("NUTS I");
        TipoUnidadeTerritorial nuts2 = new TipoUnidadeTerritorial("NUTS II");
        TipoUnidadeTerritorial nuts3 = new TipoUnidadeTerritorial("NUTS III");
        TipoUnidadeTerritorial municipio = new TipoUnidadeTerritorial("Município");
        
        Genero masc = new Genero("Masculino");
        Genero fem = new Genero("Feminino");
        Genero total = new Genero("Total");
        
        Ano ano2002 = new Ano(2002);
        Ano ano2009 = new Ano(2009);
        Ano ano2010 = new Ano(2010);
        Ano ano2011 = new Ano(2011);
        Ano ano2012 = new Ano(2012);
        Ano ano2013 = new Ano(2013);
        Ano[] anos = {ano2002, ano2009, ano2010, ano2011, ano2012, ano2013};
        
        File file = new File("DadosSuporte.csv");
        Ficheiro ficheiro = new Ficheiro(file, "ISO-8859-1");
        String[] linhas = Ficheiro.castToString(ficheiro.readFile());
        UnidadeTerritorialContrato[] uts = ficheiro.parseLines(linhas, ';', anos);
        GestaoUnidadeTerritorial gut = new GestaoUnidadeTerritorial(uts);
        MapeamentoDemo m1 = new MapeamentoDemo(uts);
        m1.printMap(0);
        
        Genero[] generos1 = {fem, masc, total};
        Ano[] anos1 = {ano2002, ano2013};

        //implmentação do getUts atraves de vetor de Unidades Territoriais
        UnidadeTerritorial[] vetorCasted = GestaoUnidadeTerritorial.castToUnidadeTerritorial(gut.getUTsPorTipo(municipio));
        //gutMunicipios - vetor municipios 
        GestaoUnidadeTerritorial gutMunicipios = new GestaoUnidadeTerritorial(vetorCasted);
        gestorSalario gestorSal = new gestorSalario();
        //responasvel por retornar os salarios 
        gestorSalario gestorSalarios = new gestorSalario(gestorSalario.castToSalarios(gestorSal.getSalarios(gut.getUTsPorTipo(municipio), anos1, generos1)));

        //implementação do getUts atraves do tipo
        Gmaps map = new Gmaps();
        GestaoLocalizacao gl1 = new GestaoLocalizacao();
        GestaoMarkers gm1 = new GestaoMarkers();
        
        for (int i = 0; i < 10; i++) {
            
            UnidadeTerritorial utTemp = (UnidadeTerritorial) gutMunicipios.getUT(i);
            try {
                Localizacao lTemp = new Localizacao(utTemp.getNome() + ",Portugal", Language.PT);     
                MyMarker mTemp = new MyMarker(utTemp.getNome(), lTemp.getCoordinate().getLatitude(), lTemp.getCoordinate().getLongitude(), utTemp.getGestaoSal().SalariosToString());
                map.addMarker(mTemp);
            } catch (CoordinatesNotFound exc) {
                exc.getMessage();
            } catch (IOException exc) {
                exc.getMessage();
            } catch (NullPointerException exc) {
                exc.getMessage();
            }
        }
        
        map.startMap(41.366700, -8.194861, 10);
    }
    
}
