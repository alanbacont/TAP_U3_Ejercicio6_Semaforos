
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alancontreras
 */
public class Semaforo extends Thread{
    //estado = 1 (verde), 2(amarillo que va a ROJO), 3 (rojo), 4 (amarillo que va verde)
    int estado;
    Escenario puntero;
    int x,y;
    final int LARGO = 7670;
    final int CORTO = 1870;
    
    public Semaforo(boolean sw, Escenario l, int posX, int posY){
        if(sw){
            estado = 2;
        } else {
            estado = 4;
        }
        
        puntero = l;
        x=posX;
        y=posY;
    }
    @Override
    public void run() {
        super.run();
        while(true){
            try {
                
                switch(estado){
                    case 1:
                        puntero.repaint();
                        sleep(LARGO);
                        estado = 2;
                        break;
                    case 2:
                        puntero.repaint();
                        sleep(CORTO);
                        estado = 3;
                        break;
                    case 3:
                        puntero.repaint();
                        sleep(LARGO);
                        estado = 4;
                        break;
                    case 4:
                        puntero.repaint();
                        sleep(CORTO);
                        estado = 1;
                        break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void pintar(Graphics2D g){
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, 70, 170);
        
         //ROJOSCURO
        g.setColor(new Color(165,44,2));
        g.fillOval(x+15, y+10, 40, 40);

        //amarilloscuro
        g.setColor(new Color(205,190,58));
        g.fillOval(x+15, y+60, 40, 40);
        
        
        //verdescuro
        g.setColor(new Color(18,121,5));
        g.fillOval(x+15, y+110, 40, 40);
        
        switch(estado){
            case 1:
                g.setColor(new Color(26,255,0));
                g.fillOval(x+15, y+110, 40, 40);
                
                break;
            case 2:
                g.setColor(new Color(255,242,0));
                g.fillOval(x+15, y+60, 40, 40);
                
                break;
            case 3:
                g.setColor(new Color(255,0,0));
                g.fillOval(x+15, y+10, 40, 40);
                
                break;
            case 4:
                g.setColor(new Color(255,242,0));
                g.fillOval(x+15, y+60, 40, 40);
                
                break;
        }
    }
}
