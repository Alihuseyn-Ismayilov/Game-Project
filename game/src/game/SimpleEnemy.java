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
public class SimpleEnemy extends GameObject {
    private Random rand = new Random();
    private int int_random , int_randomY ;
    public  final double damage =  (5/60);

    


    public SimpleEnemy(int x, int y, ID id) {
        super(x, y, id);
        this.velX = 3;
        this.velY = 3;
        width = 30;
        height = 30;
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
        }
        if(y == Game.HEIGHT -height-5 || y == 0 ){
            
             this.setVelY(-velY);
        }
        
        
        this.x += velX;
        this.y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y , width , height);
    }

    
    
}
