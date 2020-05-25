package es.pelota.principal;

import es.pelota.ventana1.Hilo;
import es.pelota.ventana1.TableroJuego;
import es.pelota.ventana1.Ventana;
import es.pelota.ventana2.Hilo2;
import es.pelota.ventana2.TableroJuego2;
import es.pelota.ventana2.Ventana2;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Aguilar */
public class Pelota implements Serializable {

    //VARIABLES
    Ventana2 ventana2;
    private static TableroJuego lamina;
    private static TableroJuego2 lamina2;
    //Coordenadas de la pelota y dimensiones
    private final int ANCHO = 50, ALTO = 50;
    private int x, y;
    private int dx = 1, dy = 1;

    Hilo hilo1;
    Hilo2 hilo2;
    Cliente c;
    Thread thread;

    //CONSTRUCTOR
    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;

    }

    //METODOS
    //Metodo para asignar los limites donde se movera la bola
    //por la ventana del jugador 1
    public void moverVentana1(Rectangle limites, boolean colisionR1) {
        x -= dx;
        y += dy;

        if (colisionR1) {
            dx = -dx;
            x = 55;
        }

        if (x > limites.getMaxX() - 50) {
//            dx = -dx;

            c = new Cliente(6000, y);
            thread = new Thread(c);
            thread.start();
           
        }
        if (y > limites.getMaxY() - 50) {
            dy = -dy;

        }
        if (x < 0) {
            dx = -dx;

        }
        if (y < 0) {
            dy = -dy;

        }
    }

    //Metodo para asignar los limites donde se movera la bola
    //por la ventana del jugador 2
    public void moverVentana2(Rectangle limites, boolean colisionR2) {
        x += dx;
        y += dy;

        if (colisionR2) {
            dx = -dx;
            x = 360;
        }

        if (x > limites.getMaxX() - 50) {
            dx = -dx;

        }
        if (y > limites.getMaxY() - 50) {
            dy = -dy;

        }
        if (x < 0) {

            c = new Cliente(5000, y);
            thread = new Thread(c);
            thread.start();
        }
        if (y < 0) {
            dy = -dy;
        }
    }

    //Metodo para dibujar la pelota
    public Ellipse2D dibujarPelota() {
        return new Ellipse2D.Double(x, y, ANCHO, ALTO);
    }

    //GETTERS AND SETTERS
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
