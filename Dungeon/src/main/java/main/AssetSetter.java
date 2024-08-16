 package main;
 import character.Enemy;
import object.Boots;
 import object.Chest;
 
import object.Heart;
import object.Skull;
import object.Object;

/**
 * Sets up game assets such as objects and enemies.
 */
public class AssetSetter {
   /** Game panel associated with asset setter. */
   GamePanel gp;
   /**
     * Constructs an AssetSetter object with the specified GamePanel.
     * 
     * @param gp The game panel associated with the asset setter.
     */
   public AssetSetter(GamePanel gp) {
     this.gp = gp;
   }
    /**
     * Sets up game objects on the map.
     */
   public void setObject() {
    int i = 0; 
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 26;
    gp.obj[i].mapY = gp.tileSize * 28;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 27;
    gp.obj[i].mapY = gp.tileSize * 28;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 23;
    gp.obj[i].mapY = gp.tileSize * 23;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 30;
    gp.obj[i].mapY = gp.tileSize * 23;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 9;
    gp.obj[i].mapY = gp.tileSize * 38;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 44;
    gp.obj[i].mapY = gp.tileSize * 38;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 8;
    gp.obj[i].mapY = gp.tileSize * 14;
    i++;
    gp.obj[i] = new Chest(gp);
    gp.obj[i].mapX = gp.tileSize * 45;
    gp.obj[i].mapY = gp.tileSize * 14;
    i++;
    gp.obj[i] = new Skull(gp);
    gp.obj[i].mapX = gp.tileSize * 12;
    gp.obj[i].mapY = gp.tileSize * 29;
    i++;
    gp.obj[i] = new Skull(gp);
    gp.obj[i].mapX = gp.tileSize * 41;
    gp.obj[i].mapY = gp.tileSize * 29;
    i++;
    gp.obj[i] = new Skull(gp);
    gp.obj[i].mapX = gp.tileSize * 13;
    gp.obj[i].mapY = gp.tileSize * 1;
    i++;
    gp.obj[i] = new Skull(gp);
    gp.obj[i].mapX = gp.tileSize * 40;
    gp.obj[i].mapY = gp.tileSize * 1;
    i++;   
   }
   /**
     * Sets up enemies on the map.
     */
   public void setEnemy() {
    gp.enemy[0]=new Enemy(gp);
    gp.enemy[0].mapX=gp.tileSize*2;
    gp.enemy[0].mapY=gp.tileSize*2;
    gp.enemy[1]=new Enemy(gp);
    gp.enemy[1].mapX=gp.tileSize*10;
    gp.enemy[1].mapY=gp.tileSize*10;
    gp.enemy[2]=new Enemy(gp);
    gp.enemy[2].mapX=gp.tileSize*30;
    gp.enemy[2].mapY=gp.tileSize*30;
   }

}