package es.pelota.ventana2;

import es.pelota.principal.Pelota;
import es.pelota.principal.Raqueta;
import es.pelota.principal.Servidor;
import es.pelota.ventana1.TableroJuego;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/*  @author Aguilar */
public class TableroJuego2 extends JPanel implements Observer {

    //VARIABLES
    
    Raqueta raqueta2 = new Raqueta(420, 200);
    private Graphics graphic;
    private boolean bola = false;
    private int x = 0, y, puntuacion;
    Pelota pelota = new Pelota(x, y);

    //CONSTRUCTOR
    public TableroJuego2() {
        setBackground(Color.BLACK);

        Servidor s = new Servidor(6000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    //METODOS
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarComponentes(g);
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
        //Raqueta
        g2.fill(raqueta2.getRaqueta());
        //Pelota
        if (bola) {
            g2.fill(pelota.dibujarPelota());
            pelota.moverVentana2(getBounds(), colisionRaqueta(raqueta2.getRaqueta()));
        }
    }

    //Metodo que llama al mover de la clase pelota y la raqueta 
    // para actualizar el pintado
    public void actualizar() {
        raqueta2.moverRaqueta2(getBounds());

    }

    //Metodo para la colision de la pelota con las raquetas
    private boolean colisionRaqueta(Rectangle2D r) {
        return pelota.dibujarPelota().intersects(r);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("LLega a Tablero 2 = " + arg);
        bola = true;
        o.deleteObserver(this);
        y = (int) arg;
        // o.deleteObservers();
       // pelota = new Pelota(0, y);
    }

    //GETTERS AND SETTERS
    public boolean entra_bola() {
        return bola = true;
    }

    public boolean sale_bola() {
        return bola = false;
    }

}
