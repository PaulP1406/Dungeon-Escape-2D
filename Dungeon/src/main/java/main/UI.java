package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import object.Object;
import object.*;
import main.GamePanel;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    public int commandNum;
    Font fontWeight40;
    Font fontWeight80B;
    BufferedImage heart_empty, heart_half, heart_full, skullImage, chestImage;
    public String message = "";
    int messageCounter = 0;
    public double playTime=0;
    DecimalFormat dF = new DecimalFormat("#0.00");

    /**
     * Constructs a new UI object.
     * @param gp The GamePanel associated with this UI.
     */
    public UI(GamePanel gp) {
        this.gp = gp;
        this.fontWeight40 = new Font("Calibri", 0, 40);
        this.fontWeight80B = new Font("Calibri", 1, 80);
        Skull skull = new Skull(gp);
        Chest chest = new Chest(gp);
        chestImage = chest.image;
        skullImage = skull.image;
        Object heart = new Heart(gp);
        heart_empty = heart.image3;
        heart_half = heart.image2;
        heart_full = heart.image;
    }
    /**
     * Draws the game UI.
     * @param g2 The Graphics2D object to draw on.
     */
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(getFontWeight40());
        g2.setColor(Color.white);
        drawPlayerHealth(g2);
        // Adjusted the y-coordinate of the score to move it lower
        g2.drawString("Score: " + gp.prisoner.score, 550, 50);
        g2.drawImage(getChestImage(), 600, 60, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.prisoner.chestCount, 660, 100);
        g2.drawImage(getSkullImage(), 600, 110, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.prisoner.skullCount, 660, 150);
        // Added the time display between the hearts and score
       // g2.setFont(new Font("Arial", Font.BOLD, 30));
        g2.drawString("Time: "+getdF().format(playTime)+"s",275, 50);
        
        if (gp.gameState == gp.playState) {
        	playTime+=(double)1/60;           
            
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        if (gp.gameState == gp.gameOver) {
            drawGameOverScreen();
        }
        if (gp.gameState == gp.gameFinished) {
        	drawGameFinishedScreen();
        }
    }
    /**
     * Draws the player's health bar.
     * @param g2 The Graphics2D object to draw on.
     */
    public void drawPlayerHealth(Graphics2D g2) {
        // Draw hearts representing player health
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;
        while (i < gp.prisoner.maxHP / 2) {
            g2.drawImage(getHeart_empty(), x, y, null);
            x += gp.tileSize;
            i++;
        }
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;
        while (i < gp.prisoner.hp) {
            g2.drawImage(getHeart_half(), x, y, null);
            i++;
            if (i < gp.prisoner.hp) {
                g2.drawImage(getHeart_full(), x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    /**
     * Draws the pause screen.
     */
    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
        
    }
    /**
     * Draws the game over screen.
     */
    public void drawGameOverScreen() {
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        int x;
        int y;
        String text = "Game Over";
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 109f));
        x = getXforCenteredText(text);
        y = gp.tileSize * 4;
        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getXforCenteredText(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - 40, y);
        }
    }
    		   /**
    	     * Draws the game finished screen.
    	     */
    public void drawGameFinishedScreen() {
   	 g2.setColor(new Color(70, 66,66, 200));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        int x;
        int y;
        String text = "You Completed The Game!";
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60f));
        x = getXforCenteredText(text);
        y = gp.tileSize * 4;
        g2.drawString(text, x, y);
        text = "Your Play Time Was: "+getdF().format(playTime)+"s";
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40f));
        x = getXforCenteredText(text);
        y += gp.tileSize * 1;
        g2.drawString(text, x, y);
        text = "Your Final Score Was: "+gp.prisoner.score;
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40f));
        x = getXforCenteredText(text);
        y += gp.tileSize * 1;
        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Play Again";
        x = getXforCenteredText(text);
        y += gp.tileSize * 2;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - 40, y);
        }
    }
    /**
     * Gets the x-coordinate for drawing centered text.
     * @param text The text to be centered.
     * @return The x-coordinate for drawing centered text.
     */
    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
	public BufferedImage getChestImage() {
		return chestImage;
	}
	public BufferedImage getSkullImage() {
		return skullImage;
	}
	public BufferedImage getHeart_empty() {
		return heart_empty;
	}
	public BufferedImage getHeart_full() {
		return heart_full;
	}
	public BufferedImage getHeart_half() {
		return heart_half;
	}
	public Font getFontWeight40() {
		return fontWeight40;
	}
	public DecimalFormat getdF() {
		return dF;
	}
	public Font getFontWeight80B() {
		return fontWeight80B;
	}
}