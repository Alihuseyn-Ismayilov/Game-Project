/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author ALIHUSEYIN
 */
public class Window {
    public Window(int width , int height , String title , Game game){
         JFrame frame = new JFrame(title);
         frame.setPreferredSize(new Dimension(width + 5  , height+35));
         frame.setMaximumSize(new Dimension(width + 5, height+ 35));
         frame.setMinimumSize(new Dimension(width + 5,height+ 35));
         
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);
         frame.setLocationRelativeTo(null);
         frame.add(game);
         
         frame.setVisible(true);
         game.start();
         
    }
    
}
