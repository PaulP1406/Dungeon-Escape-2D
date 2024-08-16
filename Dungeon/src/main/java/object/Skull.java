package object;
 
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
 /**
 * Extends the object class to represent skull objects in game
 * and initializes the Skull image.
 */
 public class Skull extends Object { 
    /**
     * Constructs a Skull object with the specified GamePanel
     * and reads the corresponding png file and scales it. 
     * 
     * @param gp The game panel associated with the Skull object.
     */		
   public Skull(GamePanel gp) {
	 this.gp=gp;
     try {
       this.image = ImageIO.read(getClass().getResourceAsStream("/objects/Skull.png"));
	   this.name="Skull";
	   uTool.scaleImage(image,gp.tileSize,gp.tileSize);
     }
     catch (IOException e) {
       e.printStackTrace();
     } 
   }
 }
