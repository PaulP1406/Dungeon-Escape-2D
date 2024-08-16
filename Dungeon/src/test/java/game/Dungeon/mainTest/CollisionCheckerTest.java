package game.Dungeon.mainTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import character.Prisoner;
import main.CollisionChecker;
import main.GamePanel;
import main.KeyChecker;
import object.Object;
import character.Character;

class CollisionCheckerTest {

    GamePanel mockGamePanel;
    CollisionChecker collisionChecker;
    Prisoner prisoner;
    Object[] mockObjects;

    @BeforeEach
    void setUp() {
        mockGamePanel = new GamePanel();
        collisionChecker = new CollisionChecker(mockGamePanel);
        prisoner = new Prisoner(mockGamePanel, new KeyChecker(mockGamePanel));
        mockObjects = new Object[10]; // Assume 10 objects for simplicity

        // Initialize objects with collision property and position
        for (int i = 0; i < mockObjects.length; i++) {
            mockObjects[i] = new Object();
            mockObjects[i].solidArea.x = 100 + i * 50;
            mockObjects[i].solidArea.y = 100 + i * 50;
            mockObjects[i].solidArea.width = 48;
            mockObjects[i].solidArea.height = 48;
            mockObjects[i].collision = true; // All objects have collision
        }
        mockGamePanel.obj = mockObjects; // Set the mock objects in the GamePanel          
    }

    @Test
    void checkObject_shouldDetectCollisionWithPrisoner() {
        // Set prisoner's position and rectangle area for collision detection
        prisoner.mapX = 100;
        prisoner.mapY = 150;
        prisoner.recArea.x = 0;
        prisoner.recArea.y = -10;
        prisoner.recArea.width = 48;
        prisoner.recArea.height = 48;
        prisoner.speed = 4;
        prisoner.direction = "up";
        
        int index = collisionChecker.checkObject(prisoner, true);
        
        assertEquals(1, index, "Prisoner should collide with the second object");
    }

    @Test
    void checkObject_shouldNotDetectCollisionWhenFarAway() {
        // Set prisoner's position far from objects
        prisoner.mapX = 0;
        prisoner.mapY = 0;
        prisoner.recArea.x = 0;
        prisoner.recArea.y = 0;
        prisoner.recArea.width = 48;
        prisoner.recArea.height = 48;
        prisoner.speed = 4;
        prisoner.direction = "up";
        
        int index = collisionChecker.checkObject(prisoner, true);
        
        assertEquals(999, index, "Prisoner should not collide with any object");
    }
    
    @Test
    void checkObject_shouldDetectCollisionWhenMovingDown() {
        prisoner.mapX = 100;
        prisoner.mapY = 50; // Position the prisoner above the object
        prisoner.recArea.x = 0;
        prisoner.recArea.y = 0;
        prisoner.recArea.width = 48;
        prisoner.recArea.height = 48;
        prisoner.speed = 4;
        prisoner.direction = "down";
        
        // Adjust the object's position to be right below the prisoner
        mockObjects[0].solidArea.y = 100; 

        int index = collisionChecker.checkObject(prisoner, true);
        
        assertEquals(0, index, "Prisoner should collide with the first object when moving down");
    }

    @Test
    void checkObject_shouldDetectCollisionWhenMovingLeft() {
        prisoner.mapX = 150; // Position the prisoner to the right of the object
        prisoner.mapY = 100;
        prisoner.recArea.x = 0;
        prisoner.recArea.y = 0;
        prisoner.recArea.width = 48;
        prisoner.recArea.height = 48;
        prisoner.speed = 4;
        prisoner.direction = "left";
        
        // Adjust the object's position to be left of the prisoner
        mockObjects[0].solidArea.x = 50; 

        int index = collisionChecker.checkObject(prisoner, true);
        
        assertEquals(1, index, "Prisoner should collide with the first object when moving left");
    }

    @Test
    void checkObject_shouldDetectCollisionWhenMovingRight() {
        prisoner.mapX = 50; // Position the prisoner to the left of the object
        prisoner.mapY = 100;
        prisoner.recArea.x = 0;
        prisoner.recArea.y = 0;
        prisoner.recArea.width = 48;
        prisoner.recArea.height = 48;
        prisoner.speed = 4;
        prisoner.direction = "right";
        
        // Adjust the object's position to be right of the prisoner
        mockObjects[0].solidArea.x = 100; 

        int index = collisionChecker.checkObject(prisoner, true);
        
        assertEquals(0, index, "Prisoner should collide with the first object when moving right");
    }
    
