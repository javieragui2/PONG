package es.pelota.ventana2;

import es.pelota.principal.Pelota;
import es.pelota.principal.Raqueta;
import es.pelota.principal.Servidor;
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
    public boolean bola = false;
    private int x = 0, y = 0, puntuacion;
    Pelota pelota;
    Hilo2 hilo2;
    Graphics2D g2;

    //CONSTRUCTOR
    public TableroJuego2() {
        setBackground(Color.BLACK);

        pelota = new Pelota(x, y);
        //Ejecuto el servidor 2 con su respectivo hilo
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
        g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        //Puntuación
        g.setFont(new Font("Consolas", Font.PLAIN, 22));
        g.drawString("Puntuación: " + puntuacion, 40, 40);
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
        //Movimiento de Raqueta
        raqueta2.moverRaqueta2(getBounds());

    }

    //Metodo para la colision de la pelota con las raquetas
    public boolean colisionRaqueta(Rectangle2D r) {
        return pelota.dibujarPelota().intersects(r);
    }

    //Metodo update para que pase la coordenada y, mientras el hilo esta en ejecución
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("LLega a Tablero 2 = " + arg);

        o.deleteObserver(this);
        y = (int) arg;
        bola = true;
        
    }

}
