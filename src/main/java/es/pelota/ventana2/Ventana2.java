package es.pelota.ventana2;

import es.pelota.principal.EventoTeclado;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Aguilar
 */
public class Ventana2 extends JFrame {

    //VARIABLES    
    private final int ANCHO = 500, ALTO = 400;
    private TableroJuego2 lamina2;
    private Hilo2 hilo2;

    //Variables del Menu
    JMenuBar menuBarra;
    JMenu menu1;
    JMenuItem comenzarJuego, pararJuego;

    //CONSTRUCTOR
    public Ventana2() {

        setTitle("Ventana 2");
        setSize(ANCHO, ALTO);
        setLocation(500, 100);
        setResizable(false);

        lamina2 = new TableroJuego2();
        add(lamina2);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hilo2 = new Hilo2(lamina2);
        hilo2.start();
    }

}
