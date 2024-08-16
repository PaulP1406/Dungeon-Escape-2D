package game.Dungeon.tileTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import main.GamePanel;
import tile.TileManager;

import static org.mockito.Mockito.*;

import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

class TileManagerTest {

    TileManager tileManager;

    @Mock
    GamePanel gp;
    @Mock
    private Graphics2D graphics;
    private GamePanel gamePanel;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tileManager = new TileManager(gp);
        gamePanel = new GamePanel();
        MockitoAnnotations.openMocks(this);
        
        gamePanel = new GamePanel();
        tileManager = new TileManager(gamePanel);
        graphics = mock(Graphics2D.class);
        gamePanel.prisoner.mapX = 100; 
        gamePanel.prisoner.mapY = 100;
        
        tileManager.loadMap("/maps/world01.txt");
    }

    @Test
    void testTileArrayInitialization() {
    	tileManager.loadMap("/maps/world01.txt");
        assertEquals(10, tileManager.tile.length, "Tile array should have a length of 10");
    }
    
    @Test
    void testGetTileImageSetup() {
        tileManager.getTileImage(); 

        assertNotNull(tileManager.tile[0].image, "Image for wall should be loaded");
        assertTrue(tileManager.tile[0].collision, "wall should have collision enabled");

        assertNotNull(tileManager.tile[1].image, "Image for stone should be loaded");
        assertFalse(tileManager.tile[1].collision, "stone should not have collision enabled");
        
        assertNotNull(tileManager.tile[2].image, "Image for water should be loaded");
        assertFalse(tileManager.tile[2].collision, "water should not have collision enabled");
        
        assertNotNull(tileManager.tile[3].image, "Image for lava should be loaded");
        assertFalse(tileManager.tile[3].collision, "lava should not have collision enabled");
        
        assertNotNull(tileManager.tile[4].image, "Image for gold should be loaded");
        assertFalse(tileManager.tile[4].collision, "Gold should not have collision enabled");
       
    }
    
    @Test
    void testLoadMapWithInputStream() {
     
        //tileManager.loadMap("/maps/world01.txt"); 
        
        //Testing random inputs to make sure the imported data matches the map data
        assertEquals(0, tileManager.mapTileNum[0][0], "Top left corner should be 0.");
        assertEquals(0, tileManager.mapTileNum[0][0]);
        assertEquals(0, tileManager.mapTileNum[53][42]);
        assertEquals(1, tileManager.mapTileNum[1][1]);
        assertEquals(1, tileManager.mapTileNum[7][1]);
        assertEquals(0, tileManager.mapTileNum[0][0]);
        assertEquals(0, tileManager.mapTileNum[53][0]);
        assertEquals(1, tileManager.mapTileNum[1][1]);
        assertEquals(1, tileManager.mapTileNum[7][1]);
        assertEquals(0, tileManager.mapTileNum[18][1]);
        assertEquals(1, tileManager.mapTileNum[20][1]);
        assertEquals(4, tileManager.mapTileNum[25][1]);
        assertEquals(1, tileManager.mapTileNum[28][1]);
        assertEquals(0, tileManager.mapTileNum[34][1]);
        assertEquals(1, tileManager.mapTileNum[36][1]);
        assertEquals(1, tileManager.mapTileNum[1][2]);
        assertEquals(0, tileManager.mapTileNum[12][2]);
        assertEquals(1, tileManager.mapTileNum[20][2]);
        
    }   
    
    @Test
    void testTilesWithinViewportAreRendered() {
        gamePanel.prisoner.mapX = 100; // Adjust as necessary
        gamePanel.prisoner.mapY = 100;
        // Manually set the tileNum for specific tiles you know should be rendered based on the prisoner's position
        tileManager.mapTileNum[2][2] = 1; // Assuming this tile is within the viewport and has a tileNum of 1

        tileManager.create(graphics);

        verify(graphics, atLeastOnce()).drawImage(any(), anyInt(), anyInt(), any());
        
    }    
    /*
    @Test
    void testIllegalArgumentExceptionHandling() {
    	try {
    	tileManager.setup(20, "Not exist", false);
    	} catch(Exception e) {
    	   assertTrue(true);
       }
    }
*/
 
   
}
