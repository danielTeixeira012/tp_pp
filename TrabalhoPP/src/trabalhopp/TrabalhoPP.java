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

        UnidadeTerritorial utContinente = new UnidadeTerritorial("Continente", nuts1);
        gestorSalario gestorSal2 = new gestorSalario();
        utContinente.setGestaoSal(gestorSal2);
        Salario sal4 = new Salario(ano2002, masc, 100.1f, utContinente);
        Salario sal5 = new Salario(ano2002, fem, 250.2f, utContinente);
        Salario sal6 = new Salario(ano2002, total, 1040.5f, utContinente);

        utContinente.getGestaoSal().addRegistoSalario(sal4);
        utContinente.getGestaoSal().addRegistoSalario(sal5);
        utContinente.getGestaoSal().addRegistoSalario(sal6);

        UnidadeTerritorial utNorte = new UnidadeTerritorial("Norte", nuts2);
        gestorSalario gestorSal3 = new gestorSalario();
        utNorte.setGestaoSal(gestorSal3);
        Salario sal7 = new Salario(ano2002, masc, 200.65f, utNorte);
        Salario sal8 = new Salario(ano2002, fem, 3210.2f, utNorte);
        Salario sal9 = new Salario(ano2002, total, 240.5f, utNorte);

        utNorte.getGestaoSal().addRegistoSalario(sal7);
        utNorte.getGestaoSal().addRegistoSalario(sal8);
        utNorte.getGestaoSal().addRegistoSalario(sal9);

        UnidadeTerritorial utTamega = new UnidadeTerritorial("Tamega", nuts3);
        gestorSalario gestorSal4 = new gestorSalario();
        utTamega.setGestaoSal(gestorSal4);
        Salario sal10 = new Salario(ano2002, masc, 800.1f, utTamega);
        Salario sal11 = new Salario(ano2002, fem, 700.2f, utTamega);
        Salario sal12 = new Salario(ano2002, total, 640.5f, utTamega);

        utTamega.getGestaoSal().addRegistoSalario(sal10);
        utTamega.getGestaoSal().addRegistoSalario(sal11);
        utTamega.getGestaoSal().addRegistoSalario(sal12);

        UnidadeTerritorial utAmarante = new UnidadeTerritorial("Amarante", municipio);
        gestorSalario gestorSal5 = new gestorSalario();
        utAmarante.setGestaoSal(gestorSal5);
        Salario sal13 = new Salario(ano2003, fem, 620.1f, utAmarante);
        Salario sal14 = new Salario(ano2003, fem, 510.2f, utAmarante);
        Salario sal15 = new Salario(ano2003, fem, 440.5f, utAmarante);

        utAmarante.getGestaoSal().addRegistoSalario(sal13);
        utAmarante.getGestaoSal().addRegistoSalario(sal14);
        utAmarante.getGestaoSal().addRegistoSalario(sal15);

        UnidadeTerritorial utFelgueiras = new UnidadeTerritorial("Felgueiras", municipio);
        gestorSalario gestorSal6 = new gestorSalario();
        utFelgueiras.setGestaoSal(gestorSal6);
        Salario sal16 = new Salario(ano2002, masc, 899.1f, utNorte);
        Salario sal17 = new Salario(ano2002, fem, 720.2f, utNorte);
        Salario sal18 = new Salario(ano2002, total, 688.5f, utNorte);

        utFelgueiras.getGestaoSal().addRegistoSalario(sal16);
        utFelgueiras.getGestaoSal().addRegistoSalario(sal17);
        utFelgueiras.getGestaoSal().addRegistoSalario(sal18);

        UnidadeTerritorial utPenafiel = new UnidadeTerritorial("Penafiel", municipio);
        gestorSalario gestorSal7 = new gestorSalario();
        utPenafiel.setGestaoSal(gestorSal7);
        Salario sal19 = new Salario(ano2002, masc, 710.1f, utPenafiel);
        Salario sal20 = new Salario(ano2002, fem, 340.2f, utPenafiel);
        Salario sal21 = new Salario(ano2002, total, 888.5f, utPenafiel);

        utPenafiel.getGestaoSal().addRegistoSalario(sal19);
        utPenafiel.getGestaoSal().addRegistoSalario(sal20);
        utPenafiel.getGestaoSal().addRegistoSalario(sal21);

        UnidadeTerritorial utMadeira = new UnidadeTerritorial("Madeira", nuts1);
        gestorSalario gestorSal8 = new gestorSalario();
        utMadeira.setGestaoSal(gestorSal8);
        Salario sal22 = new Salario(ano2002, masc, 288.1f, utMadeira);
        Salario sal23 = new Salario(ano2002, fem, 300.2f, utMadeira);
        Salario sal24 = new Salario(ano2002, total, 240.5f, utMadeira);

        utMadeira.getGestaoSal().addRegistoSalario(sal22);
        utMadeira.getGestaoSal().addRegistoSalario(sal23);
        utMadeira.getGestaoSal().addRegistoSalario(sal24);

        GestaoUnidadeTerritorial gut = new GestaoUnidadeTerritorial();
        gut.adicionarUT(utPortugal);
        gut.adicionarUT(utContinente);
        gut.adicionarUT(utNorte);
        gut.adicionarUT(utTamega);
        gut.adicionarUT(utAmarante);
        gut.adicionarUT(utFelgueiras);
        gut.adicionarUT(utPenafiel);
        gut.adicionarUT(utMadeira);

        MapeamentoDemo m1 = new MapeamentoDemo(gut.getUts());
        //m1.printAll();

        gestorSalario gestorSalteste = new gestorSalario();

        UnidadeTerritorial[] uts = {utAmarante};
        Ano[] anos = {ano2003};
        Genero[] generos = {fem};
        utAmarante.getGestaoSal().getSalarios(generos, anos, nuts3);
    }

}
