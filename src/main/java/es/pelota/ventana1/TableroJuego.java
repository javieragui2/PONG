package es.pelota.ventana1;

import es.pelota.principal.Pelota;
import es.pelota.principal.Raqueta;
import es.pelota.principal.Servidor;
import es.pelota.ventana1.Hilo;
import es.pelota.ventana2.TableroJuego2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/* @author Aguilar */
public class TableroJuego extends JPanel implements Observer {

    //VARIABLES
    int y, puntuacion, dimensionVentana;
    Pelota pelota = new Pelota(150, 150);
    Raqueta raqueta1 = new Raqueta(30, 200);
    public boolean bola = true;
    

    private Hilo hilo;

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
        actualizar();
        //System.out.println("X: " + getBounds().getMaxX() + ", Y: " + getBounds().getMaxY());

    }

    //Metodo que llama a todos los metodos de los objetos que hay que dibujar 
    //para despues ser pintados en paintComponent
    public void dibujarComponentes(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        //Puntuación
        g.setFont(new Font("Consolas", Font.PLAIN, 22));
        g.drawString("Puntuación: " + puntuacion, 40, 40);
        //Pelota
        
            g2.fill(pelota.dibujarPelota());
        
        //Raqueta
        g2.fill(raqueta1.getRaqueta());

    }

    //Metodo que llama al mover de la clase pelota y la raqueta 
    // para actualizar el pintado
    public void actualizar() {
        //Movimiento de Raqueta
        raqueta1.moverRaqueta1(getBounds());
        pelota.moverVentana1(getBounds(), colisionRaqueta(raqueta1.getRaqueta()));
    }

    //Metodo para la colision de la pelota con las raquetas
    public boolean colisionRaqueta(Rectangle2D r) {
        return pelota.dibujarPelota().intersects(r);
    }

    @Override
    public void update(Observable o, Object arg) {

        //int y = (int) arg;
        o.deleteObservers();
        pelota = new Pelota((dimensionVentana - 60), (int) arg);
        
    }

}
