/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Player extends GameObject {



boolean[] keyPressed = new boolean[5];
Handler handler;
// SmartEnemy smartenemy;
Color col;
int health = 100;
int point = 0;
private float speed = 0.05f;
private float friction = 0.01f;
private float jumping = 5;
GameObject boxTrigger = null;



public Player(int x, int y, ID id) {
super(x, y, id);
this.handler = GSpace.getHandler();



col = Color.white;
velX = 0;
velY = 0;



width = 50;
height = 50;



keyPressed[0] = false;
keyPressed[1] = false;
keyPressed[2] = false;
keyPressed[3] = false;
keyPressed[4] = false;



}



@Override
public Rectangle getBounds() {
return new Rectangle(x, y, width, height);
}



private void Collision() {
for (int i = 0; i < handler.object.size(); i++) {
GameObject obj = handler.object.get(i);
if (obj.getBounds().intersects(getBounds())) {
if (obj.id == ID.Ground) {
isFalling = true;
velY = 0;
y = obj.getY() - height;
}else if(obj.id == ID.BoxTrigger){
boxTrigger = obj;
}
}
}
}



@Override
public void render(Graphics g) {
g.setColor(col);
g.fillOval(x, y, width, height);



}



@Override
public void tick() {
keyInput();
if (isFalling) {
velY += gravity;
} else {
if (velX >= 0) {
velX -= friction;
} else {
velX += friction;
}
}
x = Math.round(velX);
y = Math.round(velY);




Collision();
}



private void keyInput() {
// if (!isFalling) {
// if
// }
}
}