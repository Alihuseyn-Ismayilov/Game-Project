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
public class Ground extends GameObject{



public Ground(int x, int y, ID id) {
super(x, y, id);
}

public Ground(int x, int y, ID id, int width, int height) {
super(x, y, id);
this.width = width;
this.height = height;
}




@Override
public void tick() {

}



@Override
public void render(Graphics g) {
g.drawImage(Animation.ground.get(0), x, y,width,height, null);
}



@Override
public Rectangle getBounds() {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}
