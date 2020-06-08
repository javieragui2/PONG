package es.pelota.ventana1;

import es.pelota.principal.EventoTeclado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/* @author Aguilar*/
public class Ventana extends JFrame implements ActionListener {

    //VARIABLES
    private final int ANCHO = 500, ALTO = 400;
    private TableroJuego lamina;
    private Hilo hilo;

    //Variables del Menu
    JMenuBar menuBarra;
    JMenu menu1;
    JMenuItem comenzarJuego, pararJuego, reanudarJuego;

    //CONSTRUCTOR
    public Ventana() {
        setTitle("Ventana 1");
        setSize(ANCHO, ALTO);
        //setLocationRelativeTo(null);
        setLocation(0, 100);
        setResizable(false);

        lamina = new TableroJuego();
        add(lamina);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        menuBarra = new JMenuBar();
        setJMenuBar(menuBarra);

        menu1 = new JMenu("Opciones");
        menuBarra.add(menu1);

        comenzarJuego = new JMenuItem("Comenzar Juego");
        comenzarJuego.addActionListener(this);
        menu1.add(comenzarJuego);

        pararJuego = new JMenuItem("Parar Juego");
        pararJuego.addActionListener(this);
        menu1.add(pararJuego);

        reanudarJuego = new JMenuItem("Reanudar Juego");
        reanudarJuego.addActionListener(this);
        menu1.add(reanudarJuego);
        
        hilo = new Hilo(lamina);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comenzarJuego) {
            hilo.comenzar();
        }
        if (e.getSource() == pararJuego) {
            hilo.suspenderhilo();
            
        }
        if (e.getSource() == reanudarJuego) {
            hilo.reanudarhilo();
            
        }
    }

}
