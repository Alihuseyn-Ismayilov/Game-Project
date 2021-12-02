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
public class SmartEnemy extends GameObject {

    public SmartEnemy(int x, int y, ID id) {
        super(x, y, id);
        this.velX = 1;
        this.velY = 1;
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
        this.x = Game.clamp(this.x,0,Game.WIDTH -width-5);
        this.y = Game.clamp(this.y,0,Game.HEIGHT - height-5);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(x, y , width , height);
    }
    public void  getPlayerXY(int x , int y){
        
        if(this.x <= x+20 ){
             this.x += this.velX;
        }else if(this.x >= x+20){
            this.x -= this.velX;
        }
        if(this.y  <= y+20 ){
             this.y += velY;
        }else if(this.y >= y+20){
            this.y -= velY;
        }
        
        
        
    }
    
}
