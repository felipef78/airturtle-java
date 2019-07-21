/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ronnie
 */
class Disponibilidade implements Serializable{

    private Date hora;
    private Destino destino;

    public Disponibilidade() {
        this.hora = null;
        this.destino = null;
    }
    
    public boolean calculaDisponibilidade(Date horaVoo) {
        if (hora == null && destino == null) {
            return true;
        } else {

            double idaVoltaMinutos = (2 * (destino.getDistancia_Base() / 1000)) * 60 * 60 * 1000;
            long milisegundos = horaVoo.getTime() - (long) (hora.getTime() + idaVoltaMinutos);
            long segundos = milisegundos / 1000;
            long minutos = segundos / 60;
            long horas = minutos / 60;

//            double horaEmMinutos = this.hora.getHours() * 100 + this.hora.getMinutes();
//            double soma = i daVoltaMinutos + horaEmMinutos;
//            double resultado = (horaVoo.getHours() * 100 + horaVoo.getMinutes()) - soma;
//            long result = ((hora.getTime() / 60) / 60) + 2;
            if (horas >= 2) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
}

public class Aeronave implements Serializable{

    private String prefixo_Identificador;
    private String modelo;
    private int autonomia;
    private int num_Total_Fileiras;
    private int num_Assentos_Por_Fileiras;
    private int num_Fileiras_Executivas;
    private int num_Fileiras_Economicas;
    List<Voo> voos = new ArrayList<>();
    private Disponibilidade disponibilidade;
    private boolean[][] mapa_De_Assentos;

    public Aeronave() {
    }

    public boolean verificaDisponibilidade(Date hora) {
        disponibilidade = new Disponibilidade();
        boolean disp = disponibilidade.calculaDisponibilidade(hora);
        return disp;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public Aeronave(String prefixoIdentificador, String modelo, int autonomia, int numTotalFileiras, int numAssentosPorFileiras, int numFileirasExecutiva, int numFileirasEconomica) {
        this.prefixo_Identificador = prefixoIdentificador;
        this.modelo = modelo;
        this.autonomia = autonomia;
        this.num_Total_Fileiras = numTotalFileiras;
        this.num_Assentos_Por_Fileiras = numAssentosPorFileiras;
        this.num_Fileiras_Executivas = numFileirasExecutiva;
        this.num_Fileiras_Economicas = numFileirasEconomica;

        this.disponibilidade = new Disponibilidade();
        mapa_De_Assentos = new boolean[numTotalFileiras][numAssentosPorFileiras];
        for (int i = 0; i < numTotalFileiras; i++) {
            for (int j = 0; j < numAssentosPorFileiras; j++) {
                mapa_De_Assentos[i][j] = true;
            }
        }
    }
    
    public List<String> consultarAeronave(Aeronave aero) {
        List<String> list = new ArrayList<>();
        list.add(aero.getPrefixo_Identificador());
        list.add(aero.getModelo());
        list.add(String.valueOf(aero.getAutonomia()));
        list.add(String.valueOf(aero.getNum_Assentos_Por_Fileiras()));
        list.add(String.valueOf(aero.getNum_Fileiras_Economicas()));
        list.add(String.valueOf(aero.getNum_Fileiras_Executivas()));
        list.add(String.valueOf(aero.getNum_Total_Fileiras()));
        return list;
    }

    public boolean[][] getMapaAssentos() {
        return mapa_De_Assentos;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNum_Assentos_Por_Fileiras() {
        return num_Assentos_Por_Fileiras;
    }

    public int getNum_Fileiras_Economicas() {
        return num_Fileiras_Economicas;
    }

    public int getNum_Fileiras_Executivas() {
        return num_Fileiras_Executivas;
    }

    public int getNum_Total_Fileiras() {
        return num_Total_Fileiras;
    }

    public String getPrefixo_Identificador() {
        return prefixo_Identificador;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNum_Assentos_Por_Fileiras(int num_Assentos_Por_Fileiras) {
        this.num_Assentos_Por_Fileiras = num_Assentos_Por_Fileiras;
    }

    public void setNum_Fileiras_Economicas(int num_Fileiras_Economicas) {
        this.num_Fileiras_Economicas = num_Fileiras_Economicas;
    }

    public void setNum_Fileiras_Executivas(int num_Fileiras_Executivas) {
        this.num_Fileiras_Executivas = num_Fileiras_Executivas;
    }

    public void setNum_Total_Fileiras(int num_Total_Fileiras) {
        this.num_Total_Fileiras = num_Total_Fileiras;
    }

    public void setPrefixo_Identificador(String prefixo_Identificador) {
        this.prefixo_Identificador = prefixo_Identificador;
    }
    
    public void setCampos(List<Object> campos) throws NumberFormatException {
        this.setPrefixo_Identificador(campos.get(0).toString());
        this.setModelo(campos.get(1).toString());
        this.setAutonomia(Integer.parseInt(campos.get(2).toString()));
        this.setNum_Total_Fileiras(Integer.parseInt(campos.get(3).toString()));
        this.setNum_Assentos_Por_Fileiras(Integer.parseInt(campos.get(4).toString()));
        this.setNum_Fileiras_Executivas(Integer.parseInt(campos.get(5).toString()));
        this.setNum_Fileiras_Economicas(Integer.parseInt(campos.get(6).toString()));
    }
}
