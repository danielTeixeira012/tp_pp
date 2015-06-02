/*  
 * Nome: Ivo Lopes Ribeiro  
 * Número: 8130258  
 * Turma: 3 
 *  
 * Nome: Daniel Filipe da Costa Teixeira  
 * Número: 8140360 
 * Turma: 2  
 */

package Resources.Files;

import Classes.ano.Ano;
import Classes.genero.Genero;
import Classes.salario.Salario;
import Classes.salario.gestorSalario;
import Classes.unidade_territorial.GestaoUnidadeTerritorial;
import Classes.unidade_territorial.TipoUnidadeTerritorial;
import Classes.unidade_territorial.UnidadeTerritorial;
import Exceptions.RegistoSalarioException;
import Exceptions.UnidadeTerritorialException;
import Interfaces.GestorUnidadeTerritorialContrato;
import Interfaces.UnidadeTerritorialContrato;
import Resources.ContainerOfObjects;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 *
 * @author aluno
 */
public class Ficheiro {

    private String charset;
    private File file;

    /**
     *
     * @param file
     * @param charset
     */
    public Ficheiro(File file, String charset) {
        this.file = file;
        this.charset = charset;

    }

    /**
     *
     * @param objVector
     * @return
     */
    public static String[] castToString(Object[] objVector) {

        String[] strings = new String[objVector.length];
        for (int i = 0; i < objVector.length; i++) {
            strings[i] = (String) objVector[i];
        }

        return strings;

    }

    /**
     *
     * @return
     */
    public Object[] readFile() {
        ContainerOfObjects lineContainer = new ContainerOfObjects();
        Charset charset = Charset.forName(this.charset);
        try (BufferedReader reader = Files.newBufferedReader(this.file.toPath(), charset)) {
            String line = null;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    count++;
                } else {
                    lineContainer.addObject(line);
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return lineContainer.getObjects();
    }

    /**
     *
     * @param line
     * @param character
     * @return
     */
    public String[] parseLine(String line, Character character) {

        return line.split(";");

    }
//Le do ficheiro 

    /**
     *
     * @param lines
     * @param character
     * @param anos
     * @return
     * @throws UnidadeTerritorialException
     * @throws RegistoSalarioException
     */
    public UnidadeTerritorialContrato[] parseLines(String[] lines, Character character, Ano[] anos) throws UnidadeTerritorialException, RegistoSalarioException {
        int count = 0;
        GestaoUnidadeTerritorial gestaoUnidadeTerritorial = new GestaoUnidadeTerritorial();
        for (String line : lines) {
            String[] linha = parseLine(line, character);
            UnidadeTerritorial ut;
            ut = new UnidadeTerritorial(linha[1], new TipoUnidadeTerritorial(linha[0]));
            ut.setGestaoSal(new gestorSalario());
            int j = 0;
            for (int i = 2; i <= 7; i++) {
                if (!"x".equals(linha[i]) && !" x".equals(linha[i])) {
                    float sal = gestorSalario.StringToFloat(linha[i]);
                    Salario salario = new Salario(anos[j], new Genero("Total"), sal, ut);
                    ut.getGestaoSal().addRegistoSalario(salario);
                    j++;
                }
            }
            j = 0;
            for (int i = 8; i <= 13; i++) {
                if (!"x".equals(linha[i]) && !" x".equals(linha[i])) {
                    float sal = gestorSalario.StringToFloat(linha[i]);
                    Salario salario = new Salario(anos[j], new Genero("Masculino"), sal, ut);
                    ut.getGestaoSal().addRegistoSalario(salario);
                    j++;
                }
            }
            j = 0;
            for (int i = 14; i <= 19; i++) {
                if (!"x".equals(linha[i]) && !" x".equals(linha[i])) {
                    float sal = gestorSalario.StringToFloat(linha[i]);
                    Salario salario = new Salario(anos[j], new Genero("Feminino"), sal, ut);
                    ut.getGestaoSal().addRegistoSalario(salario);
                    j++;
                }
            }
            gestaoUnidadeTerritorial.adicionarUT(ut);
        }
        return gestaoUnidadeTerritorial.getUts();
    }

}
