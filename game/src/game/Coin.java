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
public class Coin extends GameObject {
     private Random rand = new Random();
    private int int_random , int_randomY ;

    public Coin(int x, int y, ID id) {
        super(x, y, id);
        this.width= 15;
        this.height =15;
        this.velX = 2;
        this.velY = 2;
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
             int_randomY = velY*(rand.nextBoolean() ? -1 : 1);
             this.setVelY(-velY);
        }
        
        
        this.x += velX;
        this.y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y , width , height);
    }

    
    
}
