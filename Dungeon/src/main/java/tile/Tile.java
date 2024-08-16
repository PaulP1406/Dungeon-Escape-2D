package tile;

import java.awt.image.BufferedImage;

/**
 * Represents a single tile in the game. Each tile has an associated image
 * indicating whether it should be considered as an obstacle (i.e., whether it
 * has collision).
 */
public class Tile {
   public BufferedImage image;
   public boolean collision = false;
}