package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Character {
	GamePanel gp;
	public int mapX;
	public int mapY;
	public int speed;
	public BufferedImage up1;
	public BufferedImage up2;
	public BufferedImage down1;
	public int animationCounter = 0;
	public BufferedImage down2;
	public BufferedImage left1;
	public BufferedImage left2;
	public BufferedImage right1;
	public BufferedImage right2;
	public String direction;
	public int animationNum = 1;
	public Rectangle recArea;
	public int recAreaDefaultX;
	public int recAreaDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter;
	public boolean invincible = false;
	public int invincibleCounter = 0;
	public boolean onPath;

	public int maxHP;
	public int hp;

	/**
	 * Constructs a new Character
	 *
	 * @param gp The GamePanel where the character is created on
	 */
	public Character(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * Sets the enemy / ghost action, implemented in the enemy class
	 */
	public void setAction() {
	}

	/**
	 * Checks for collisions with tiles, objects, and other characters.
	 * Adjusts character state based on collisions detected.
	 */
	public void checkCollision() {
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkPrisoner(this);
		boolean touch = gp.cChecker.checkPrisoner(this);
		if (touch == true) {
			if (gp.prisoner.invincible == false) {
				gp.prisoner.hp -= 8;
				gp.prisoner.invincible = true;
			}
		}
	}

	/**
	 * Updates the character's state.
	 */
	public void update() {
		setAction();

		checkCollision();

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

	/**
	 * Draws the character to the parameter Graphics2D.
	 *
	 * @param g2 the graphics2d object to render the character's image onto the game
	 */
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		String str;
		int screenX = this.mapX - gp.prisoner.mapX + gp.prisoner.monitorX;
		int screenY = this.mapY - gp.prisoner.mapY + gp.prisoner.monitorY;

		gp.getClass();
		gp.getClass();
		gp.getClass();
		gp.getClass();
		if (this.mapX + 48 > gp.prisoner.mapX - gp.prisoner.monitorX
				&& this.mapX - 48 < gp.prisoner.mapX + gp.prisoner.monitorX
				&& this.mapY + 48 > gp.prisoner.mapY - gp.prisoner.monitorY
				&& this.mapY - 48 < gp.prisoner.mapY + gp.prisoner.monitorY) {

			switch ((str = this.direction).hashCode()) {
				case 3739:
					if (!str.equals("up"))
						break;
					if (this.animationNum == 1) {
						image = this.up1;
					}
					if (this.animationNum == 2)
						image = this.up2;
					break;
				case 3089570:
					if (!str.equals("down"))
						break;
					if (this.animationNum == 1) {
						image = this.down1;
					}
					if (this.animationNum == 2)
						image = this.down2;
					break;
				case 3317767:
					if (!str.equals("left"))
						break;
					if (this.animationNum == 1) {
						image = this.left1;
					}
					if (this.animationNum == 2)
						image = this.left2;
					break;
				case 108511772:
					if (!str.equals("right"))
						break;
					if (this.animationNum == 1) {
						image = this.right1;
					}
					if (this.animationNum == 2) {
						image = this.right2;
					}
					break;
			}

			this.gp.getClass();
			this.gp.getClass();
			g2.drawImage(image, screenX, screenY, null);
		}

		gp.getClass();
		gp.getClass();
		g2.drawImage(image, screenX, screenY, 48, 48, null);
	}

	/**
	 * Loads and scales character images from resources.
	 *
	 * @param imageName The name of the image to load.
	 * @return A BufferedImage of the loaded and scaled image.
	 */
	public BufferedImage setup(String imageName) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;

		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Determines the path for the character to follow towards a specified goal.
	 *
	 * @param goalCol The column of the goal location.
	 * @param goalRow The row of the goal location.
	 */
	public void searchPath(int goalCol, int goalRow) {
		int startCol = (mapX + recArea.x) / gp.tileSize;
		int startRow = (mapY + recArea.y) / gp.tileSize;

		gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);

		if (gp.pFinder.search() == true) {

			int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
			int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

			int enLeftX = mapX + recArea.x;
			int enRightX = mapX + recArea.x + recArea.width;
			int enTopY = mapY + recArea.y;
			int enBottomY = mapY + recArea.y + recArea.height;

			if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
				direction = "up";
			} else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
				direction = "down";
			}

			else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
				if (enLeftX > nextX) {
					direction = "left";
				}
				if (enLeftX < nextX) {
					direction = "right";
				}
			} else if (enTopY > nextY && enLeftX > nextX) {
				direction = "up";
				checkCollision();
				if (collisionOn == true) {
					direction = "left";
				}
			} else if (enTopY > nextY && enLeftX > nextX) {
				direction = "up";
				checkCollision();
				if (collisionOn == true) {
					direction = "right";
				}
			} else if (enTopY < nextY && enLeftX > nextX) {

				direction = "down";
				checkCollision();
				if (collisionOn == true) {
					direction = "left";
				}
			} else if (enTopY < nextY && enLeftX < nextX) {

				direction = "down";
				checkCollision();
				if (collisionOn == true) {
					direction = "right";
				}
			}
			int nextCol = gp.pFinder.pathList.get(0).col;
			int nextRow = gp.pFinder.pathList.get(0).row;
			if (nextCol == goalCol && nextRow == goalRow) {
				onPath = false;
			}

		}
	}
}