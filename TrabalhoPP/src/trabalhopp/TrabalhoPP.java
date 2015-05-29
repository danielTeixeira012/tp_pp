/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopp;

import Classes.Mapeamento.Mapeamento;
import Classes.Mapeamento.MapeamentoTipoUt;
import Classes.ano.Ano;
import Classes.genero.Genero;
import Classes.salario.Salario;
import Classes.unidade_territorial.GestaoUnidadeTerritorial;
import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
import Exceptions.UnidadeTerritorialException;

/**
 *
 * @author danielteixeira
 */
public class TrabalhoPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnidadeTerritorialException {
        // TODO code application logic here
        TipoUnidadeTerritorial nuts = new TipoUnidadeTerritorial("NUTS");
        TipoUnidadeTerritorial nuts1 = new TipoUnidadeTerritorial("NUTS1");
        TipoUnidadeTerritorial nuts2 = new TipoUnidadeTerritorial("NUTS2");
        TipoUnidadeTerritorial nuts3 = new TipoUnidadeTerritorial("NUTS3");
        TipoUnidadeTerritorial municipio = new TipoUnidadeTerritorial("MUNICIPIO");
        
        Genero masc = new Genero("masculino");
        Genero fem = new Genero("feminino");
        
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
        
        Salario s1 = new Salario(ano2002, masc, 500.1f);
        Salario s2 = new Salario(ano2002, masc, 800.1f);
        Salario s3 = new Salario(ano2002, masc, 640.1f);
        Salario s4 = new Salario(ano2002, masc, 320.1f);
        Salario[] as1 = {s1,s2,s3,s4};
        
        
        UnidadeTerritorial un1 = new UnidadeTerritorial("Portugal", nuts, as1);
        UnidadeTerritorial un2 = new UnidadeTerritorial("Continente", nuts1, as1);
        UnidadeTerritorial un3 = new UnidadeTerritorial("Madeira", nuts1, as1);
        UnidadeTerritorial un4 = new UnidadeTerritorial("Norte", nuts2, as1);
        UnidadeTerritorial un5 = new UnidadeTerritorial("Tamega", nuts3, as1);
        UnidadeTerritorial un6 = new UnidadeTerritorial("Amarante", municipio, as1);
        UnidadeTerritorial un7 = new UnidadeTerritorial("Felgueiras", municipio, as1);
        UnidadeTerritorial un8 = new UnidadeTerritorial("Penafiel", municipio, as1);
        
        GestaoUnidadeTerritorial gut = new GestaoUnidadeTerritorial(8);
        System.out.println(un1.getTipo());
        System.out.println(un2.getTipo());
        System.out.println(un3.getTipo());
        System.out.println(un4.getTipo());
        System.out.println(un5.getTipo());
        System.out.println(un6.getTipo());
        System.out.println(un7.getTipo());
        System.out.println(un8.getTipo());
         
        Mapeamento m1 = new Mapeamento(gut);
        gut.adicionarUT(un1);
        gut.adicionarUT(un2);
        gut.adicionarUT(un3);
        gut.adicionarUT(un4);
        gut.adicionarUT(un5);
        gut.adicionarUT(un6);
        gut.adicionarUT(un7);
        gut.adicionarUT(un8);
        
        
        
        
        
        
        
        
        
         
        
        
        
        
        
    }
    
}
