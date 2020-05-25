package es.pelota.ventana2;

import java.util.logging.Level;
import java.util.logging.Logger;

/** @author Aguilar */
public class Hilo2 extends Thread{
    
    //VARIABLES
    TableroJuego2 lamina2;
    private boolean corriendo = true;
    
    //CONSTRUCTOR
    public Hilo2(TableroJuego2 lamina2){
        this.lamina2 = lamina2;
    }
    
    //METODOS
    @Override
    public void run() {
        while(corriendo) {
            try {
                sleep(5);
            }catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, "Error");
            }
            lamina2.repaint();
        }
    }
    
    //Metodo para detener el segundo hilo
    public void detener(){
        corriendo = false;
    }
    
    public void comenzar(){
        corriendo = true;
        start();
    }
}
