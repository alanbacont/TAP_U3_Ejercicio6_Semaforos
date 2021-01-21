
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alancontreras
 */
public class Calle {
    boolean horizontal;
    public Calle(boolean horizontal){
        this.horizontal = horizontal;
    }
    public void pintar(Graphics2D g){
        g.setColor(Color.gray);
        if(horizontal){
            g.fillRect(0,200 , 800, 200);
            g.setColor(Color.WHITE);
            int ancho = 30;
            int alto = 10;
            g.fillRect(0, 300, ancho, alto);
            g.fillRect(80, 300, ancho, alto);
            g.fillRect(160, 300, ancho, alto);
            g.fillRect(240, 300, ancho, alto);
            
            g.fillRect(540, 300, ancho, alto);
            g.fillRect(620, 300, ancho, alto);
            g.fillRect(700, 300, ancho, alto);
            g.fillRect(780, 300, ancho, alto);
        } else { //es para vertical
            g.fillRect(300,0,200,650);
            g.setColor(Color.WHITE);
            int ancho = 10;
            int alto = 30;
            g.fillRect(400, 0, ancho, alto);
            g.fillRect(400, 80, ancho, alto);
            g.fillRect(400, 160, ancho, alto);
            g.fillRect(400, 240, ancho, alto);
            
            g.fillRect(400, 440, ancho, alto);
            g.fillRect(400, 520, ancho, alto);
            g.fillRect(400, 600, ancho, alto);
            
        }
    }
}
