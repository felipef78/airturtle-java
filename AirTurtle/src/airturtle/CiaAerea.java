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

/**
 *
 * @author ronnie
 */
public class CiaAerea implements Serializable{

    List<Reserva> reservas = new ArrayList<>();
    List<Aeronave> aeronaves = new ArrayList<>();
    List<Voo> voos = new ArrayList<>();
    List<Destino> destinos = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    public CiaAerea() {
    }
    
    public void removerDestino(int index) {
        for (int i = 0; i < voos.size(); i++) {
            Voo voo = voos.get(i);
            Destino des = voo.getDestino();
            if (des.getId() == voos.get(index).getDestino().getId()) {
                this.removerVoo(i);
            }
        }
        destinos.remove(index);
    }

    public void cadastrarAeronave(String prefixoIdentificador, String modelo, int autonomia, int numTotalFileiras, int numAssentosPorFileiras, int numFileirasExecutiva, int numFileirasEconomica) {
        Aeronave aeronave = new Aeronave(prefixoIdentificador, modelo, autonomia, numTotalFileiras, numAssentosPorFileiras, numFileirasExecutiva, numFileirasEconomica);
        aeronaves.add(aeronave);
    }

    public void removerAeronave(int index) {
        for (int i = 0; i < voos.size(); i++) {
            Voo voo = voos.get(i);
            Aeronave aero = voo.getAeronave();
            if (aero.getPrefixo_Identificador().equals(aeronaves.get(index).getPrefixo_Identificador())) {
                this.removerVoo(i);
            }
        }
        
        aeronaves.remove(index);
    }

