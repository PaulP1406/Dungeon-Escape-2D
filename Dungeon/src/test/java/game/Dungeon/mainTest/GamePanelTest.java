
package game.Dungeon.mainTest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.UI;
import object.Object;
import tile.Tile;
import tile.TileManager;

import org.mockito.Mock;

import character.Enemy;
import character.Prisoner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class GamePanelTest {

    
    @Test
    public void testSetupGame() {
    	GamePanel testgamePanel = new GamePanel();
    	testgamePanel.setupGame();
        assertEquals(testgamePanel.playState, testgamePanel.gameState);
        assertNotNull(testgamePanel.prisoner);
        assertNotNull(testgamePanel.tileM);
        assertNotNull(testgamePanel.ui);
        assertNotNull(testgamePanel.cChecker);
        assertNotNull(testgamePanel.aSetter);
        assertNotNull(testgamePanel.pFinder);

        // Test object generation
        assertEquals(48 * 26, testgamePanel.obj[0].mapX);
        assertEquals(48 * 28, testgamePanel.obj[0].mapY);

        assertEquals(48* 27, testgamePanel.obj[1].mapX);
        assertEquals(48 * 28, testgamePanel.obj[1].mapY);

        assertEquals(48 * 23, testgamePanel.obj[2].mapX);
        assertEquals(48 * 23, testgamePanel.obj[2].mapY);

        assertEquals(48 * 30, testgamePanel.obj[3].mapX);
        assertEquals(48 * 23, testgamePanel.obj[3].mapY);

        assertEquals(48 * 9, testgamePanel.obj[4].mapX);
        assertEquals(48 * 38, testgamePanel.obj[4].mapY);

        assertEquals(48 * 44, testgamePanel.obj[5].mapX);
        assertEquals(48 * 38, testgamePanel.obj[5].mapY);

        assertEquals(48* 8, testgamePanel.obj[6].mapX);
        assertEquals(48 * 14, testgamePanel.obj[6].mapY);

        assertEquals(48 * 45, testgamePanel.obj[7].mapX);
        assertEquals(48 * 14, testgamePanel.obj[7].mapY);

        assertEquals(48 * 12, testgamePanel.obj[8].mapX);
        assertEquals(48 * 29, testgamePanel.obj[8].mapY);

        assertEquals(48 * 41, testgamePanel.obj[9].mapX);
        assertEquals(48 * 29, testgamePanel.obj[9].mapY);

        assertEquals(48 * 13, testgamePanel.obj[10].mapX);
        assertEquals(48 * 1, testgamePanel.obj[10].mapY);

        assertEquals(48 * 40, testgamePanel.obj[11].mapX);
        assertEquals(48 * 1, testgamePanel.obj[11].mapY);
    }
    
    @Test
    public void testRetryGame() {
    	GamePanel testgamePanel = new GamePanel();
    	testgamePanel.retry();
        assertEquals(0, testgamePanel.ui.playTime, 0.0001);
        assertNotNull(testgamePanel.prisoner);
        assertNotNull(testgamePanel.tileM);
        assertNotNull(testgamePanel.ui);
        assertNotNull(testgamePanel.cChecker);
        assertNotNull(testgamePanel.aSetter);
        assertNotNull(testgamePanel.pFinder);
        //Test if prisoner values are set to default
        assertEquals(48 * 26, testgamePanel.prisoner.mapX);
        assertEquals(48 * 40, testgamePanel.prisoner.mapY);
        assertEquals(0, testgamePanel.prisoner.score);
        assertEquals(0, testgamePanel.prisoner.skullCount);
        assertEquals(0, testgamePanel.prisoner.chestCount);
        assertEquals(4, testgamePanel.prisoner.speed);
        assertEquals("down", testgamePanel.prisoner.direction);
        assertEquals(10, testgamePanel.prisoner.maxHP);
        assertEquals(8, testgamePanel.prisoner.hp);
        assertFalse(testgamePanel.prisoner.invincible);

        //Test object generation
        assertEquals(48 * 26, testgamePanel.obj[0].mapX);
        assertEquals(48 * 28, testgamePanel.obj[0].mapY);

        assertEquals(48* 27, testgamePanel.obj[1].mapX);
        assertEquals(48 * 28, testgamePanel.obj[1].mapY);

        assertEquals(48 * 23, testgamePanel.obj[2].mapX);
        assertEquals(48 * 23, testgamePanel.obj[2].mapY);

        assertEquals(48 * 30, testgamePanel.obj[3].mapX);
        assertEquals(48 * 23, testgamePanel.obj[3].mapY);

        assertEquals(48 * 9, testgamePanel.obj[4].mapX);
        assertEquals(48 * 38, testgamePanel.obj[4].mapY);

        assertEquals(48 * 44, testgamePanel.obj[5].mapX);
        assertEquals(48 * 38, testgamePanel.obj[5].mapY);

        assertEquals(48* 8, testgamePanel.obj[6].mapX);
        assertEquals(48 * 14, testgamePanel.obj[6].mapY);

        assertEquals(48 * 45, testgamePanel.obj[7].mapX);
        assertEquals(48 * 14, testgamePanel.obj[7].mapY);

        assertEquals(48 * 12, testgamePanel.obj[8].mapX);
        assertEquals(48 * 29, testgamePanel.obj[8].mapY);

        assertEquals(48 * 41, testgamePanel.obj[9].mapX);
        assertEquals(48 * 29, testgamePanel.obj[9].mapY);

        assertEquals(48 * 13, testgamePanel.obj[10].mapX);
        assertEquals(48 * 1, testgamePanel.obj[10].mapY);

        assertEquals(48 * 40, testgamePanel.obj[11].mapX);
        assertEquals(48 * 1, testgamePanel.obj[11].mapY);
    }
    
    public void testRun() throws InterruptedException {
    	 // Mock objects for testing
    	GamePanel testgamePanel = new GamePanel();
    	testgamePanel = mock(GamePanel.class);
    	testgamePanel.setFPS(60);
        
    	testgamePanel.setGameThread(new Thread()); 
        // Call method
    	Thread runThread = new Thread(testgamePanel);
        runThread.start();

        // Wait for a short duration to allow the run method to execute
        Thread.sleep(3000);
       
        // Interrupt the runThread to stop the loop
        testgamePanel.setGameThread(null);
        runThread.join();
         
        //assertNotNull(instanceUnderTest.obj[12]);
        // Verify that certain method calls are made, influenced by these variables


     // Perform some actions or method calls that may result in calling the update() method


        verify(testgamePanel).update();
        //verify(gamePanelMock, atLeastOnce()).repaint();
    }
    @Test
    public void teststartGameThread() {
    	GamePanel testgamePanel = new GamePanel();
    	testgamePanel.startGameThread();
    	assertNotNull(testgamePanel.getGameThread());
    	assertTrue(testgamePanel.getGameThread().isAlive());
    }
    
    @Test
    public void testupdatePlay() {
    	Prisoner mockPrisoner = mock(Prisoner.class);
        Enemy[] enemies = new Enemy[3]; // assuming a length of 3 for testing
        Enemy mockEnemy1 = mock(Enemy.class);
        Enemy mockEnemy2 = mock(Enemy.class);
        Enemy mockEnemy3 = mock(Enemy.class);
        GamePanel testgamePanel = new GamePanel();
        enemies[0] = mockEnemy1;
        enemies[1] = mockEnemy2;
        enemies[2] = mockEnemy3;
        testgamePanel.prisoner = mockPrisoner;
        testgamePanel.enemy = enemies;

        // Set gameState to playState
        testgamePanel.gameState = 1;
        // Call method
        testgamePanel.update();

        // Verify method calls
        verify(mockPrisoner, times(1)).update();

        // Loop through mockEnemy array and verify update method calls on non-null elements
        for (int i = 0; i < 3; i++) {
            if (enemies[i] != null) {
                verify(enemies[i], times(1)).update();
            }
            else {
            	verify(enemies[i], never()).update();
            }
        }
    }
    @Test
    public void testUpdatePause() {
    	Prisoner mockPrisoner = mock(Prisoner.class);
        Enemy[] enemies = new Enemy[3]; // assuming a length of 3 for testing
        Enemy mockEnemy1 = mock(Enemy.class);
        Enemy mockEnemy2 = mock(Enemy.class);
        Enemy mockEnemy3 = mock(Enemy.class);
        GamePanel testgamePanel = new GamePanel();
        enemies[0] = mockEnemy1;
        enemies[1] = mockEnemy2;
        enemies[2] = mockEnemy3;
        testgamePanel.prisoner = mockPrisoner;
        testgamePanel.enemy = enemies;

        // Set gameState to playState
        testgamePanel.gameState = 2;
        // Call method
        testgamePanel.update();


        // Verify that no update methods are called
        verify(mockPrisoner, never()).update();
        for (int i = 0; i < 3; i++) {
            if (enemies[i] != null) {
            	verify(enemies[i], never()).update();
            }
            else {
            	verify(enemies[i], never()).update();
            }
        }
        
    }
    @Test
    public void testpaintComponent() {
    	 // Mock objects for testing
    	 BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    	 Graphics gd = img.createGraphics();
         TileManager mockTileM = mock(TileManager.class);
         Object[] mockObj = new Object[20]; // assuming a length of 5 for testing
         Enemy[] mockEnemy = new Enemy[3]; // assuming a length of 3 for testing
         Prisoner mockPrisoner = mock(Prisoner.class);
         UI mockUI = mock(UI.class);
         
         GamePanel testgamePanel = new GamePanel();
         testgamePanel.tileM = mockTileM;
         testgamePanel.obj = mockObj;
         testgamePanel.enemy = mockEnemy;
         testgamePanel.prisoner = mockPrisoner;
         testgamePanel.ui = mockUI;
         // Call method
         testgamePanel.paintComponent(gd);
         // Verify method calls
         
         verify(mockTileM).create(any((Graphics2D.class)));
         verify(mockPrisoner).draw(any((Graphics2D.class)));
         verify(mockUI).draw(any((Graphics2D.class)));
         // Loop through mockObj array and verify draw method calls on non-null elements
         
         for (int i = 0; i < 20; i++) {
             if (mockObj[i] != null) {
            	 verify(mockObj[i]).draw(any((Graphics2D.class)),testgamePanel);
             }
         }
         
         for (int i = 0; i < 3; i++) {
             if (mockEnemy[i] != null) {
            	 verify(mockEnemy[i]).draw(any((Graphics2D.class)));
             }
         }
 		
    }
	
}