package es.pelota.principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aguilar
 */
public class Cliente implements Runnable {

    //VARIABLES
    private int puerto;
    private int y;
    // private boolean pasaBola;

    //CONSTRUCTOR
    public Cliente(int puerto,/*boolean pasaBola,*/ int y) {
        this.puerto = puerto;
        this.y = y;
        //this.pasaBola = pasaBola;
    }

    //METODOS
    @Override
    public void run() {
        //Host del servidor
        final String HOST = "127.0.0.1";
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, puerto);

            out = new DataOutputStream(sc.getOutputStream());
            out.write(y);

            //out.writeUTF(y);

            /*String mensaje = in.readUTF();
            
            System.out.println(mensaje);*/
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
