/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

public class CPF_InvalidoException extends Exception {

    private String msg;

    public CPF_InvalidoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