    @Test
    void checkEntity_shouldDetectCollisionWhenMovingUp() {
        Character character = new Character(mockGamePanel);
        Character target1 = new Character(mockGamePanel);
        
        target1.recArea = new Rectangle(0, 0, 48, 48);
        target1.recAreaDefaultX = target1.recArea.x;
        target1.recAreaDefaultY = target1.recArea.y;
        
        character.recArea = new Rectangle(0, 0, 48, 48);
        character.recAreaDefaultX = character.recArea.x;
        character.recAreaDefaultY = character.recArea.y;
        
        // Setup character and target positions and collision areas
        character.mapX = 100;
        character.mapY = 200;
        character.recArea.x = 0;
        character.recArea.y = 0;
        character.recArea.width = 48;
        character.recArea.height = 48;
        character.speed = 4;
        character.direction = "up";
        
        target1.mapX = 100;
        target1.mapY = 150; // Directly above character
        target1.recArea.x = 0;
        target1.recArea.y = 0;
        target1.recArea.width = 48;
        target1.recArea.height = 48;
        
        Character[] targets = new Character[]{target1};

        int index = collisionChecker.checkEntity(character, targets);
        
        assertEquals(0, index, "Character should collide with target when moving up");
    }
    
    @Test
    void checkEntity_shouldDetectCollisionWhenMovingDown() {
        Character character = new Character(mockGamePanel);
        Character target1 = new Character(mockGamePanel);

        // Initialize rectangles
        target1.recArea = new Rectangle(0, 0, 48, 48);
        target1.recAreaDefaultX = target1.recArea.x;
        target1.recAreaDefaultY = target1.recArea.y;
        
        character.recArea = new Rectangle(0, 0, 48, 48);
        character.recAreaDefaultX = character.recArea.x;
        character.recAreaDefaultY = character.recArea.y;
        // Setup character and target positions for moving down
        character.mapX = 100;
        character.mapY = 100; // Character starting position
        character.speed = 4;
        character.direction = "down";
        
        target1.mapX = 100;
        target1.mapY = 150; // Directly below character
        
        Character[] targets = new Character[]{target1};

        int index = collisionChecker.checkEntity(character, targets);
        
        assertEquals(0, index, "Character should collide with target when moving down");
    }
    
    @Test
    void checkEntity_shouldDetectCollisionWhenMovingLeft() {
        Character character = new Character(mockGamePanel);
        Character target1 = new Character(mockGamePanel);

        // Initialize rectangles
        target1.recArea = new Rectangle(0, 0, 48, 48);
        target1.recAreaDefaultX = target1.recArea.x;
        target1.recAreaDefaultY = target1.recArea.y;
        
        character.recArea = new Rectangle(0, 0, 48, 48);
        character.recAreaDefaultX = character.recArea.x;
        character.recAreaDefaultY = character.recArea.y;
        // Setup character and target positions for moving left
        character.mapX = 150;
        character.mapY = 100;
        character.speed = 4;
        character.direction = "left";
        
        target1.mapX = 100; // Directly to the left of character
        target1.mapY = 100;
        
        Character[] targets = new Character[]{target1};

        int index = collisionChecker.checkEntity(character, targets);
        
        assertEquals(0, index, "Character should collide with target when moving left");
    }
    
    @Test
    void checkEntity_shouldDetectCollisionWhenMovingRight() {
        Character character = new Character(mockGamePanel);
        Character target1 = new Character(mockGamePanel);

        // Initialize rectangles
        target1.recArea = new Rectangle(0, 0, 48, 48);
        target1.recAreaDefaultX = target1.recArea.x;
        target1.recAreaDefaultY = target1.recArea.y;
        
        character.recArea = new Rectangle(0, 0, 48, 48);
        character.recAreaDefaultX = character.recArea.x;
        character.recAreaDefaultY = character.recArea.y;

        // Setup character and target positions for moving right
        character.mapX = 100;
        character.mapY = 100;
        character.speed = 4;
        character.direction = "right";
        
        target1.mapX = 150; // Directly to the right of character
        target1.mapY = 100;
        
        Character[] targets = new Character[]{target1};

        int index = collisionChecker.checkEntity(character, targets);
        
        assertEquals(0, index, "Character should collide with target when moving right");
    }
    
