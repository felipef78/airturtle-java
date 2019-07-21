/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronnie
 */
public class Voo implements Serializable {

    private int codigo_Identificador;
    private double valor_Passagem_Economica;
    private double valor_Passagem_Executiva;
    private int numero_Lugares_Vagos;
    private int numero_Lugares_Ocupados;
    private boolean[][] mapa_De_Ocupacao;
    private Aeronave aeronave;
    private Destino destino;
    List<Reserva> reservas = new ArrayList<>();
    private Date data;

    public Destino getDestino() {
        return destino;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Voo() {
    }

    public Voo(int codigoIdentificador, Date data, double valorPassagemEconomica, double valorPassagemExecutiva, int numeroLugaresVagos, int numeroLugaresOcupados, Destino destino, Aeronave aeronave) {
        if (aeronave.verificaDisponibilidade(data) && aeronave.getAutonomia() >= destino.getDistancia_Base()) {
            this.aeronave = aeronave;
            this.codigo_Identificador = codigoIdentificador;
            this.data = data;
            //this.hora = hora;
            this.valor_Passagem_Economica = valorPassagemEconomica;
            this.valor_Passagem_Executiva = valorPassagemExecutiva;
            this.numero_Lugares_Vagos = numeroLugaresVagos;
            this.numero_Lugares_Ocupados = numeroLugaresOcupados;
            boolean[][] mapa = aeronave.getMapaAssentos();
            for (int i = 0; i < aeronave.getNum_Total_Fileiras(); i++) {
                for (int j = 0; j < aeronave.getNum_Assentos_Por_Fileiras(); j++) {
                    mapa[i][j] = false;
                }
            }
            aeronave.getDisponibilidade().setDestino(destino);
            aeronave.getDisponibilidade().setHora(data);
            this.mapa_De_Ocupacao = mapa;
            this.destino = destino;
        } else {
            System.out.println("Erro! Aeronave indisponivel, tente mais tarde. Ou destino fora de alcance para esta aeronave.");
        }
    }

    public List<String> consultarVoo(Voo voo) throws NumberFormatException, NullPointerException {
        List<String> lis = new ArrayList<>();
        lis.add(String.valueOf(voo.getCodigo_Identificador()));
        //lis.add(voo.destino.getNomeCidade() + ", " + voo.destino.getPais());
        //lis.add(String.valueOf(voo.getData()));

        lis.add(String.valueOf(voo.getValor_Passagem_Economica()));
        lis.add(String.valueOf(voo.getValor_Passagem_Executiva()));
        lis.add(String.valueOf(voo.getNumero_Lugares_Vagos()));
        lis.add(String.valueOf(voo.getNumero_Lugares_Ocupados()));
        //lis.add(voo.aeronave.getModelo());

        return lis;
    }

    public int getCodigo_Identificador() {
        return codigo_Identificador;
    }

    public boolean[][] getMapa_De_Ocupacao() {
        return mapa_De_Ocupacao;
    }

    public Date getData() {
        return data;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public int getNumero_Lugares_Ocupados() {
        return numero_Lugares_Ocupados;
    }

    public int getNumero_Lugares_Vagos() {
        return numero_Lugares_Vagos;
    }

    public double getValor_Passagem_Economica() {
        return valor_Passagem_Economica;
    }

    public double getValor_Passagem_Executiva() {
        return valor_Passagem_Executiva;
    }

    public void setCodigo_Identificador(int codigo_Identificador) {
        this.codigo_Identificador = codigo_Identificador;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setMapa_De_Ocupacao(boolean[][] mapa_De_Ocupacao) {
        this.mapa_De_Ocupacao = mapa_De_Ocupacao;
    }

    public void setNumero_Lugares_Ocupados(int numero_Lugares_Ocupados) {
        this.numero_Lugares_Ocupados = numero_Lugares_Ocupados;
    }

    public void setNumero_Lugares_Vagos(int numero_Lugares_Vagos) {
        this.numero_Lugares_Vagos = numero_Lugares_Vagos;
    }

    public void setValor_Passagem_Economica(double valor_Passagem_Economica) {
        this.valor_Passagem_Economica = valor_Passagem_Economica;
    }

    public void setValor_Passagem_Executiva(double valor_Passagem_Executiva) {
        this.valor_Passagem_Executiva = valor_Passagem_Executiva;
    }

    public void setReserva(Reserva reservas) {
        this.reservas.add(reservas);
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setCampos(List<Object> campos) throws AeronaveIndisponivelException {
        this.setCodigo_Identificador(Integer.parseInt(campos.get(0).toString()));
        this.setValor_Passagem_Economica(Double.parseDouble(campos.get(1).toString()));
        this.setValor_Passagem_Executiva(Double.parseDouble(campos.get(2).toString()));
        this.setNumero_Lugares_Vagos(Integer.parseInt(campos.get(3).toString()));
        this.setNumero_Lugares_Ocupados(Integer.parseInt(campos.get(4).toString()));
        this.setAeronave((Aeronave) campos.get(5));
        this.setDestino((Destino) campos.get(6));
        try {
            this.setData(new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(campos.get(7).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(Voo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.aeronave.verificaDisponibilidade(data) && aeronave.getAutonomia() >= destino.getDistancia_Base()) {
            aeronave.getDisponibilidade().setDestino(destino);
            aeronave.getDisponibilidade().setHora(data);
        } else {
            throw new AeronaveIndisponivelException("Aeronave indisponivel");
        }

    }

}
