package character;

import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyChecker;

/**
 * Represents an enemy character in the game world.
 * This class extends the Character class and defines specific behaviors and attributes for enemy characters.
 * Enemies can move, collide with objects, pursue the player, and perform various actions.
 */
public class Enemy extends Character {
	
	public boolean collision=false;
    /**
     * Initializes an enemy character with the given game panel reference.
     * Sets default attributes and loads enemy images.
     * @param gp The game panel to which the enemy belongs.
     */
	
	public Enemy(GamePanel gp) {
			super(gp);
			
		direction="down";
		speed=3;
		this.recArea = new Rectangle();
	    this.recArea.x = 8;
	    this.recArea.y = 16;
	    this.recAreaDefaultX = this.recArea.x;
	    this.recAreaDefaultY = this.recArea.y;
	    this.recArea.width = 32;
	    this.recArea.height = 32;
		    getEnemyImage();   	   
    }
	   /**
     * Updates the state of the enemy character.
     * Determines whether to pursue the player or wander randomly.
     */
	public void update() {
		super.update();
		
		int xDistance=Math.abs(mapX-gp.prisoner.mapX);
		int yDistance=Math.abs(mapY-gp.prisoner.mapY);
		int tileDistance=(xDistance+yDistance)/gp.tileSize;
		
		if(onPath==false&&tileDistance<5) {
		
			onPath=true;
		
		}
		if(onPath==true&&tileDistance>15) {
			onPath=false;
		}
	}

    /**
     * Loads enemy images for each direction of movement.
     */
	  public void getEnemyImage() {		  
			this.up1 = setup("/enemy/Ghost_up_1");
			this.up2 = setup("/enemy/Ghost_up_2");
			this.down1 = setup("/enemy/Ghost_down_1");
			this.down2 = setup("/enemy/Ghost_down_2");
			this.left1 = setup("/enemy/Ghost_left_1");
			this.left2 = setup("/enemy/Ghost_left_2");
			this.right1 = setup("/enemy/Ghost_right_1");
			this.right2 = setup("/enemy/Ghost_right_2");		    
	  }
	  /**
	     * Sets the action for the enemy character.
	     * If on path, pursues the player; otherwise, wanders randomly.
	     */
	  public void setAction() {
		  
		  if(onPath==true) {
			  
			  int goalCol=(gp.prisoner.mapX+20)/gp.tileSize;
			  int goalRow=(gp.prisoner.mapY+24)/gp.tileSize;
			  
			  searchPath(goalCol,goalRow);  	  	  
			  		  
		  } else {    
		  
			  actionLockCounter++;
			  if(actionLockCounter==60) {
			  Random random=new Random();
			  int i=random.nextInt(100)+1;
			  
			  if(i<=25) {
				  direction="up";
				 
			  }
			  if(i>25&&i<=50) {
				  direction="down";
				 
			  }
			  if(i>50&&i<=75) {
				  direction="left";
				 
			  }
			  if(i>75&&i<=100) {
				  direction="right";
					 
			  }
			  actionLockCounter=0;
		  }
		 }
	  }
}
