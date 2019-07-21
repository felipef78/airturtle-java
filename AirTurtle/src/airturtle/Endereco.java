/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;
//
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ronnie
 */
public class Endereco implements Serializable{

    private String rua;
    private String bairro;
    private String complemento;
    private String numero;
    private String CEP;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String complemento, String numero, String CEP, String cidade, String estado, String pais) throws ArrayIndexOutOfBoundsException {
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.CEP = CEP;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void setCampos(List<Object> campos) {
        this.setRua(campos.get(0).toString());
        this.setBairro(campos.get(1).toString());
        this.setComplemento(campos.get(2).toString());
        this.setNumero(campos.get(3).toString());
        this.setCEP(campos.get(4).toString());
        this.setCidade(campos.get(5).toString());
        this.setEstado(campos.get(6).toString());
        this.setPais(campos.get(7).toString());
    }
    
    public String getFEnd (){
        String s = new String();
        s = this.getPais()+", "+this.getCidade()+", "+this.getEstado()+", "+this.getRua()+" "+this.getNumero()+" "+this.getComplemento()+", "+this.getBairro();
        return s;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEstado() {
        return estado;
    }

    public String getNumero() {
        return numero;
    }

    public String getPais() {
        return pais;
    }

    public String getRua() {
        return rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
