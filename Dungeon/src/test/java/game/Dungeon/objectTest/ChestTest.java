package game.Dungeon.objectTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.GamePanel;
import object.Chest;

class ChestTest {

    @Mock
    GamePanel mockGamePanel;

    Chest chest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        chest = new Chest(mockGamePanel);
    }

    @Test
    void testChestInitialization() {
        assertNotNull(chest.getImage(), "Chest image should be initialized");
        assertEquals("Chest", chest.getName(), "Chest name should be initialized");
    }

    @Test
    void testChestInitializationWithNullGamePanel() {
        assertThrows(NullPointerException.class, () -> new Chest(null), 
                    "Creating Chest with null GamePanel should throw NullPointerException");
    }


    @Test
    void testChestImageNotNull() {
        BufferedImage image = chest.getImage();
        assertNotNull(image, "Chest image should not be null");
    }

    @Test
    void testChestImageDimensions() {
        BufferedImage image = chest.getImage();
        assertEquals(48, image.getWidth(), "Chest image width should be 48 pixels");
        assertEquals(48, image.getHeight(), "Chest image height should be 48 pixels");
    }

}
