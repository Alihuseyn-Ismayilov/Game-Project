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
 * @author ALIHUSEYIN
 */
public class CoinBar extends GameObject{
    private String coins = "0";
    public CoinBar(int x, int y, ID id) {
        super(x, y, id);
        this.width = 30;
        this.height = this.width;
    }

    public String getCoins() {
        return coins;
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(255,255,255,100));
        g.fillRect(x, y , width+20 , height+5);
        g.setColor(Color.black);
        g.drawString(coins, x+1*width/5, y+3*height/4);
    }
    public void increaseCoins(int coins){
        this.coins = String.valueOf(Integer.parseInt(this.coins)+coins);
        
    }
    
}
