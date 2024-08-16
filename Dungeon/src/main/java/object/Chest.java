package object;
 
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;
import java.awt.image.BufferedImage;

/**
 * Extends the object class to represent chest objects in game
 * and initializes the chest image.
 */
public class Chest extends Object {  
  /**
     * Constructs a Chest object with the specified GamePanel
     * and reads the corresponding png file and scales it.
     * 
     * @param gp The game panel associated with the Chest object.
     */		 
   
   public Chest(GamePanel gp) {
        this.gp = gp;
        UtilityTool uTool = new UtilityTool(); // Create an instance of UtilityTool
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
            this.name = "Chest";
            this.image = uTool.scaleImage(image, gp.tileSize, gp.tileSize); // Scale the image
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    public BufferedImage getImage() {
      return this.image;
    }

    public String getName() {
        return this.name;
    }
 }

