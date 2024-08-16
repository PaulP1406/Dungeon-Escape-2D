package game.Dungeon.mainTest;

import main.KeyChecker;
import main.UI;
import main.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

class KeyCheckerTest {

    GamePanel mockGamePanel;
    KeyChecker keyChecker;

    @BeforeEach
    void setUp() {
        mockGamePanel = mock(GamePanel.class);
        keyChecker = new KeyChecker(mockGamePanel);
    }

    @Test
    void testKeyPressUp() {
        KeyEvent upEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyChecker.keyPressed(upEvent);
        assert(keyChecker.upPressed);
    }
    
    @Test
    void testKeyPressDown() {
        KeyEvent downEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        keyChecker.keyPressed(downEvent);
        assert(keyChecker.downPressed);
    }

    @Test
    void testKeyPressLeft() {
        KeyEvent leftEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        keyChecker.keyPressed(leftEvent);
        assert(keyChecker.leftPressed);
    }

    @Test
    void testKeyPressRight() {
        KeyEvent rightEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyChecker.keyPressed(rightEvent);
        assert(keyChecker.rightPressed);
    }

    @Test
    void testKeyReleaseUp() {
        // Simulate pressing and releasing the up key
        keyChecker.upPressed = true; // Simulate pressing
        KeyEvent upEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        keyChecker.keyReleased(upEvent);
        assert(!keyChecker.upPressed);
    }
    
    @Test
    void testKeyReleaseDown() {
        keyChecker.downPressed = true; // Simulate pressing down
        KeyEvent downEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        keyChecker.keyReleased(downEvent);
        assert(!keyChecker.downPressed);
    }

    @Test
    void testKeyReleaseLeft() {
        keyChecker.leftPressed = true; // Simulate pressing left
        KeyEvent leftEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        keyChecker.keyReleased(leftEvent);
        assert(!keyChecker.leftPressed);
    }

    @Test
    void testKeyReleaseRight() {
        keyChecker.rightPressed = true; // Simulate pressing right
        KeyEvent rightEvent = new KeyEvent(mockGamePanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        keyChecker.keyReleased(rightEvent);
        assert(!keyChecker.rightPressed);
    }    
     
    @Test
    void testKeyTypedDoesNothing() {
        KeyChecker keyChecker = new KeyChecker(new GamePanel());
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'a');
        
        // Invoke keyTyped method. Since it does nothing, there's no direct outcome to assert.
        keyChecker.keyTyped(keyEvent);

        // You can only assert that the method completes without throwing an exception.
        assertTrue(true, "keyTyped should complete without exception.");
    }
    
    @Test
    void testPausePlayToggle() {
        GamePanel mockGamePanel = mock(GamePanel.class);
        mockGamePanel.gameState = 1;

        KeyChecker keyChecker = new KeyChecker(mockGamePanel);
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_P, 'P');
        keyChecker.keyPressed(keyEvent);

        assertEquals(2, mockGamePanel.gameState);

        // Simulate pressing 'P' again to resume play
        keyChecker.keyPressed(keyEvent);

        assertEquals(1, mockGamePanel.gameState);
    }
    
    @Test
    void testGameOverState() {
        GamePanel mockGamePanel = mock(GamePanel.class);
        UI mockUI = mock(UI.class);
        
        // Assuming 'gameState' and 'ui' can be directly accessed; adjust if getters/setters are used
        mockGamePanel.gameState = 3; // Or use GamePanel.GAME_OVER if you have constants defined
        mockGamePanel.ui = mockUI;
                    
        KeyChecker keyChecker = new KeyChecker(mockGamePanel);
        KeyEvent keyEventEnter = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
        
        keyChecker.keyPressed(keyEventEnter);
   
        assertEquals(1, mockGamePanel.gameState);
    }


}
