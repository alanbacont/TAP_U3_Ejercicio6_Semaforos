

import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergiocastillo
 */

public class Escenario extends Canvas{
    Semaforo s1,s2;
    Calle allende, insurgentes;
    Coche[] coche = new Coche[4];
    
    public Escenario(){
        s1 = new Semaforo(true,this,50,15);
        s2 = new Semaforo(false,this,600,415);
        allende = new Calle(false);
        insurgentes = new Calle(true);
        
        coche[0] = new Coche(10,330,1,s2,this);
        coche[1] = new Coche(570,230,2,s2,this);
        coche[2] = new Coche(335,-100,3,s1,this);
        coche[3] = new Coche(435,700,4,s1,this);
        
        for(int i=0; i<coche.length;i++){
            coche[i].start();
        }
        s1.start();
        s2.start();
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        this.setBackground(Color.BLACK);
        
        allende.pintar(g2);
        insurgentes.pintar(g2);
        
        for(int i=0; i<coche.length; i++){
            coche[i].pintar(g2);
        }
        
        s1.pintar(g2);
        s2.pintar(g2);
    }
}
