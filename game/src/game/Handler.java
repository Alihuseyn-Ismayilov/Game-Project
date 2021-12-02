/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ALIHUSEYIN
 */
public class Handler {
    
    ArrayList<GameObject> object = new ArrayList();
    public void render(Graphics g){
    for(int i = 0;i < object.size();i++){
        GameObject tempObject = object.get(i);
    if(tempObject!= null) tempObject.render(g);
}
    }
    
    public void tick(){
        for(int i =0;i<object.size();i++){
            GameObject tempObject =  object.get(i);
            if(tempObject!=null)tempObject.tick();
        }
        this.removeCoin();
        this.removeHealth();
        //this.collision();
        
    }
    public void addObject(GameObject object){
    this.object.add(0,object);
}
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    private void removeCoin(){
        int counter = 0;
        for(int i = 0;i < this.object.size()-3;i++){
        GameObject tempObject = this.object.get(i);
    if(tempObject!= null && tempObject.id == ID.Coin){ 
        counter++;
        if(counter == 4){
        this.removeObject(tempObject);
    }
    }
    }
}
    
    public void removeHealth(){
        int counter = 0;
        for(int i = 0;i<this.object.size()-3;i++){
            GameObject tempObject = this.object.get(i);
            if(tempObject != null && tempObject.id == ID.Health){
                counter++;
                if(counter == 4) this.removeObject(tempObject);
            }
        }
    }
    /*private void collision() {
        if(this.object.size() != 0){
            Hud hud = (Hud) this.object.get(this.object.size()-1);
        Player player = (Player) this.object.get(this.object.size()-3);
        CoinBar coinBar = (CoinBar) this.object.get(this.object.size()-2);
        for (int i = 0; i < (this.object.size() - 2); i++) {
            GameObject tempObject = this.object.get(i);
            if (player.getBounds().intersects(tempObject.getBounds())) {
                if (tempObject.id == ID.SimpleEnemy) {
                    hud.decreaseHealth(0.5);
                } if(tempObject.id == ID.Coin){
                    coinBar.increaseCoins(20);
                    
                    this.removeObject(tempObject);
                }if(tempObject.id == ID.Health){
                    hud.increaseHealth(15.0);
                    this.removeObject(tempObject);
                }if(tempObject.id == ID.UnpredictableEnemyObject){
                    hud.decreaseHealth(1.5);
                }if(tempObject.id == ID.SmartEnemy){
                    hud.decreaseHealth(2);
                }
            }
            

 

        }

        }
 

    }*/
    public void removeAll(){
         
        this.object.clear();
    
        
    }
    public void clear(){
this.object.remove(object);
}
    
}

