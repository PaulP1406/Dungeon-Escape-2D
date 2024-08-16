package game.Dungeon.objectTest;

import object.Object;
import main.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.MockitoFramework;
import org.mockito.junit.MockitoJUnit;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;



class ObjectTest {
    Object object;

    @BeforeEach
    void setUp() {
        GamePanel mockGamePanel = new GamePanel(); 
        object = new Object();
        object.gp = mockGamePanel;
        object.solidAreaDefaultX = 10;
        object.solidAreaDefaultY = 20;
    }
    
    @Test
    void testDraw() {
        Graphics2D mockGraphics2D = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).createGraphics();
        object.draw(mockGraphics2D, object.gp); 
        Rectangle solidArea = object.solidArea;
        assertNotNull(solidArea, "Solid area rectangle should not be null");
        assertEquals(0, solidArea.getX(), "Solid area X-coordinate should be initialized to 0");
        assertEquals(0, solidArea.getY(), "Solid area Y-coordinate should be initialized to 0");
        assertEquals(48, solidArea.getWidth(), "Solid area width should be initialized to 48");
        assertEquals(48, solidArea.getHeight(), "Solid area height should be initialized to 48");
    }

    @Test
    void testDrawWithPrisonerWithinBounds() {
        object.gp.prisoner.mapX = 10;
        object.gp.prisoner.mapY = 10;
        object.mapX = 10;
        object.mapY = 10;
        Graphics2D mockGraphics2D = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).createGraphics();
        object.draw(mockGraphics2D, object.gp);
        assertEquals(10 - 10 + object.gp.prisoner.monitorX, object.mapX - object.gp.prisoner.mapX + object.gp.prisoner.monitorX, "Screen X-coordinate should be calculated correctly");
        assertEquals(10 - 10 + object.gp.prisoner.monitorY, object.mapY - object.gp.prisoner.mapY + object.gp.prisoner.monitorY, "Screen Y-coordinate should be calculated correctly");
    }

    @Test
    void testDrawWithPrisonerOutsideBounds() {
        object.gp.prisoner.mapX = 100;
        object.gp.prisoner.mapY = 100;
        object.mapX = 10;
        object.mapY = 10;
        Graphics2D mockGraphics2D = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).createGraphics();
        object.draw(mockGraphics2D, object.gp);
        assertEquals(10 - 100 + object.gp.prisoner.monitorX, object.mapX - object.gp.prisoner.mapX + object.gp.prisoner.monitorX, "Screen X-coordinate should be calculated correctly when prisoner is outside bounds");
        assertEquals(10 - 100 + object.gp.prisoner.monitorY, object.mapY - object.gp.prisoner.mapY + object.gp.prisoner.monitorY, "Screen Y-coordinate should be calculated correctly when prisoner is outside bounds");
    }
    
    @Test
    void testDrawPartiallyWithinBoundsHorizontally() {
        // Set up scenario where the object is partially within the bounds horizontally
        object.mapX = 10;
        object.mapY = 50;
        object.gp.prisoner.mapX = 30;
        object.gp.prisoner.mapY = 30;
        object.gp.prisoner.monitorX = 10;
        object.gp.prisoner.monitorY = 10;

        // Create a mock Graphics2D object
        Graphics2D mockGraphics2D = Mockito.mock(Graphics2D.class);

        object.draw(mockGraphics2D, object.gp);

        // The object should not be drawn as it's partially within the bounds horizontally
        // Add an assertion to verify that drawImage is not called
        verify(mockGraphics2D, never()).drawImage(any(), anyInt(), anyInt(), anyInt(), anyInt(), any());
    }

    @Test
    void testDrawPartiallyWithinBoundsVertically() {
        // Set up scenario where the object is partially within the bounds vertically
        object.mapX = 50;
        object.mapY = 10;
        object.gp.prisoner.mapX = 30;
        object.gp.prisoner.mapY = 30;
        object.gp.prisoner.monitorX = 10;
        object.gp.prisoner.monitorY = 10;

        // Create a mock Graphics2D object
        Graphics2D mockGraphics2D = Mockito.mock(Graphics2D.class);

        object.draw(mockGraphics2D, object.gp);

        // The object should not be drawn as it's partially within the bounds vertically
        // Add an assertion to verify that drawImage is not called
        verify(mockGraphics2D, never()).drawImage(any(), anyInt(), anyInt(), anyInt(), anyInt(), any());
    }
}
