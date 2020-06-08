package es.pelota.principal;

import es.pelota.ventana1.Hilo;
import es.pelota.ventana1.TableroJuego;
import es.pelota.ventana2.Hilo2;
import es.pelota.ventana2.TableroJuego2;
import es.pelota.ventana2.Ventana2;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/* @author Aguilar */
public class Pelota {

    //VARIABLES
    public boolean ocupado = false;
    Ventana2 ventana2;

    //Coordenadas de la pelota y dimensiones
    private final int ANCHO = 50, ALTO = 50;
    private int x, y;
    private int dx = 1, dy = 1;

    Cliente c, c2;
    Thread thread, thread2;

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

        if (x > limites.getMaxX()) {
            c2 = new Cliente(6000, y);
            thread2 = new Thread(c2);
            thread2.start();
            System.out.println("Cliente 2 Esta VIVO ?" + thread2.isAlive());

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
            System.out.println("Cliente 1 vivo?" + thread.isAlive());
        }
        if (y < 0) {
            dy = -dy;

        }
    }

    //Metodo para dibujar la pelota en el JPanel
    public Ellipse2D dibujarPelota() {
        return new Ellipse2D.Double(x, y, ANCHO, ALTO);
    }

}