    //Novo jeito de alterar coisas, mandando o numero do campo de escolha já como parâmetro da função alterar.
    //TODO: averiguar para determinar se este modo é melhor que o outro de digitar a escolha.
    //lembrando que aparentemente o programa terá que ser chamado pela pain apenas
    //então talvez devessemos mandar o numero do campo e o valor que queremos para ele como parâmetro
    public void alterarAeronave(int prefixoIdentificador, int escolha, String valor) {
        for (Aeronave aeronave : aeronaves) {
            if (prefixoIdentificador == Integer.parseInt(aeronave.getPrefixo_Identificador())) {
                System.out.println("Você deseja alterar qual campo?");
                System.out.println("1 modelo, 2 autonomia, 3 numTotalFileiras, 4 numAssentosPorFileiras");
                System.out.println("5 numFileirasExecutiva, 6 numFileirasEconomica");

                switch (escolha) {
                    case 1:
                        System.out.println("Valor atual: " + aeronave.getModelo());
                        System.out.println("Digite um novo valor para o campo: ");
                        aeronave.setModelo(valor);
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 2:
                        System.out.println("Valor atual: " + aeronave.getAutonomia());
                        System.out.println("Digite um novo valor para o campo: ");
                        aeronave.setAutonomia(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 3:
                        System.out.println("Valor atual: " + aeronave.getNum_Total_Fileiras());
                        System.out.println("Digite um novo valor para o campo: ");
                        aeronave.setNum_Total_Fileiras(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 4:
                        System.out.println("Valor atual: " + aeronave.getNum_Assentos_Por_Fileiras());
                        System.out.println("Digite um novo valor para o campo: ");
                        aeronave.setNum_Assentos_Por_Fileiras(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 5:
                        System.out.println("Valor atual: " + aeronave.getNum_Fileiras_Executivas());
                        System.out.println("Digite um novo valor para o campo: ");
                        aeronave.setNum_Fileiras_Executivas(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 6:
                        System.out.println("Valor atual: " + aeronave.getNum_Fileiras_Economicas());
                        System.out.println("Digite um novo valor para o campo: ");
                        aeronave.setNum_Fileiras_Economicas(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                }
            }
        }
    }

    public void cadastrarVoo(int codigoIdentificador, Date data, double valorPassagemEconomica, double valorPassagemExecutiva, int numeroLugaresVagos, int numeroLugaresOcupados, Destino destino, Aeronave aeronave) {
        Voo voo = new Voo(codigoIdentificador, data, valorPassagemEconomica, valorPassagemExecutiva, numeroLugaresVagos, numeroLugaresOcupados, destino, aeronave);
        voos.add(voo);
    }

    public void removerVoo(int index) {
        for (int i = 0; i < voos.get(index).getReservas().size(); i++) {
            this.removerReserva(i);
        }
        Persistencia per = new Persistencia();
        String s = new Voo().getClass().getName() + "_" + voos.get(index).getCodigo_Identificador() + ".ser";
        per.deletar(voos.get(index), s);
        voos.remove(index);
    }

    public void alterarVoo(int codigoIdentificador, int escolha, String valor) throws ParseException {
        boolean sim;
        //do {
        for (Voo voo : voos) {
            if (voo.getCodigo_Identificador() == codigoIdentificador) {
                System.out.println("Você deseja alterar qual campo?");
                System.out.println("1 data, 3 valorPassagemEconomica, 4 valorPassagemExecutiva");
                System.out.println("5 numeroLugaresVagos, 6 numeroLugaresOcupados");
                SimpleDateFormat simpDF;

                switch (escolha) {
                    case 1:
                        System.out.println("Valor atual: " + voo.getData());
                        System.out.println("Digite um novo valor para o campo: ");
                        simpDF = new SimpleDateFormat("%d/%m/%y");
                        voo.setData(simpDF.parse(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 3:
                        System.out.println("Valor atual: " + voo.getValor_Passagem_Economica());
                        System.out.println("Digite um novo valor para o campo: ");
                        voo.setValor_Passagem_Economica(Double.parseDouble(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 4:
                        System.out.println("Valor atual: " + voo.getValor_Passagem_Executiva());
                        System.out.println("Digite um novo valor para o campo: ");
                        voo.setValor_Passagem_Executiva(Double.parseDouble(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 5:
                        System.out.println("Valor atual: " + voo.getNumero_Lugares_Vagos());
                        voo.setNumero_Lugares_Vagos(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                    case 6:
                        System.out.println("Valor atual: " + voo.getNumero_Lugares_Ocupados());
                        System.out.println("Digite um novo valor para o campo: ");
                        voo.setNumero_Lugares_Ocupados(Integer.parseInt(valor));
                        System.out.println("Campo alterado com sucesso!");
                        break;
                }
                break;
            }
        }
        /*System.out.println("Deseja alterar outro campo? s/n");
         Scanner scan = new Scanner(System.in);

         if (scan.next().equals("s")) {
         sim = true;
         } else {
         sim = false;
         }
         } while (sim);*/
    }

    public void cadastrarCliente(boolean isClienteFidelidade, String numeroFidelidade, String nome, String cpf, String email, String telefone, String celular, Endereco endereco) {
        Cliente cliente = new Cliente(isClienteFidelidade, numeroFidelidade, nome, cpf, email, telefone, celular, endereco);
        clientes.add(cliente);
    }

    public void removerCliente(int index) {
        for (int i = 0; i < clientes.get(index).getReservas().size(); i++) {
            this.removerReserva(i);
        }
        clientes.remove(index);
    }

    public void alterarCliente(String cpfCliente, int escolha, Object valor) {
        boolean sim;
        //do {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                System.out.println("Você deseja alterar qual campo?");
                System.out.println("1 Fidelidade, 2 Numero Fidelidade, 3 Nome, 4 CPF");
                System.out.println("5 E-mail, 6 Telefone, 7 Celular, 8 Endereço");

                switch (escolha) {
                    case 1:
                        if (cliente.getIsClienteFidelidade()) {
                            System.out.println("Fidelidade atual: Sim");
                        } else {
                            System.out.println("Fidelidade atual: Nao");
                        }
                        cliente.setIs_Cliente_Fidelidade(Boolean.parseBoolean((String) valor));
                        break;
                    case 2:
                        cliente.setNumero_Fidelidade((String) valor);
                        break;
                    case 3:
                        cliente.setNome((String) valor);
                        break;
                    case 4:
                        cliente.setCpf((String) valor);
                        break;
                    case 5:
                        cliente.setEmail((String) valor);
                        break;
                    case 6:
                        cliente.setTelefone((String) valor);
                        break;
                    case 7:
                        cliente.setCelular((String) valor);
                        break;
                    case 8:
                        cliente.setEndereco((Endereco) valor);
                        break;
                }
                break;
            }
        }
        /*   System.out.println("Deseja alterar outro campo? s/n");
         Scanner scan = new Scanner(System.in);

         if (scan.next().equals("s")) {
         sim = true;
         } else {
         sim = false;
         }
         } while (sim);*/

    }

    public boolean efetuarReserva(int codigoVoo, int fileira, int assento, String cpfCliente, int id) {
        //TODO: verificar assento vago e isExecutivo
        for (Voo voo : voos) {
            if (codigoVoo == voo.getCodigo_Identificador()) {
                if (voo.getMapa_De_Ocupacao()[fileira][assento] == false) {
                    boolean[][] mapa = voo.getMapa_De_Ocupacao();
                    mapa[fileira][assento] = true;
                    voo.setMapa_De_Ocupacao(mapa);
                    if (fileira < voo.getAeronave().getNum_Fileiras_Executivas()) {
                        Reserva reserva = new Reserva(fileira, assento, true, voo, cpfCliente, id);
                        reservas.add(reserva);
                        voo.setReserva(reserva);
                        for (Cliente cli : clientes) {
                            if (cli.getCpf().equals(cpfCliente)) {
                                cli.setReservas(reserva);
                            }
                        }
                        return true;
                    } else {
                        Reserva reserva = new Reserva(fileira, assento, false, voo, cpfCliente, id);
                        reservas.add(reserva);
                        voo.setReserva(reserva);
                        for (Cliente cli : clientes) {
                            if (cli.getCpf().equals(cpfCliente)) {
                                cli.setReservas(reserva);
                            }
                        }
                        return true;
                    }
                } else {
                    System.out.println("ESCOLHA O ASSENTO NÃO OCUPADO");
                    return false;
                }
            }
        }
        return false;
    }

    public void cancelarReserva(int index) {
        Reserva res = reservas.get(index);
        res.setAtivo(false);
        Persistencia per = new Persistencia();
        per.gravarEAlterar(res);
    }

    public void removerReserva(int index) {
        Persistencia per = new Persistencia();
        String s = new Reserva().getClass().getName() + "_" + reservas.get(index).getId()+ ".ser";
        per.deletar(reservas.get(index), s);
        reservas.remove(index);
    }

    public double estimarFaturamentoOtimista() {
        //Lembrete: if reserva.ativo == false: considera só 10% do valor da passagem.
        double faturamento = 0;
        for (Reserva reserva : reservas) {
            for (Voo voo : voos) {
                if (reserva.getVoo().getCodigo_Identificador() == voo.getCodigo_Identificador()) {
                    if (reserva.isAtivo()) {
                        if (reserva.isIs_Executiva()) {
                            faturamento += voo.getValor_Passagem_Executiva();
                        } else {
                            faturamento += voo.getValor_Passagem_Economica();
                        }
                    } else {
                        if (reserva.isIs_Executiva()) {
                            faturamento += voo.getValor_Passagem_Executiva() / 10;
                        } else {
                            faturamento += voo.getValor_Passagem_Economica() / 10;
                        }
                    }
                    // break;
                }
            }
        }
        return faturamento;
    }

    public double estimarFaturamentoPessimista() {
        double faturamento = 0;
        for (Reserva reserva : reservas) {
            for (Voo voo : voos) {
                if (reserva.getVoo().getCodigo_Identificador() == voo.getCodigo_Identificador()) {
                    if (reserva.isIs_Executiva()) {
                        faturamento += voo.getValor_Passagem_Executiva() / 10;
                    } else {
                        faturamento += voo.getValor_Passagem_Economica() / 10;
                    }
                }
                break;
            }
        }
        return faturamento;
    }

    public Destino getDestino() {
        Destino objDestino = new Destino();
        return objDestino;
    }

    public Voo getVoo() {
        Voo objVoo = new Voo();
        return objVoo;
    }

    public Aeronave getAeronave() {
        Aeronave objAeronave = new Aeronave();
        return objAeronave;
    }

    public Reserva getReserva(int codigoVoo, String cpfCliente) {
        Reserva objReserva = new Reserva();
        return objReserva;
    }

    public Cliente getCliente(String cpfCliente) {
        Cliente objCliente = new Cliente();
        return objCliente;
    }
}
