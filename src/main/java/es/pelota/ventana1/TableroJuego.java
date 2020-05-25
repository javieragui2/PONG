package es.pelota.ventana1;

import es.pelota.principal.Pelota;
import es.pelota.principal.Raqueta;
import es.pelota.principal.Servidor;
import es.pelota.ventana2.TableroJuego2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* @author Aguilar */
public class TableroJuego extends JPanel implements Observer {

    //vARIABLES
    int y, puntuacion, dimensionVentana;
    Pelota pelota = new Pelota(150, 150);
    Raqueta raqueta1 = new Raqueta(30, 200);
    private boolean bola = false;
    //Variables del Menu
    JMenuBar menuBarra = new JMenuBar();
    JMenu menu1 = new JMenu("Opciones");
    JMenuItem comenzarJuego = new JMenuItem("Comenzar Juego");
    JMenuItem pararJuego = new JMenuItem("Parar Juego");

    //CONSTRUCTOR
    public TableroJuego() {

        setBackground(Color.BLACK);
        //Inicio el primer servidor
        Servidor s = new Servidor(5000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    //METODOS
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dimensionVentana = (int) getBounds().getMaxX();
        dibujarComponentes(g);

        //System.out.println("X: " + getBounds().getMaxX() + ", Y: " + getBounds().getMaxY());
        actualizar();

    }

    //Metodo que llama a todos los metodos de los objetos que hay que dibujar 
    //para despues ser pintados en paintComponent
    public void dibujarComponentes(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        //Puntuación
        g.setFont(new Font("Consolas", Font.PLAIN, 22));
        g.drawString("Puntución: " + puntuacion, 40, 40);
        //Pelota
        g2.fill(pelota.dibujarPelota());
        //Raqueta
        g2.fill(raqueta1.getRaqueta());

    }

    //Metodo que llama al mover de la clase pelota y la raqueta 
    // para actualizar el pintado
    public void actualizar() {

        raqueta1.moverRaqueta1(getBounds());
        if (bola) {
            pelota.moverVentana1(getBounds(), colisionRaqueta(raqueta1.getRaqueta()));
        } else {
            System.out.println("La bola es false en Ventana 1");
        }
    }

    //Metodo para la colision de la pelota con las raquetas
    private boolean colisionRaqueta(Rectangle2D r) {
        return pelota.dibujarPelota().intersects(r);
    }

    @Override
    public void update(Observable o, Object arg) {

        //int y = (int) arg;
        o.deleteObservers();
        pelota = new Pelota((dimensionVentana-60), (int) arg);
    }

    //GETTERS AND SETTERS
    public boolean entra_bola() {
        return bola = true;
    }

    public boolean sale_bola() {
        return bola = false;
    }

}
