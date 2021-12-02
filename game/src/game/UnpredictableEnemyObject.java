/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ALIHUSEYIN
 */
public class UnpredictableEnemyObject extends GameObject {
    private Random rand = new Random();
    private int int_random , int_randomY ;
    private long initialTime = System.nanoTime();
    private long delta;
    private int counter;
    private boolean bX = true;
    private boolean bY = true;

    public UnpredictableEnemyObject(int x, int y, ID id) {
        super(x, y, id);
        this.velX = 6;
        this.velY = 6;
        width = 60;
        height = 60;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
        x = Game.clamp(x,0,Game.WIDTH -width-5);
        y = Game.clamp(y,0,Game.HEIGHT - height-5);
        
       
        
        if(x == Game.WIDTH -width-5 || x == 0 ){
             
             this.setVelX(-velX);
             counter++;
        }
        this.unpredictableBehavior();
        if(y == Game.HEIGHT -height-5 || y == 0 ){
             
             this.setVelY(-velY);
             counter++;
        } 
        this.unpredictableBehavior();
        
        this.x += velX;
        this.y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fill3DRect(x, y , width , height,true);
    }
    
    private void unpredictableBehavior(){
       if(counter>=3){
               if(bX){
                   velX = velX*2;
               }else{
                   velX = velX/2;
               }   
           
                
               bX  =!  bX;
           if(bY){
                   velY = velY*2;
               }else{
                   velY = velY/2;
               }   
           
              
               bY  =!  bY;
           counter = 0;
       }
       
    }

    
    
}
