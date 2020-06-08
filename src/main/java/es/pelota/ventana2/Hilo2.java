package es.pelota.ventana2;

import es.pelota.ventana1.Hilo;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aguilar
 */
public class Hilo2 extends Thread {

    //VARIABLES
    public boolean ocupado = false;
    TableroJuego2 lamina2;
    private boolean corriendo = true;
    boolean suspender, pausar;

    //CONSTRUCTOR
    public Hilo2(TableroJuego2 lamina2) {
        this.lamina2 = lamina2;
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
                    if (pausar) {
                        break;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, "Error");
            }
            lamina2.repaint();
            System.out.println("Hilo 1: " + getName());

        }
    }

    //Comenzar Hilo
    public synchronized void comenzar() {
        start();
    }

    //Pausar el hilo
    public synchronized void pausarhilo() {

        pausar = true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        suspender = false;
        notify();
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
