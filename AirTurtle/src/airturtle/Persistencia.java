/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airturtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronnie
 */
public class Persistencia implements Serializable {

    CiaAerea cia;

    public Persistencia() {

    }

    public Persistencia(CiaAerea cia) {
        this.cia = cia;
    }

    public void gravarEAlterar(Object obj) {
        ObjectOutputStream out;
        if (obj.getClass() == new Aeronave().getClass()) {
            try {
                Aeronave objeto = (Aeronave) obj;
                File dir = new File(System.getProperty("user.dir"), "Aeronaves");

                boolean success = dir.mkdir();
                if (success) {
                    System.out.println("dir did not exist and was created");
                } else {
                    System.out.println("dir already exists");
                }
                File f = new File(dir, new Aeronave().getClass().getName() + "_" + objeto.getPrefixo_Identificador() + ".ser");
                System.out.println(f);
                success = f.createNewFile();
                if (success) {
                    System.out.println("file did not exist and was created");
                } else {
                    System.out.println("file already exists");
                }
                out = new ObjectOutputStream(new FileOutputStream(f));
                //new FileOutputStream(new Aeronave().getClass().getName()+"_"+objeto.getPrefixoIdentificador()+".ser")
                out.writeObject(objeto);
                out.close();

            } catch (IOException ex) {

                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (obj.getClass() == new Cliente().getClass()) {
            try {
                Cliente objeto = (Cliente) obj;
                File dir = new File(System.getProperty("user.dir"), "Clientes");

                boolean success = dir.mkdir();
                if (success) {
                    System.out.println("dir did not exist and was created");
                } else {
                    System.out.println("dir already exists");
                }
                File f = new File(dir, new Cliente().getClass().getName() + "_" + objeto.getCpf() + ".ser");
                System.out.println(f);
                success = f.createNewFile();
                if (success) {
                    System.out.println("file did not exist and was created");
                } else {
                    System.out.println("file already exists");
                }
                out = new ObjectOutputStream(new FileOutputStream(f));
                out.writeObject(objeto);
                out.close();

            } catch (IOException ex) {

                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (obj.getClass() == new Destino().getClass()) {
            try {
                Destino objeto = (Destino) obj;
                File dir = new File(System.getProperty("user.dir"), "Destinos");

                boolean success = dir.mkdir();
                if (success) {
                    System.out.println("dir did not exist and was created");
                } else {
                    System.out.println("dir already exists");
                }
                File f = new File(dir, new Destino().getClass().getName() + "_" + objeto.getId() + ".ser");
                System.out.println(f);
                success = f.createNewFile();
                if (success) {
                    System.out.println("file did not exist and was created");
                } else {
                    System.out.println("file already exists");
                }
                out = new ObjectOutputStream(new FileOutputStream(f));
                out.writeObject(objeto);
                out.close();

            } catch (IOException ex) {

                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (obj.getClass() == new Reserva().getClass()) {
            try {
                Reserva objeto = (Reserva) obj;
                File dir = new File(System.getProperty("user.dir"), "Reservas");

                boolean success = dir.mkdir();
                if (success) {
                    System.out.println("dir did not exist and was created");
                } else {
                    System.out.println("dir already exists");
                }
                File f = new File(dir, new Reserva().getClass().getName() + "_" + objeto.getId() + ".ser");
                System.out.println(f);
                success = f.createNewFile();
                if (success) {
                    System.out.println("file did not exist and was created");
                } else {
                    System.out.println("file already exists");
                }
                out = new ObjectOutputStream(new FileOutputStream(f));
                out.writeObject(objeto);
                out.close();

            } catch (IOException ex) {

                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (obj.getClass() == new Voo().getClass()) {
            try {
                Voo objeto = (Voo) obj;
                File dir = new File(System.getProperty("user.dir"), "Voos");

                boolean success = dir.mkdir();
                if (success) {
                    System.out.println("dir did not exist and was created");
                } else {
                    System.out.println("dir already exists");
                }
                File f = new File(dir, new Voo().getClass().getName() + "_" + objeto.getCodigo_Identificador() + ".ser");
                System.out.println(f);
                success = f.createNewFile();
                if (success) {
                    System.out.println("file did not exist and was created");
                } else {
                    System.out.println("file already exists");
                }
                out = new ObjectOutputStream(new FileOutputStream(f));
                out.writeObject(objeto);
                out.close();

            } catch (IOException ex) {

                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deletar(Object obj, String s) {
        if (obj.getClass() == new Aeronave().getClass()) {
            File dir = new File(System.getProperty("user.dir"), "Aeronaves");
            for (File f : dir.listFiles()) {
                System.out.println(s);
                System.out.println(f.getName());
                if (s.equals(f.getName())) {
                    f.delete();
                    break;
                }
            }
        } else if (obj.getClass() == new Cliente().getClass()) {
            File dir = new File(System.getProperty("user.dir"), "Clientes");
            for (File f : dir.listFiles()) {
                System.out.println(s);
                System.out.println(f.getName());
                if (s.equals(f.getName())) {
                    f.delete();
                    break;
                }
            }
        } else if (obj.getClass() == new Destino().getClass()) {
            File dir = new File(System.getProperty("user.dir"), "Destinos");
            for (File f : dir.listFiles()) {
                System.out.println(s);
                System.out.println(f.getName());
                if (s.equals(f.getName())) {
                    f.delete();
                    break;
                }
            }
        } else if (obj.getClass() == new Reserva().getClass()) {
            File dir = new File(System.getProperty("user.dir"), "Reservas");
            for (File f : dir.listFiles()) {
                System.out.println(s);
                System.out.println(f.getName());
                if (s.equals(f.getName())) {
                    f.delete();
                    break;
                }
            }
        } else if (obj.getClass() == new Voo().getClass()) {
            File dir = new File(System.getProperty("user.dir"), "Voos");
            for (File f : dir.listFiles()) {
                System.out.println(s);
                System.out.println(f.getName());
                if (s.equals(f.getName())) {

                    f.delete();
                    break;
                }
            }
        }
    }
}
