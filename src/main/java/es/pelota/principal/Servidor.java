package es.pelota.principal;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @author Aguilar */
public class Servidor extends Observable implements Runnable {

    //VARIABLES
    private int puerto;
    
    //CONSTRUCTOR
    public Servidor(int puerto){
        this.puerto = puerto;
    }
    
    //METODOS
    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;

        try {
            //Creamos socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {
                //Espero a que un cliente se conecte
                sc = servidor.accept();

                //System.out.println("Cliente conectado");
                
                in = new DataInputStream(sc.getInputStream());             
                
                //Leo mensaje que me envia
                int y = in.read();
                
                //System.out.println("Servidor Y: " + y);
                
                this.setChanged();
                this.notifyObservers(y);
                this.clearChanged();
                
                sc.close();
                //System.out.println("Cliente desconectado");

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
