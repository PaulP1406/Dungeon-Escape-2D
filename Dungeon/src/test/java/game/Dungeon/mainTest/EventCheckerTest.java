package game.Dungeon.mainTest;

import main.GamePanel;
import main.EventChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import character.Prisoner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.awt.Rectangle;

class EventCheckerTest {

    private GamePanel mockGamePanel;
    private EventChecker eventChecker;

    @BeforeEach
    void setUp() {
        mockGamePanel = new GamePanel();
        // Assuming gamePanel instantiates its prisoner and sets tileSize.
        eventChecker = new EventChecker(mockGamePanel);

        // Example setup assuming recArea and direction are directly accessible.
        // Adjust if they're managed differently in your code.
        mockGamePanel.prisoner.recArea = new Rectangle(21 * mockGamePanel.tileSize, 16 * mockGamePanel.tileSize, mockGamePanel.tileSize, mockGamePanel.tileSize);
        mockGamePanel.prisoner.direction = "right"; // Ensure the direction matches those checked in eventChecker.
        mockGamePanel.prisoner.hp = 10; // Setting an initial HP for verification.
    }

    
    @Test
    void testLavaPitEventReducesHp() {        
    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(10, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 18 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 19 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 20 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 21 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 22 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 23 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 24 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 25 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 26 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 21 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);
    	
    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 18 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 19 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 20 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 21 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 22 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 23 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 24 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 25 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 26 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 22 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 23 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 23 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);
    	
    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 24 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 24 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 29 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 29 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 30 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 30 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 16 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 17 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 23 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 23 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 24 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 24 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);
    	
    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 25 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 25 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 26 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 26 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 27 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 27 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 28 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 28 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 29 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 29 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 30 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 30 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);
    	
    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 18 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 19 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 20 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 21 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 22 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 23 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 24 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 25 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 26 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 31 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);
    	
    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize; // Position player on lava pit
    	mockGamePanel.prisoner.mapY = 18 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 19 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 20 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 21 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 22 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 23 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 24 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 25 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 26 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    	mockGamePanel.prisoner.hp = 10;
    	mockGamePanel.prisoner.mapX = 32 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();        
    	assertEquals(9, mockGamePanel.prisoner.hp, 0.0001);

    }
    
    @Test
    void testWaterPitEventIncreasesHp() {        
    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 18 * mockGamePanel.tileSize; // Position player on water pit
    	mockGamePanel.prisoner.mapY = 7 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 18 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 8 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 18 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 9 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 19 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 7 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 19 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 8 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 19 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 9 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 34 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 7 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 34 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 8 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 34 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 9 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 35 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 7 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 35 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 8 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 35 * mockGamePanel.tileSize; 
    	mockGamePanel.prisoner.mapY = 9 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");
    	
    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 7 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 7 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 7 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 7 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 7 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 31 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 8 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 8 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 8 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 8 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 8 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 31 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 45 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 45 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 45 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 45 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 45 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 31 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 46 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 27 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 46 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 28 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 46 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 29 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 46 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 30 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");

    	mockGamePanel.prisoner.hp = 3;
    	mockGamePanel.prisoner.mapX = 46 * mockGamePanel.tileSize;
    	mockGamePanel.prisoner.mapY = 31 * mockGamePanel.tileSize;
    	eventChecker.checkEvent();
    	assertEquals(4, mockGamePanel.prisoner.hp, "HP should increase by 1 when stepping on a water pit with HP <= 4.");
    	
      }
    
    @Test
    void testExitTileEventChangesGameState() {
        // Setup for exit tile
        mockGamePanel.prisoner.mapX = 25 * mockGamePanel.tileSize; // Position player on exit tile
        mockGamePanel.prisoner.mapY = 1 * mockGamePanel.tileSize;
        mockGamePanel.prisoner.chestCount = 8;  // Assuming these conditions must be met
        mockGamePanel.prisoner.skullCount = 4;

        eventChecker.checkEvent();        
        assertEquals(mockGamePanel.gameFinished, mockGamePanel.gameState, "Game state should change to finished when exiting.");
        
        mockGamePanel.prisoner.mapX = 26 * mockGamePanel.tileSize; // Position player on exit tile
        mockGamePanel.prisoner.mapY = 1 * mockGamePanel.tileSize;    

        eventChecker.checkEvent();        
        assertEquals(mockGamePanel.gameFinished, mockGamePanel.gameState, "Game state should change to finished when exiting.");
        
        mockGamePanel.prisoner.mapX = 27 * mockGamePanel.tileSize; // Position player on exit tile
        mockGamePanel.prisoner.mapY = 1 * mockGamePanel.tileSize;
        eventChecker.checkEvent();        
        assertEquals(mockGamePanel.gameFinished, mockGamePanel.gameState, "Game state should change to finished when exiting.");
    }
}


