
import Exceptions.RegistoSalarioException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielteixeira
 */
public class SalariosException extends RegistoSalarioException {

    /**
     * Creates a new instance of <code>SalariosException</code> without detail
     * message.
     */
    public SalariosException() {
    }

    /**
     * Constructs an instance of <code>SalariosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SalariosException(String msg) {
        super(msg);
    }
}
