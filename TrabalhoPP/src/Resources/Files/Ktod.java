/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aluno
 */
class KtoD {

    public static void main(String args[]) throws IOException {
        String str;
        FileWriter fw;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            fw = new FileWriter("test.txt");
        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }
        System.out.println("Enter text ('stop' to quit).");
        do {
            System.out.print(": ");
            str = br.readLine();
            if (str.compareTo("stop") == 0) {
                break;
            }
            str = str + "\r\n";
// add newline 
            fw.write(str);
        } while (str.compareTo("stop") != 0);
        fw.close();
    }
}
