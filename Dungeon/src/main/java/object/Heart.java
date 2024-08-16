package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

/**
 * Extends the object class to represent heart objects in game
 * and initializes heart images based on player status.
 */
public class Heart extends Object{	 
	/** Game panel associated with the heart object. */
	GamePanel gp;
	 /**
     * Constructs a Heart object with the specified GamePanel,
	 * reads corresponding png files and scales them.
     * 
     * @param gp The game panel associated with the heart object.
     */
	public Heart(GamePanel gp) {
	    this.gp = gp;
	    name = "Heart";
	    loadAndScaleImages();
	}

	private void loadAndScaleImages() {
	    UtilityTool uTool = new UtilityTool();
	    try {
	        image = loadImage("/objects/heart_full.png", uTool);
	        image2 = loadImage("/objects/heart_half.png", uTool);
	        image3 = loadImage("/objects/heart_blank.png", uTool);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private BufferedImage loadImage(String path, UtilityTool uTool) throws IOException {
	    BufferedImage loadedImage = ImageIO.read(getClass().getResourceAsStream(path));
	    return uTool.scaleImage(loadedImage, gp.tileSize, gp.tileSize);
	}


}
