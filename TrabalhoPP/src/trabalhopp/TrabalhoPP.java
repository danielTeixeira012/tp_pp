/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopp;

import Classes.Mapeamento.MapeamentoDemo;
import Classes.ano.Ano;
import Classes.genero.Genero;
import Classes.salario.Salario;
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
import Resources.Location;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author danielteixeira
 */
public class TrabalhoPP {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws UnidadeTerritorialException, RegistoSalarioException, CoordinatesNotFound, IOException {

        // TODO code application logic here
        TipoUnidadeTerritorial nuts = new TipoUnidadeTerritorial("NUTS2003");
        TipoUnidadeTerritorial nuts1 = new TipoUnidadeTerritorial("NUTS1");
        TipoUnidadeTerritorial nuts2 = new TipoUnidadeTerritorial("NUTS2");
        TipoUnidadeTerritorial nuts3 = new TipoUnidadeTerritorial("NUTS3");
        TipoUnidadeTerritorial municipio = new TipoUnidadeTerritorial("MUNICIPIO");

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

        MapeamentoDemo m1 = new MapeamentoDemo(uts);
        m1.printMap(0);
        //Location local = new Location("Amarante,Porto,Portugal", Language.PT);

    }

}
