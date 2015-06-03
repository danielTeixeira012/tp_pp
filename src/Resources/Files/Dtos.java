/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources.Files;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author aluno
 */
class DtoS {

    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        fr.close();
    }
}
