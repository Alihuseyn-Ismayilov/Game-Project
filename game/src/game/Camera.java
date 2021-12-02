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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



/**
*
* @author User
*/
class Camera extends GameObject {



int x, y;
private Player object;



public Camera() {
super(0, 0, ID.Camera);
object = GSpace.getPlayer();
}



public void tick() {
x += Math.round(((object.getX() * GSpace.cameraBoom + object.getBounds().width * GSpace.cameraBoom - x) - Game.WIDTH/2) * 0.05f * GSpace.cameraBoom);
y += Math.round(((object.getY() * GSpace.cameraBoom + object.getBounds().height * GSpace.cameraBoom - y) - Game.HEIGHT/2) * 0.05f * GSpace.cameraBoom);



}



@Override
public Rectangle getBounds() {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}



@Override
public void render(Graphics g) {
g.setColor(Color.blue);
g.fill3DRect(x, y, 10, 10, true);
}



}
