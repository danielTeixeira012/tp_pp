/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources.Files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author aluno
 */
public class WriteObj {

    public WriteObj(String filePad, Object obj) throws IOException {

        // Write Object
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filePad));

        out.writeObject(obj);

    }

}
