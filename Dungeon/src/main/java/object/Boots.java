package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;
/**
 * Extends the object class to represents Boot objects in game
 * and initializes the boots image.
 */
public class Boots extends Object { 
  /**
     * Constructs a Boots object with the specified GamePanel
     * and reads the corresponding png file.
     * 
     * @param gp The game panel associated with the Boots object.
     */		
  public Boots(GamePanel gp) {
	this.gp=gp;
    try {
      this.image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
	  this.name="SpeedBoots";
    }
    catch (IOException e) {
       e.printStackTrace();
    } 
   }
 }

