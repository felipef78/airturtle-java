/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronnie
 */
public class Reserva implements Serializable{

    private int fileira_Assento;
    private int numero_Assento;
    private boolean is_Executiva;
    private String cpf_Cliente;
    private boolean ativo;
    private int id;
    private Voo voo;

    public Reserva() {
    }

    public Reserva(int fileiraAssento, int numeroAssento, boolean isExecutiva, Voo voo, String cpfCliente, int id) {
        this.fileira_Assento = fileiraAssento;
        this.numero_Assento = numeroAssento;
        this.is_Executiva = isExecutiva;
        this.voo = voo;
        this.cpf_Cliente = cpfCliente;
        this.id = id;
        this.ativo = true;
    }

    public List<String> consultarReserva(Reserva reserva) throws NumberFormatException {
        List<String> lis = new ArrayList<>();
        
       
        //lis.add(String.valueOf(reserva.getVoo().getCodigoIdentificador()));
        lis.add(String.valueOf(reserva.getFileira_Assento()));
        lis.add(String.valueOf(reserva.getNumero_Assento()));
        lis.add(String.valueOf(reserva.isIs_Executiva()));
         lis.add(reserva.getCpf_Cliente());
        lis.add(String.valueOf(reserva.isAtivo()));
        lis.add(String.valueOf(reserva.getId()));
        return lis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFileira_Assento() {
        return fileira_Assento;
    }

    public int getNumero_Assento() {
        return numero_Assento;
    }

    public Voo getVoo() {
        return voo;
    }

    public String getCpf_Cliente() {
        return cpf_Cliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public boolean isIs_Executiva() {
        return is_Executiva;
    }

    public void setFileiraAssento(char fileiraAssento) {
        this.fileira_Assento = fileiraAssento;
    }

    public void setIs_Executiva(boolean is_Executiva) {
        this.is_Executiva = is_Executiva;
    }

    public void setNumero_Assento(int numero_Assento) {
        this.numero_Assento = numero_Assento;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setCpf_Cliente(String cpf_Cliente) {
        this.cpf_Cliente = cpf_Cliente;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
    
    

    public void setCampos(List<Object> campos) {
        setFileiraAssento(campos.get(0).toString().charAt(0));
        setNumero_Assento(Integer.valueOf(campos.get(1).toString()));
        setIs_Executiva((boolean)campos.get(2));
        setCpf_Cliente(campos.get(3).toString());
        setAtivo((boolean)campos.get(4));
        setId(Integer.valueOf(campos.get(5).toString()));       
        setVoo((Voo)campos.get(6));
    }
}
