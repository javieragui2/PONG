package es.pelota.ventana1;

import es.pelota.ventana1.TableroJuego;
import es.pelota.ventana2.TableroJuego2;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Aguilar */
public class Hilo extends Thread {

    //VARIABLES
    private static TableroJuego lamina;
    private static TableroJuego2 lamina2;
    private boolean corriendo = true;
    
    //CONSTRUCTOR
    public Hilo(TableroJuego lamina) {
        this.lamina = lamina;
        
    }
    
    //METODOS
    @Override
    public void run() {
        while (corriendo) {
            try {
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, "Error");
            }
            lamina.repaint();
          
        }
    }
    
    //Metodo para detener el primer hilo
    public void detener(){
        corriendo = false;
    }

    public void comenzar(){
        corriendo = true;
        start();
    }
}
