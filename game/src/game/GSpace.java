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
class GSpace {
    static int multSize = 2;
static float gameBoom = 1;
static int ObjectSize = 32;
private static Game game;
private static Player player;
private static Handler handler;
private static Hud hud;
static Camera camera;
static float cameraBoom = 1;



public static Camera getCamera() {
if (camera == null) {
camera = new Camera();
}
return camera;
}



public static Camera setCamera(Camera camera) {
GSpace.camera = camera;
return camera;
}



public static Game getGame() {
return game;
}



public static void setGame(Game game) {
GSpace.game = game;
}



public static Player getPlayer() {
if (player == null) {
player = new Player(10, 10, ID.Player);



if (handler == null) {
getHandler();
handler.addObject(player);
}
}
return player;
}



public static Player setPlayer(Player player) {
if (player == null) {
GSpace.player = player;
if (handler == null) {
getHandler();
handler.addObject(player);
}
}
return GSpace.player;
}



public static Handler getHandler() {
if (handler == null) {
handler = new Handler();
}
return handler;
}



public static Handler setHandler(Handler handler) {
GSpace.handler = handler;
return handler;
}



public static Hud getHud() {
if (hud == null) {
hud = new Hud();
}
return hud;
}



public static Hud setHud(Hud hud) {
GSpace.hud = hud;
return hud;
}
    
}
