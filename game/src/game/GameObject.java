/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 *
 * @author ALIHUSEYIN
 */
public abstract class GameObject implements Serializable{
    protected int x , y;
    protected ID id;
    protected int velX , velY;
    protected int width = 16*GSpace.multSize;
    protected int height = 16*GSpace.multSize;
    boolean hasGavity = true;
    protected boolean isFalling = true;
    protected float gravity = 0.07f;
    
    
    public GameObject(){
        
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    public GameObject(int x , int y , ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public void  setVelX(int velX){
        this.velX = velX;
    }
    public void  setVelY(int velY){
        this.velY = velY;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public abstract Rectangle getBounds();
    public abstract void tick();
    public abstract void render(Graphics g);
   
}
