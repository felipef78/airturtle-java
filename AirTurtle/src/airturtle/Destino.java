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
public class Destino implements Serializable {

    //private String nome_Cidade;
    private String nome_Aeroporto;
    private int fuso_Horario;
    private double distancia_Base;
    //private String pais;
    private int id;
    private Endereco endereco;

    public Destino() {
    }

    public Destino(int id, String nomeCidade, String nomeAeroporto, int fusoHorario, double distanciaBase, Endereco endereco) { //retirei pais e cidade
        //this.nome_Cidade = nomeCidade;
        this.nome_Aeroporto = nomeAeroporto;
        this.fuso_Horario = fusoHorario;
        this.distancia_Base = distanciaBase;
        this.endereco = endereco;
        //this.pais = pais;
        this.id = id;
    }

    public List<String> consultarDestino(Destino des) throws NumberFormatException, ArrayIndexOutOfBoundsException {
        List<String> lis = new ArrayList<>();
//        lis.add(des.getNome_Cidade());

        lis.add(des.getNome_Aeroporto());
        lis.add(String.valueOf(des.getFuso_Horario()));
        lis.add(String.valueOf(des.getDistancia_Base()));
//        lis.add(des.getPais());
        lis.add(String.valueOf(des.getId()));
        lis.add(des.getEndereco().getFEnd());
        return lis;
    }

//    public void setPais(String pais) {
//        this.pais = pais;
//    }
    public void setCampos(List<Object> campos) {

        //Lembrar de colocar tratamento de erros aqui!
//        setNome_Cidade(campos.get(0).toString());
        setNome_Aeroporto(campos.get(0).toString());
        setFuso_Horario(Integer.parseInt(campos.get(1).toString()));
        setDistancia_Base(Double.parseDouble(campos.get(2).toString()));
//        setPais(campos.get(4).toString());
        setId(Integer.parseInt(campos.get(3).toString()));
//        setEndereco((Endereco)campos.get(6));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getNome_Cidade() {
//        return this.nome_Cidade;
//    }
    public String getNome_Aeroporto() {
        return this.nome_Aeroporto;
    }

    public int getFuso_Horario() {
        return this.fuso_Horario;
    }

    public double getDistancia_Base() {
        return this.distancia_Base;
    }

    public Endereco getEnderecoAeroporto() {
        return this.endereco;
    }

//    public String getPais() {
//        return this.pais;
//    }
    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setDistancia_Base(double distancia_Base) {
        this.distancia_Base = distancia_Base;
    }

    public void setFuso_Horario(int fuso_Horario) {
        this.fuso_Horario = fuso_Horario;
    }

    public void setNome_Aeroporto(String nome_Aeroporto) {
        this.nome_Aeroporto = nome_Aeroporto;
    }

//    public void setNome_Cidade(String nome_Cidade) {
//        this.nome_Cidade = nome_Cidade;
//    }
}
