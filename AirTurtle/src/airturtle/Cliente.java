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
public class Cliente extends Pessoa implements Serializable{

    private boolean is_Cliente_Fidelidade;
    private String numero_Fidelidade;
    List<Reserva> reservas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(boolean isClienteFidelidade, String numeroFidelidade, String nome, String cpf, String email, String telefone, String celular, Endereco endereco) {
        super(nome, cpf, email, telefone, celular, endereco);
        this.is_Cliente_Fidelidade = isClienteFidelidade;
        this.numero_Fidelidade = numeroFidelidade;
    }

    public List<String> consultarCliente(Cliente cli) throws NumberFormatException {
        List<String> lis = new ArrayList<>();
                lis.add(String.valueOf(cli.getIsClienteFidelidade()));
        //if (cli.getIsClienteFidelidade()) {
        lis.add(cli.getNumero_Fidelidade());
        //}
        lis.add(cli.getNome());
        lis.add(cli.getCpf());
                lis.add(cli.getEmail());
        lis.add(cli.getTelefone());
        lis.add(cli.getCelular());

        lis.add(cli.getEndereco().getFEnd());

        return lis;
    }
    

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas.add(reservas);
    }
    
    @Override
    public void setCampos(List<Object> campos){
        setIs_Cliente_Fidelidade(Boolean.valueOf(campos.get(0).toString()));
        setNumero_Fidelidade(campos.get(1).toString());
    }

    public String getNumero_Fidelidade() {
        return numero_Fidelidade;
    }

    public boolean getIsClienteFidelidade() {
        return is_Cliente_Fidelidade;
    }

    public void setIs_Cliente_Fidelidade(boolean is_Cliente_Fidelidade) {
        this.is_Cliente_Fidelidade = is_Cliente_Fidelidade;
    }

    public void setNumero_Fidelidade(String numero_Fidelidade) {
        this.numero_Fidelidade = numero_Fidelidade;
    }

    void setPessoa(Pessoa objeto) {
        Pessoa pessoa = objeto;
        this.setNome(pessoa.getNome());
        this.setCelular(pessoa.getCelular());
        this.setCpf(pessoa.getCpf());
        this.setEmail(pessoa.getEmail());
        //this.setEndereco(pessoa.getEndereco());
        this.setTelefone(pessoa.getTelefone());
    }
}
