package es.pelota.principal;

import es.pelota.ventana1.Ventana;
import es.pelota.ventana2.Ventana2;
import javax.swing.JFrame;


/* @author Aguilar */
public class Main {
    
    
    public static void main(String[] args) {

        Ventana ventana1 = new Ventana();
        Ventana2 ventana2 = new Ventana2();
        ventana1.setVisible(true);
        ventana2.setVisible(true);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}
