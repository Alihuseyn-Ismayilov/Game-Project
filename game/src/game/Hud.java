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
public class Hud extends GameObject {

    protected int width2 = 250;
    protected double width2Float = 250.0;

    public Hud(int x, int y, ID id) {
        super(x, y, id);
        this.width = 250;
        this.height = 30;
    }

    public Hud() {

    }

    public int getWidth2() {
        return width2;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        this.width = this.width;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(50, 0, 0, 100));
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0, 255, 0, 100));
        g.fillRect(x, y, width2, height);
    }

    public void decreaseHealth(double damage) {
        if (width2Float >= 0) {
            if (width2Float - damage < 0) {
                this.width2Float = 0;
            } else {
                this.width2Float -= damage;
            }

            this.width2 = (int) this.width2Float;
        }

    }

    public void increaseHealth(double heal) {
        if (width2Float <= 250) {
            if (this.width2Float + heal > 250) {
                this.width2Float = 250;
            } else {
                this.width2Float += heal;
            }

            this.width2 = (int) this.width2Float;
        }

    }

}