    @Test
    void checkEntity_shouldNotDetectCollisionWhenNoOverlap() {
        Character character = new Character(mockGamePanel);
        Character target1 = new Character(mockGamePanel);

        // Initialize rectangles
        target1.recArea = new Rectangle(0, 0, 48, 48);
        target1.recAreaDefaultX = target1.recArea.x;
        target1.recAreaDefaultY = target1.recArea.y;
        
        character.recArea = new Rectangle(0, 0, 48, 48);
        character.recAreaDefaultX = character.recArea.x;
        character.recAreaDefaultY = character.recArea.y;

        // Setup character and target positions where they do not overlap
        character.mapX = 100;
        character.mapY = 100;
        character.speed = 4;
        character.direction = "down";
        
        target1.mapX = 300; // Far away from character, no overlap
        target1.mapY = 300;
        
        Character[] targets = new Character[]{target1};

        int index = collisionChecker.checkEntity(character, targets);
        
        assertEquals(999, index, "Character should not collide with any target");
    }
    
    @Test
    void checkPrisoner_CollisionFromUp() {
        // Initialize character and prisoner
        Character enemy = new Character(mockGamePanel);
        enemy.recArea = new Rectangle(0, 0, 48, 48); // Assuming these dimensions
        mockGamePanel.prisoner.recArea = new Rectangle(0, 0, 48, 48); // Same as above

        // Set positions for collision: enemy above prisoner moving down
        enemy.mapX = mockGamePanel.prisoner.mapX;
        enemy.mapY = mockGamePanel.prisoner.mapY - 48; // Directly above
        enemy.direction = "down";
        enemy.speed = 4;

        boolean result = collisionChecker.checkPrisoner(enemy);
        
        assertTrue(result, "Enemy should collide with prisoner from above");
    } 
    
    @Test
    void checkPrisoner_CollisionFromDown() {
        Character enemy = new Character(mockGamePanel);
        enemy.recArea = new Rectangle(0, 0, 48, 48);
        mockGamePanel.prisoner.recArea = new Rectangle(0, 0, 48, 48);

        // Enemy below prisoner, moving up
        enemy.mapX = mockGamePanel.prisoner.mapX;
        enemy.mapY = mockGamePanel.prisoner.mapY + 48; // Directly below
        enemy.direction = "up";
        enemy.speed = 4;

        boolean result = collisionChecker.checkPrisoner(enemy);
        
        assertTrue(result, "Enemy should collide with prisoner from below");
    }
    
    @Test
    void checkPrisoner_CollisionFromLeft() {
        Character enemy = new Character(mockGamePanel);
        enemy.recArea = new Rectangle(0, 0, 48, 48);
        mockGamePanel.prisoner.recArea = new Rectangle(0, 0, 48, 48);

        // Enemy to the left of prisoner, moving right
        enemy.mapX = mockGamePanel.prisoner.mapX - 48; // To the left
        enemy.mapY = mockGamePanel.prisoner.mapY;
        enemy.direction = "right";
        enemy.speed = 4;

        boolean result = collisionChecker.checkPrisoner(enemy);
        
        assertTrue(result, "Enemy should collide with prisoner from the left");
    }
    
    @Test
    void checkPrisoner_CollisionFromRight() {
        Character enemy = new Character(mockGamePanel);
        enemy.recArea = new Rectangle(0, 0, 48, 48);
        mockGamePanel.prisoner.recArea = new Rectangle(0, 0, 48, 48);

        // Enemy to the right of prisoner, moving left
        enemy.mapX = mockGamePanel.prisoner.mapX + 48; // To the right
        enemy.mapY = mockGamePanel.prisoner.mapY;
        enemy.direction = "left";
        enemy.speed = 4;

        boolean result = collisionChecker.checkPrisoner(enemy);
        
        assertTrue(result, "Enemy should collide with prisoner from the right");
    }

    @Test
    void checkPrisoner_NoCollision() {
        // Initialize character and prisoner
        Character enemy = new Character(mockGamePanel);
        enemy.recArea = new Rectangle(0, 0, 48, 48); // Assuming these dimensions
        mockGamePanel.prisoner.recArea = new Rectangle(0, 0, 48, 48); // Same as above

        // Set positions to ensure no collision
        enemy.mapX = mockGamePanel.prisoner.mapX + 100; // Far to the right
        enemy.mapY = mockGamePanel.prisoner.mapY;
        enemy.direction = "left";
        enemy.speed = 4;

        boolean result = collisionChecker.checkPrisoner(enemy);
        
        assertFalse(result, "Enemy should not collide with prisoner when too far away");
    }
    


    
   
}
