/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author ALIHUSEYIN
 */
import java.awt.Graphics;
import java.awt.Rectangle;



/**
*
* @author User
*/
public class SurprizeBox extends GameObject {



int counter = 0;

public SurprizeBox(int x, int y, ID id) {
super(x, y, id);
}



@Override
public void tick() {
counter++;
if (counter > 30) counter = 0;
}



@Override
public void render(Graphics g) {
g.drawImage(Animation.surprizeBox.get(counter/30), x, y, width, height, null);
}



@Override
public Rectangle getBounds() {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}



}
