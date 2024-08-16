package game.Dungeon.mainTest;

import main.UtilityTool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class UtilityToolTest {
    
    UtilityTool utilityTool;

    @BeforeEach
    void setUp() {
        utilityTool = new UtilityTool();
    }


    @Test
    void testScaleImage() {
        // Create a test image
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        // Fill the test image with a color
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                originalImage.setRGB(x, y, 0xFF000000); // Black color
            }
        }

        // Scale the test image to half its size
        UtilityTool utilityTool = new UtilityTool();
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 50, 50);

        // Verify that the scaled image has the expected dimensions
        assertEquals(50, scaledImage.getWidth(), "Width of scaled image should be 50");
        assertEquals(50, scaledImage.getHeight(), "Height of scaled image should be 50");

        // Verify that the scaled image is not null
        assertNotNull(scaledImage, "Scaled image should not be null");

        // Verify that the scaled image is not the same reference as the original image
        assertNotSame(originalImage, scaledImage, "Scaled image should be a different reference than the original image");
    }

    @Test
    void testScaleImageWithDifferentSizes() {
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 50, 50);
        assertEquals(50, scaledImage.getWidth(), "Width of scaled image should be 50");
        assertEquals(50, scaledImage.getHeight(), "Height of scaled image should be 50");
    }
    
    @Test
    void testScaleImageWithNegativeSizes() {
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, -50, -50);
        assertNull(scaledImage, "Scaled image should be null when input sizes are negative");
    }

    
    @Test
    void testScaleImageWithNullInput() {
        BufferedImage scaledImage = utilityTool.scaleImage(null, 50, 50);
        assertNull(scaledImage, "Scaled image should be null when input image is null");
    }

    @Test
    void testScaleImageWithZeroSize() {
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 0, 0);
        assertNull(scaledImage, "Scaled image should be null when input sizes are zero");
    }

    @Test
    void testScaleImageWithLargeSize() {
        BufferedImage originalImage = new BufferedImage(10000, 10000, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 1000, 1000);
        assertNotNull(scaledImage, "Scaled image should not be null for large sizes");
        assertEquals(1000, scaledImage.getWidth(), "Width of scaled image should be 1000");
        assertEquals(1000, scaledImage.getHeight(), "Height of scaled image should be 1000");
    }

    @Test
    void testScaleImagePerformance() {
        // Measure the time taken by the scaleImage method for large input images
        long startTime = System.currentTimeMillis();
        BufferedImage originalImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 500, 500);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        assertTrue(elapsedTime < 100, "Scaling operation should complete in less than 100 milliseconds");
    }

    @Test
    void testScaleImageWithZeroWidth() {
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 0, 50);
        assertNull(scaledImage, "Scaled image should be null when width is zero");
    }

    @Test
    void testScaleImageWithZeroHeight() {
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 50, 0);
        assertNull(scaledImage, "Scaled image should be null when height is zero");
    }
    @Test
    void testScaleImageWithZeroWidthAndHeight() {
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, 0, 0);
        assertNull(scaledImage, "Scaled image should be null when width and height are zero");
    }
}
