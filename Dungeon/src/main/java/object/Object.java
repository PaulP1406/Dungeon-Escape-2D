package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.UtilityTool;

/**
 * Acts as a Superclass for in-game object containing the image, object name,
 * collision type,
 * and position on the game map.
 */
public class Object {
    /** Object Images */
    public BufferedImage image, image2, image3;
    /** Object Names */
    public String name;
    /** Indicates whether the object can collide with other objects. */
    public boolean collision = false;
    /** X-coordinate of the object on the map. */
    public int mapX;
    /** Y-coordinate of the object on the map. */
    public int mapY;
    /** Rectangular area representing the solid part of the object. */
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    /** Default x-coordinate of the solid area relative to the object's position. */
    public int solidAreaDefaultX = 0;
    /**
     * The default Y-coordinate of the solid area relative to the object's position.
     */
    public int solidAreaDefaultY = 0;
    /** Utility tool used for image scaling. */
    UtilityTool uTool = new UtilityTool();
    /** Game panel associated with the object. */
    public GamePanel gp;

    /** Constructor */
    public Object() {
        // Initialize the image here, replace null with your actual BufferedImage
        this.image = new BufferedImage(48, 48, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Draws the object on the screen.
     * 
     * @param g2 The graphics context used for drawing.
     * @param gp The game panel to which the object belongs.
     */
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = this.mapX - gp.prisoner.mapX + gp.prisoner.monitorX;
        int screenY = this.mapY - gp.prisoner.mapY + gp.prisoner.monitorY;
        if (screenX + 48 > 0 && screenX < gp.prisoner.monitorX * 2
                && screenY + 48 > 0 && screenY < gp.prisoner.monitorY * 2) {
            g2.drawImage(this.image, screenX, screenY, 48, 48, null);
        }
    }

}
