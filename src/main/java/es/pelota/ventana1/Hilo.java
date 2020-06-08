package es.pelota.ventana1;

import es.pelota.principal.Pelota;
import es.pelota.principal.Raqueta;
import es.pelota.ventana2.TableroJuego2;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Aguilar */
public class Hilo extends Thread {

    //VARIABLES
    private static TableroJuego lamina;
    private static TableroJuego2 lamina2;
    private boolean corriendo = false;
    boolean suspender;

    //CONSTRUCTOR
    public Hilo(TableroJuego lamina) {
        this.lamina = lamina;
        
    }

    //METODOS
    @Override
    public void run() {
        while (true) {
            try {
                sleep(5);
                synchronized (this) {
                    while (suspender) {
                        wait();
                    }
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, "Error");
            }
            lamina.repaint();
            System.out.println("Hilo 1: " + getName());

        }

    }

    //Comenzar Hilo
    public synchronized void comenzar() {
        start();
    }

    //Suspender un hilo
    public synchronized void suspenderhilo() {
        suspender = true;
    }

    //Renaudar un hilo
    public synchronized void reanudarhilo() {
        suspender = false;
        notify();
    }

}
