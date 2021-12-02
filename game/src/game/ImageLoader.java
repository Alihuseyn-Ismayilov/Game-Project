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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
 
/**
 *
 * @author User
 */
public class ImageLoader {

    private BufferedImage world;

    public static BufferedImage loadImage(String path, Object obj){
        BufferedImage image = null;

        try {
            image = ImageIO.read(obj.getClass().getResource(path));
        } catch (Exception ex) {
            System.out.println("No world picture found!" + path);
            System.exit(0);
        }


        return image;
    }

    public static void loadLevel(BufferedImage image, Handler handler, Player player) {

        handler.clear();
        int size = GSpace.multSize;
        int w = image.getWidth();
        int h = image.getHeight();
        for (int xx = 0; xx < w; xx += 16) {
            for (int yy = 0; yy < h; yy += 16) {

                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;

                if (red == 255 && green == 0 && blue == 0) {
                    //Surprize Box
                    handler.addObject(new SurprizeBox(xx*size,yy*size,ID.SurprizeBox));
                } else if (red == 255 && green == 255 && blue == 0) {      
                    //Wall
                    handler.addObject(new Ground(xx*size,yy*size,ID.Wall));
                }else if(red == 0 && green == 255 && blue == 255){
                    //Enemy

                }else if(red == 0 && green == 255 && blue == 255){
                    //Ground
                    handler.addObject(new Ground(xx*size,yy*size,ID.Ground,32*size,32*size));
                }
                else if (red == 0 && green == 0 && blue == 255) {      
                    //Player
                    player.setX(xx*size);
                    player.setY(yy*size);
                    handler.addObject(player);
                }
            }

        }
    }
}
