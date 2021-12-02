/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

 

/**
 *
 * @author PiNGivin
 */
public class Health extends GameObject {

 

    public Health(int x, int y, ID id) {
        super(x, y, id);
        this.width = 60;
        this.height = 40;
    }

 

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

 

    @Override
    public void tick() {
           
       

    }

 

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.fillRect(x+((width - (width/4))/2), y, (width/4), height);
        g.setColor(Color.white);
        g.fillRect(x, y + ((height-(height/3))/2), width, height/3);
        
    }

 

    

 


    

 

}
