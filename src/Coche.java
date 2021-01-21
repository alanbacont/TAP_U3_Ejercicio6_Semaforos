
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
public class Coche extends Thread{  
    int x, y ;
    //1 = izq a derecha, 2 = derecha a iz, 3 = arriba a abajo, 4 = abajo a arriba
    int direccion;
    Color color;
    Color toldo;
    int R = (int) (Math.random()*170+80);
    int G = (int) (Math.random()*170+80);
    int B = (int) (Math.random()*170+80);
    Semaforo semaforo;
    Escenario escenario;
    int desplazamiento = (int) (Math.random()*7+5);
        
    
    public Coche(int x, int y, int direccion, Semaforo s, Escenario e){
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        color = new Color(R,G,B);
        toldo = new Color(R-30,G-30,B-30);
        semaforo = s;
        escenario = e;
    }
    
    public void pintar(Graphics2D g){
        g.setColor(color);
        switch(direccion){
            case 1:
                g.fillRect(x, y, 60, 40);
                g.setColor(toldo);
                g.fillRect(x+10, y+5, 25, 30);
                g.setColor(Color.WHITE);
                g.fillRect(x+35, y+5, 8, 30);
                g.fillRect(x+10, y+5, 6, 30);
                g.fillOval(x+50, y+8, 6, 6);
                g.fillOval(x+50, y+28, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillOval(x+8, y-5, 10, 4);
                g.fillOval(x+8, y+40, 10, 4);
                g.fillOval(x+35, y-5, 10, 4);
                g.fillOval(x+35, y+40, 10, 4);
                break;
            case 2:
                g.fillRect(x, y, 60, 40);
                g.setColor(toldo);
                g.fillRect(x+25, y+5, 25, 30);
                g.setColor(Color.WHITE);
                g.fillRect(x+15, y+5, 8, 30);
                g.fillRect(x+45, y+5, 6, 30);
                g.fillOval(x+4, y+8, 6, 6);
                g.fillOval(x+4, y+28, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillOval(x+8, y-5, 10, 4);
                g.fillOval(x+8, y+40, 10, 4);
                g.fillOval(x+35, y-5, 10, 4);
                g.fillOval(x+35, y+40, 10, 4);
                break;
            case 3: 
                g.fillRect(x, y, 40, 60);
                g.setColor(toldo);
                g.fillRect(x+5, y+10, 30, 25);
                g.setColor(Color.WHITE);
                g.fillRect(x+5, y+35, 30, 8);
                g.fillRect(x+5, y+10, 30, 6);
                g.fillOval(x+8, y+50, 6, 6);
                g.fillOval(x+28, y+50, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillOval(x-5, y+8, 4, 10);
                g.fillOval(x+40, y+8, 4, 10);
                g.fillOval(x-5, y+35, 4, 10);
                g.fillOval(x+40, y+35, 4, 10);
                break;
            case 4: 
                g.fillRect(x, y, 40, 60);
                g.setColor(toldo);
                g.fillRect(x+5, y+25, 30, 25);
                g.setColor(Color.WHITE);
                g.fillRect(x+5, y+15, 30, 8);
                g.fillRect(x+5, y+45, 30, 6);
                g.fillOval(x+8, y+4, 6, 6);
                g.fillOval(x+28, y+4, 6, 6);
                //llantas
                g.setColor(Color.black);
                g.fillOval(x-5, y+8, 4, 10);
                g.fillOval(x+40, y+8, 4, 10);
                g.fillOval(x-5, y+35, 4, 10);
                g.fillOval(x+40, y+35, 4, 10);
                break;
        }
    }
    
    public void mover(){
        switch(direccion){
            case 1:
                x+=desplazamiento;
                if(x>850){
                    x=(int) (Math.random()*50+100)*-1;
                    desplazamiento = (int) (Math.random()*7+5);
                    
                }
                break;
            case 2:
                x-=desplazamiento;
                if(x<-100){
                    x=(int) (Math.random()*100+900);
                    desplazamiento = (int) (Math.random()*7+5);
                }
                break;
            case 3:
                y+=desplazamiento;
                if(y>700){
                    y=(int) (Math.random()*50+100)*-1;
                    desplazamiento = (int) (Math.random()*7+5);
                }
                break;
            case 4:
                y-=desplazamiento;
                if(y<-100){
                    y=(int) (Math.random()*100+650);
                    desplazamiento = (int) (Math.random()*7+5);
                }
                break;
        }
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true){
            try {
                switch (direccion){
                    case 1:
                        if(x>=190 && x<=200){
                            if(semaforo.estado==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        escenario.repaint();
                        break;
                    case 2:
                        if(x>=500 && x<=520){
                            if(semaforo.estado==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        escenario.repaint();
                        break;
                    case 3:
                        if(y>=130 && y<=150){
                            if(semaforo.estado==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        escenario.repaint();
                        break;
                    case 4:
                        if(y>=420 && y<=430){
                            if(semaforo.estado==1){
                                mover();
                            }
                        } else{
                            mover();
                        }
                        escenario.repaint();
                        break;
                }
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
