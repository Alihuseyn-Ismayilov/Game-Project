/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author ALIHUSEYIN
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1200, HEIGHT = 2 * WIDTH / 3;
    private Window gameWindow;
    private Thread thread;
    private boolean running = false;
    private Player player;
    private SimpleEnemy enemy1;
    private Handler handler;
    private SimpleEnemy enemy2;
    private UnpredictableEnemyObject enemy3;
    private int counter;
    private Random rand = new Random();
    private int randomIntegerX, randomIntegerY;
    private Hud hud;
    //private SmartEnemy smartEnemy;
    private CoinBar coinBar;
    private Camera camera;
    private Animation animation;

    /**
     * @param args the command line arguments
     */
    public Game() {
        initGame();
        loadLevel();
    }

    public void initGame() {
        animation = new Animation();
        handler = GSpace.getHandler();
        player = GSpace.setPlayer(new Player(100, 100, ID.Player));
        camera = GSpace.getCamera();
        hud = GSpace.getHud();

        addKeyListener(new KeyInput(this.player));
        
        gameWindow = new Window(WIDTH, HEIGHT, "FIRST GAME", this);

        this.start();
    }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double ammountOfTicks = 60.0;
        double ns = 1000000000 / ammountOfTicks;
        double delta = 0;

        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;

            }
            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                System.out.println("FPS :" + frames);
                frames = 0;
            }

        }
        stop();
    }

    private void tick() {
        //player.tick();
        handler.tick();
        camera.tick();

        /*
        counter++;
        
        if(counter == 300 || counter % 6000 == 0 ){
            randomIntegerX = rand.nextInt(WIDTH-100);
            randomIntegerY = rand.nextInt(HEIGHT-100);
            enemy2 = new SimpleEnemy(randomIntegerX,randomIntegerY,ID.SimpleEnemy);
            handler.addObject(enemy2);
        }if(counter == 900 || counter % 7300 == 0){
            randomIntegerX = rand.nextInt(WIDTH-100);
            randomIntegerY = rand.nextInt(HEIGHT-100);
            enemy3 = new UnpredictableEnemyObject(randomIntegerX,randomIntegerY,ID.UnpredictableEnemyObject);
            handler.addObject(enemy3);
        }if(counter  %240 ==0 &&  counter > 900){
            randomIntegerX = rand.nextInt(WIDTH-100);
            randomIntegerY = rand.nextInt(HEIGHT-100);
            Coin coin = new Coin(randomIntegerX,randomIntegerY,ID.Coin);
            handler.addObject(coin);
        }if(counter % 300 == 0 && counter > 1500){
            randomIntegerX = rand.nextInt(WIDTH-100);
            randomIntegerY = rand.nextInt(HEIGHT-100);
            Health health = new Health(randomIntegerX,randomIntegerY,ID.Health);
            handler.addObject(health);
        }if(counter == 1800){
         smartEnemy = new SmartEnemy(350,350,ID.SmartEnemy);
         handler.addObject(smartEnemy);
        }
        if((counter >= 1800)){
            smartEnemy.getPlayerXY(player.x,player.y);
        }*/
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(255, 150, 150));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Graphics2D g2d = (Graphics2D) g;

// BufferedImage image = ImageLoader.loadImage("\\res\\image.png");
        g2d.translate(-camera.getX(), -camera.getY());
// g.drawImage(image, 0, 0, this);
        handler.render(g);

        g2d.translate(camera.getX(), camera.getY());

        hud.render(g);
        g.dispose();
        bs.show();

    }

    public static int clamp(int number, int min, int max) {
        if (number >= max) {
            return number = max;
        } else if (number <= min) {
            return number = min;
        }
        return number;
    }/*
    public void GameWin(Graphics g){
        int playerCoins = Integer.parseInt(this.coinBar.getCoins());
        int playerHealth = this.hud.getWidth2();
        if(playerCoins == 1500){
            this.handler.removeAll();
           g.setColor(Color.white);
            g.fillRect(WIDTH/3+135, HEIGHT/3+20, 150, 100); 
            g.setColor(Color.black);
            g.drawString("YOU ARE WINNER",WIDTH/3+155, HEIGHT/3+70);
        }else if(playerHealth == 0){
            this.handler.removeAll();
            g.setColor(Color.white);
            g.fillRect(WIDTH/3+140, HEIGHT/3+20, 100, 100); 
            g.setColor(Color.black);
            g.drawString("GAME OVER",WIDTH/3+155, HEIGHT/3+70);
            
        }else{
            handler.render(g);
        }
    }*/


    private void loadLevel() {
        ImageLoader.loadLevel(ImageLoader.loadImage("\\res\\world1.png", this), handler, player);
    }

}
