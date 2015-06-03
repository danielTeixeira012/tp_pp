/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources.Files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author aluno
 */
public class ReadObj {

    /**
     *
     * @param filePad
     * @param obj
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ReadObj(String filePad, Object obj) throws IOException, ClassNotFoundException {
        // Read Object
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePad));
        Object objToReturn;
        objToReturn = (Object) in.readObject();
    }

}
