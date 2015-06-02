/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources.Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author aluno
 */
class ShowFile {

    public static void main(String args[]) throws IOException {
        int i;
        FileInputStream fin;
        try {
            fin = new FileInputStream("DadosSuporte.csv");
        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: ShowFile File");
            return;
        }
// read bytes until EOF is encountered 
        do {
            i = fin.read();
            if (i != -1) {
                System.out.print((char) i);
            }
        } while (i != -1);
        fin.close();
    }
    
    
}
