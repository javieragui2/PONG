package es.pelota.principal;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/** @author Aguilar */
public class Raqueta {
    
    //VARIABLES
    private int x,y;
    private final int ANCHO = 25, ALTO = 90;
    
    //CONSTRUCTOR
    public Raqueta(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    //METODOS
    //Pasar Rectangle con las medidas de las raquetas para dibujarse depués 
    // en el JPanel
    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
    
    //Metodo que pasa los datos del teclado para saver donde hay que dibujar
    // la raqueta del jugador 1
    public void moverRaqueta1(Rectangle limites){
        if(EventoTeclado.w && y > limites.getMinY()){
            y--;
        }
        if(EventoTeclado.s && y < limites.getMaxY() - ALTO){
            y++;
        }
    }
    
    //Metodo que pasa los datos del teclado para saver donde hay que dibujar
    // la raqueta del jugador 2
    public void moverRaqueta2(Rectangle limites){
        if(EventoTeclado.arriba && y > limites.getMinY()){
            y--;
        }
        if(EventoTeclado.abajo && y < limites.getMaxY() - ALTO){
            y++;
        }
    }
}
