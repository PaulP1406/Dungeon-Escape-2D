/**
 * Represents the player character in the game.
 * This class extends the Character class and defines specific behaviors and attributes for the player character.
 * The player can move, interact with objects, and perform various actions.
 */
package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import character.Enemy;
import main.GamePanel;
import main.KeyChecker;
import main.UtilityTool;

public class Prisoner extends Character {
	public KeyChecker keyPressed;
	public int monitorX;
	public int monitorY;

	public int score = 0;
	public int skullCount = 0;
	public int chestCount = 0;

	boolean bootsOn = false;
	int bootsCounter = 0;

	/**
	 * Initializes the player character with the given game panel reference and key
	 * checker.
	 * Sets default attributes, loads player images, and sets initial position.
	 * 
	 * @param gp   The game panel to which the player belongs.
	 * @param keyH The key checker for handling player input.
	 */
	public Prisoner(GamePanel gp, KeyChecker keyH) {
		super(gp);
		this.gp = gp;
		this.keyPressed = keyH;

		gp.getClass();
		gp.getClass();
		this.monitorX = 768 / 2 - 48 / 2;
		gp.getClass();
		gp.getClass();
		this.monitorY = 576 / 2 - 48 / 2;

		this.recArea = new Rectangle();
		this.recArea.x = 8;
		this.recArea.y = 16;
		this.recAreaDefaultX = this.recArea.x;
		this.recAreaDefaultY = this.recArea.y;
		this.recArea.width = 32;
		this.recArea.height = 32;

		setDefaultValues();
		getPlayerImage();
	}

	/**
	 * Sets default values for the player character.
	 */
	public void setDefaultValues() {
		this.gp.getClass();
		this.mapX = 48 * 26;
		this.gp.getClass();
		this.mapY = 48 * 40;
		score = 0;
		skullCount = 0;
		chestCount = 0;
		this.speed = 4;
		this.direction = "down";

		// player status;
		this.maxHP = 10;
		this.hp = this.maxHP - 2;
		invincible = false;
	}

	/**
	 * Loads player images for each direction of movement.
	 */
	public void getPlayerImage() {

		this.up1 = setup("/player/Prisoner_up_1");
		this.up2 = setup("/player/Prisoner_up_2");
		this.down1 = setup("/player/Prisoner_down_1");
		this.down2 = setup("/player/Prisoner_down_2");
		this.left1 = setup("/player/Prisoner_left_1");
		this.left2 = setup("/player/Prisoner_left_2");
		this.right1 = setup("/player/Prisoner_right_1");
		this.right2 = setup("/player/Prisoner_right_2");

	}

	/**
	 * Updates the state of the player character based on user input and game
	 * events.
	 */
	public void update() {
		if (this.keyPressed.upPressed || this.keyPressed.downPressed ||
				this.keyPressed.leftPressed || this.keyPressed.rightPressed) {

			if (this.keyPressed.upPressed) {
				this.direction = "up";
			} else if (this.keyPressed.downPressed) {
				this.direction = "down";
			} else if (this.keyPressed.leftPressed) {
				this.direction = "left";
			} else if (this.keyPressed.rightPressed) {
				this.direction = "right";
			}

			this.collisionOn = false;
			this.gp.cChecker.checkTile(this);

			int objIndex = this.gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);

			int enemyIndex = gp.cChecker.checkEntity((this), gp.enemy);
			interactEnemy(enemyIndex);

			// Tiles related event controlled here:
			gp.eHandler.checkEvent();

			if (!this.collisionOn) {
				String str;
				switch ((str = this.direction).hashCode()) {
					case 3739:
						if (!str.equals("up"))
							break;
						this.mapY -= this.speed;
						break;
					case 3089570:
						if (!str.equals("down"))
							break;
						this.mapY += this.speed;
						break;
					case 3317767:
						if (!str.equals("left"))
							break;
						this.mapX -= this.speed;
						break;
					case 108511772:
						if (!str.equals("right"))
							break;
						this.mapX += this.speed;
						break;
				}
			}
			this

					.animationCounter = this.animationCounter + 1;
			if (this.animationCounter > 12) {
				if (this.animationNum == 1) {
					this.animationNum = 2;
				} else if (this.animationNum == 2) {
					this.animationNum = 1;
				}
				this.animationCounter = 0;
			}
		}
		if (invincible == true) {
			invincibleCounter++;
			if (invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		if (hp <= 0) {
			gp.gameState = gp.gameOver;

		}

	}

	/**
	 * Handles picking up objects when the player interacts with them.
	 * 
	 * @param i The index of the object to interact with.
	 */
	public void pickUpObject(int i) {
		if (i != 999) {
			// PickUp Items
			String objectName = gp.obj[i].name;
			if (objectName == "SpeedBoots") {
				this.speed += 1;
				gp.obj[i] = null;
				score += 500;
			} else if (objectName == "Heart") {
				int health = this.hp + 2;
				score += 1000;
				if (health > this.maxHP)
					this.hp = maxHP;
				else
					this.hp = health;
				gp.obj[i] = null;
			} else if (objectName == "Chest") {
				gp.obj[i] = null;
				score += 200;
				chestCount += 1;

			} else if (objectName == "Skull") {
				gp.obj[i] = null;
				score += 200;
				skullCount += 1;

			}
		}
	}

	/**
	 * Handles interaction with enemy characters.
	 * 
	 * @param i The index of the enemy character to interact with.
	 */
	public void interactEnemy(int i) {
		if (i != 999) {
			// die method
			if (invincible == false) {
				hp -= 8;
				invincible = true;
			}
		}
	}

}
