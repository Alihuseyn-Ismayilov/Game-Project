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
public class Animation {



public static int animationClock = 0;



private static ArrayList<BufferedImage> wall;
static ArrayList<BufferedImage> ground;
private static ArrayList<BufferedImage> player;
static ArrayList<BufferedImage> surprizeBox;
private static ArrayList<BufferedImage> platform;
private static BufferedImage spreadSheet;
private int movement = 0;



public Animation() {
ground = new ArrayList();
wall = new ArrayList();
player = new ArrayList();
surprizeBox = new ArrayList();
platform = new ArrayList();



try {
spreadSheet = ImageIO.read(getClass().getResource("res/spreadSheet.jpg"));
} catch (Exception e) {
System.out.println("No spreadsheet founded!" + e);
}



loadSpreadSheet();
}



public static int getClock() {
return animationClock;
}



public static void tick() {
++animationClock;
if (animationClock == 60) {
animationClock = 0;
}
}



private void loadSpreadSheet() {
loadSheet(ID.SurprizeBox, 16, 16);
loadSheet(ID.Player, 16, 32);
loadSheet(ID.Ground, 16, 16);
loadSheet(ID.Platform, 48, 8);
loadSheet(ID.Wall, 16, 16);



}



private ArrayList<BufferedImage> loadSheet(ID id, int bitWidth, int bitHeight) {
int count = 1;
int row = 0;
int begin = 0;



ArrayList<BufferedImage> list;



if (null == id) {
list = new ArrayList();
} else {
switch (id) {



case Player:
begin = 0;
count = 14;
row = 12;
list = player;



case Ground:
begin = 18;
count = 1;
row = 4;
list = ground;



break;

case Wall:
begin = 8;
count = 1;
row = 4;
list = wall;



break;



case Platform:
begin = 20;
count = 1;
row = 0;
list = platform;



case SurprizeBox:
begin = 0;
count = 4;
row = 4;
list = surprizeBox;



break;



default:
list = new ArrayList();
break;
}
}
for (int i = begin; i < (count + begin); i++) {
list.add(spreadSheet.getSubimage(i * 33, row * 33, bitWidth, bitHeight));
}
return list;



}



/**
*
* @return
*/
public static int getAnimationClock() {
return animationClock;
}
}
