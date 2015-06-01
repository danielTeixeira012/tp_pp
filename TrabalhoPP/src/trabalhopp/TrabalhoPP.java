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
import Exceptions.RegistoSalarioException;
import Exceptions.UnidadeTerritorialException;

/**
 *
 * @author danielteixeira
 */
public class TrabalhoPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnidadeTerritorialException, RegistoSalarioException {
        // TODO code application logic here
        TipoUnidadeTerritorial nuts = new TipoUnidadeTerritorial("NUTS");
        TipoUnidadeTerritorial nuts1 = new TipoUnidadeTerritorial("NUTS1");
        TipoUnidadeTerritorial nuts2 = new TipoUnidadeTerritorial("NUTS2");
        TipoUnidadeTerritorial nuts3 = new TipoUnidadeTerritorial("NUTS3");
        TipoUnidadeTerritorial municipio = new TipoUnidadeTerritorial("MUNICIPIO");

        Genero masc = new Genero("Masculino");
        Genero fem = new Genero("Feminino");
        Genero total = new Genero("Total");

        Ano ano2002 = new Ano(2002);
        Ano ano2003 = new Ano(2003);
        Ano ano2004 = new Ano(2004);
        Ano ano2005 = new Ano(2005);
        Ano ano2006 = new Ano(2006);
        Ano ano2007 = new Ano(2007);
        Ano ano2008 = new Ano(2008);
        Ano ano2009 = new Ano(2009);
        Ano ano2010 = new Ano(2010);
        Ano ano2011 = new Ano(2011);
        Ano ano2012 = new Ano(2012);
        Ano ano2013 = new Ano(2013);

        UnidadeTerritorial utPortugal = new UnidadeTerritorial("Portugal", nuts);
        gestorSalario gestorSal = new gestorSalario();
        utPortugal.setGestaoSal(gestorSal);
        Salario sal1 = new Salario(ano2002, masc, 500.1f, utPortugal);
        Salario sal2 = new Salario(ano2002, fem, 400.2f, utPortugal);
        Salario sal3 = new Salario(ano2002, total, 450.5f, utPortugal);

        utPortugal.getGestaoSal().addRegistoSalario(sal1);
        utPortugal.getGestaoSal().addRegistoSalario(sal2);
        utPortugal.getGestaoSal().addRegistoSalario(sal3);

        UnidadeTerritorial un2 = new UnidadeTerritorial("Continente", nuts1);
        
        
        UnidadeTerritorial un3 = new UnidadeTerritorial("Norte", nuts2);
        UnidadeTerritorial un4 = new UnidadeTerritorial("Tamega", nuts3);
        UnidadeTerritorial un5 = new UnidadeTerritorial("Amarante", municipio);
        UnidadeTerritorial un6 = new UnidadeTerritorial("Felgueiras", municipio);
        UnidadeTerritorial un7 = new UnidadeTerritorial("Penafiel", municipio);
        UnidadeTerritorial un8 = new UnidadeTerritorial("Madeira", nuts1);

        GestaoUnidadeTerritorial gut = new GestaoUnidadeTerritorial();
        gut.adicionarUT(utPortugal);
        gut.adicionarUT(un2);
        gut.adicionarUT(un3);
        gut.adicionarUT(un4);
        gut.adicionarUT(un5);
        gut.adicionarUT(un6);
        gut.adicionarUT(un7);
        gut.adicionarUT(un8);

        MapeamentoDemo m1 = new MapeamentoDemo(gut.getUts());
        m1.printAll();

    }

}
