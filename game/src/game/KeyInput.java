/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ALIHUSEYIN
 */
public class KeyInput extends KeyAdapter {
    private Player player;
    private Game game;
    
    public KeyInput(Game game , Player player){
        this.game = game ;
        this.player = player;
        
    }

    KeyInput(Player player) {
        this.player = player;
    }
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ESCAPE) System.exit(0);
        
        if(key == KeyEvent.VK_W) player.keyPressed[3] = true;
        if(key == KeyEvent.VK_A) player.keyPressed[1] = true;
        if(key == KeyEvent.VK_S) player.keyPressed[4] = true;
        if(key == KeyEvent.VK_D) player.keyPressed[2] = true;
        
        
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ESCAPE) System.exit(0);
        
        if(key == KeyEvent.VK_W) player.keyPressed[3] = false;
        if(key == KeyEvent.VK_A) player.keyPressed[1] = false;
        if(key == KeyEvent.VK_S) player.keyPressed[4] = false;
        if(key == KeyEvent.VK_D) player.keyPressed[2] = false;
        
        
    }
}
