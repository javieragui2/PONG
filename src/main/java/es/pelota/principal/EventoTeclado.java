package es.pelota.principal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Aguilar
 */
public class EventoTeclado extends KeyAdapter {

    //VARIABLES
    static boolean w, s, arriba, abajo;

    //METODOS
    //Metodo para saber que tacla presionamos
    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_W) {
            w = true;
        }
        if (id == KeyEvent.VK_S) {
            s = true;
        }
        if (id == KeyEvent.VK_UP) {
            arriba = true;
        }
        if (id == KeyEvent.VK_DOWN) {
            abajo = true;
        }
    }

    //Metodo para saber que tacla dejamos de presionar
    @Override
    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_W) {
            w = false;
        }
        if (id == KeyEvent.VK_S) {
            s = false;
        }
        if (id == KeyEvent.VK_UP) {
            arriba = false;
        }
        if (id == KeyEvent.VK_DOWN) {
            abajo = false;
        }
    }

}
