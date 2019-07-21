/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

/**
 *
 * @author Felipe
 */
class AeronaveIndisponivelException extends Exception {

    private String msg;

    public AeronaveIndisponivelException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
