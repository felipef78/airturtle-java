/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author ronnie
 */
public class AirTurtle {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CiaAerea ciaaerea = new CiaAerea();
        String[] dirNames = new String[5];
        dirNames[0] = "Aeronaves";
        dirNames[1] = "Clientes";
        dirNames[2] = "Destinos";
        dirNames[3] = "Reservas";
        dirNames[4] = "Voos";

        for (String dir : dirNames) {
            File directory = new File(dir);
            File[] fList = directory.listFiles();
            if (fList != null) {
                for (File file : fList) {
                    System.out.println(file.getAbsolutePath());
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    Object obj = ois.readObject();
                    if (file.getName().startsWith("airturtle.Aeronave")) {
                        ciaaerea.aeronaves.add((Aeronave) obj);
                    } else if (file.getName().startsWith("airturtle.Cliente")) {
                        ciaaerea.clientes.add((Cliente) obj);
                    } else if (file.getName().startsWith("airturtle.Destino")) {
                        ciaaerea.destinos.add((Destino) obj);
                    } else if (file.getName().startsWith("airturtle.Reserva")) {
                        ciaaerea.reservas.add((Reserva) obj);
                    } else if (file.getName().startsWith("airturtle.Voo")) {
                        ciaaerea.voos.add((Voo) obj);
                    }
                }
            }
        }
//        try {
//            // TODO code application logic here
//            //Cliente
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("airturtle.Aeronave_qwe123.ser"));
//            Aeronave aer = (Aeronave) ois.readObject();
//            System.out.println(aer.getPrefixo_Identificador());
//
//        } catch (IOException ex) {
//            Logger.getLogger(AirTurtle.class.getName()).log(Level.SEVERE, null, ex);
//
//        } catch (ClassNotFoundException cl) {
//
//        }

        //       ciaaerea.cadastrarCliente(true, "1", "Mario", "69692411", "mario@supermarioworld.com", "1234-6541", "9885-6632", endereco);
//        Endereco endereco1 = new Endereco("Rua2", "Bairro2", "complemento2", "2", "061698766", "Cidade2", "Estado2", "Pais2");
//        ciaaerea.cadastrarCliente(true, "2", "Luigi", "69692433", "luigi@supermarioworld.com", "1234-6541", "9885-6632", endereco1);
//        Cliente cli = ciaaerea.clientes.get(1);
//        ciaaerea.clientes.get(1).consultarCliente(cli);
//        ciaaerea.alterarCliente("69692433", 5, "ALTEREI");
//        ciaaerea.clientes.get(1).consultarCliente(cli);
//        System.out.println("Cliente cadastrado com sucesso!");
//
//        //Aeronave
        //     ciaaerea.cadastrarAeronave("1", "boeing 777", 15000, 20, 10, 3, 17);
//        Aeronave ae = ciaaerea.aeronaves.get(0);
//        ciaaerea.aeronaves.get(0).consultarAeronave(ae);
//        ciaaerea.alterarAeronave(1, 1, "ALTEREI");
//        ciaaerea.aeronaves.get(0).consultarAeronave(ae);
//        System.out.println("Aeronave cadastrada com çuçeço");
//
//        //Destinos
        //endereco = new Endereco("Rua 1", "Bairro 1", "complemento 1", "1 1", "061698745 1", "Cancun 1", "Estado 1", "Mexico 1");
        //ciaaerea.cadastrarDestino(1, "Cancun", "Cancun Aeroporto", 2, 5000, endereco, "Mexico");
//        Destino des = ciaaerea.destinos.get(0);
//        ciaaerea.destinos.get(0).consultarDestino(des);
//        ciaaerea.alterarDestino(1, 1, "ALTEREI");
//        ciaaerea.destinos.get(0).consultarDestino(des);
//        endereco = new Endereco("Rua 2", "Bairro 2", "complemento 2", "1 2", "061698745 2", "Cancun 2", "Estado 2", "Mexico 2");
//        ciaaerea.cadastrarDestino(1, "Cancun", "Cancun Aeroporto", 2, 14000, endereco, "Mexico");
//        endereco = new Endereco("Rua 3", "Bairro 3", "complemento 3", "1 3", "061698745 3", "Cancun 3", "Estado 3", "Mexico 3");
//        ciaaerea.cadastrarDestino(1, "Cancun", "Cancun Aeroporto", 2, 3000, endereco, "Mexico");
//        System.out.println("Destinos cadastrados com çuçeço");
//
//        //Voos
//        ciaaerea.cadastrarVoo(1, new SimpleDateFormat("MM/dd/yyyy HH:mm").parse("09/09/2013 14:00"), 300, 600, 200, 0, ciaaerea.destinos.get(0), ciaaerea.aeronaves.get(0));
//        ciaaerea.cadastrarVoo(1, new SimpleDateFormat("MM/dd/yyyy HH:mm").parse("09/10/2013 3:00"), 300, 600, 200, 0, ciaaerea.destinos.get(1), ciaaerea.aeronaves.get(0));
//        ciaaerea.cadastrarVoo(1, new SimpleDateFormat("MM/dd/yyyy HH:mm").parse("09/09/2013 15:00"), 300, 600, 200, 0, ciaaerea.destinos.get(2), ciaaerea.aeronaves.get(0));
//
//        Voo v = ciaaerea.voos.get(0);
//        ciaaerea.voos.get(0).consultarVoo(v);
//        ciaaerea.alterarVoo(1, 6, "5");
//        ciaaerea.voos.get(0).consultarVoo(v);
//        ciaaerea.cadastrarVoo(1, new SimpleDateFormat("MM/dd/yyyy HH:mm").parse("09/09/2013 3:00"), 300, 600, 200, 0, ciaaerea.destinos.get(1), ciaaerea.aeronaves.get(0)); //fora de alcance
//        ciaaerea.cadastrarVoo(1, new SimpleDateFormat("MM/dd/yyyy HH:mm").parse("09/09/2013 15:00"), 300, 600, 200, 0, ciaaerea.destinos.get(2), ciaaerea.aeronaves.get(0)); //fora do horario
//        System.out.println("Voos cadastrados com çuçesso");
//
//        //Reservas
//        boolean foi;
//        foi = ciaaerea.efetuarReserva(1, 1, 1, "69692411", 1);
//        System.out.println("Faturamento otimista: " + foi);
        //     ciaaerea.efetuarReserva(1, 1, 1, "69692433", 2);
//        ciaaerea.efetuarReserva(1, 1, 2, "69692433", 2);
//        ciaaerea.cancelarReserva(1, "69692411");
//
//        //faturamento
//        double a;
//        double b;
//        a = ciaaerea.estimarFaturamentoOtimista();
//        b = ciaaerea.estimarFaturamentoPessimista();
//        System.out.println("Faturamento otimista: " + a);
//        System.out.println("Faturamento pessimista: " + b);
        MainGUI mainG = new MainGUI(ciaaerea);
        mainG.setVisible(true);

        //Lembrar de colocar tratamento de erros nos setCampo de cada classe
        //Falta:
        //-Alterar's
        //-Ajustes no cadastro (escolher aeronave)
        //-Tratamento de exceções.
        //-Ajustes no Consultar's
        //-Efetuar reserva
    }
}
