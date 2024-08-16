package game.Dungeon.characterTest;


import main.CollisionChecker;
import main.GamePanel;
import object.*;
import main.KeyChecker;
import character.Enemy;
import character.Prisoner;
import character.Character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import enemyAi.EnemyAI;
import enemyAi.Node;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
public class CharacterTest {

@Mock
GamePanel mockgp;

GamePanel gp;


@Mock
KeyChecker kc;

Character character;

Enemy enemy;
Prisoner prisoner;


	@BeforeEach
	void setup() {
		mockgp=mock(GamePanel.class);
		gp = new GamePanel(); 
		kc = new KeyChecker(gp);
		prisoner=gp.prisoner;
		gp.enemy[0]=new Enemy(gp);
		enemy=(Enemy) gp.enemy[0];
		gp.gameState=1;
		character=new Enemy(mockgp);
		
		
		
	}
	
	@Test
	void changeDirectionLeft() {
		KeyEvent e= new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 65, 'A');
		prisoner.keyPressed.keyPressed(e);
		gp.update();
		assertTrue(prisoner.direction=="left");
		
	}
	@Test
	void changeDirectionRight() {
		KeyEvent e= new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
		prisoner.keyPressed.keyPressed(e);
		gp.update();
		assertTrue(prisoner.direction=="right");
		
	}
	@Test
	void changeDirectionDown() {
		KeyEvent e= new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 83, 'S');
		prisoner.keyPressed.keyPressed(e);
		gp.update();
		assertTrue(prisoner.direction=="down");
		
	}
	@Test
	void changeDirectionUp() {
		KeyEvent e= new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 87, 'W');
		prisoner.keyPressed.keyPressed(e);
		gp.update();
		assertTrue(prisoner.direction=="up");
		
	}
	@Test
	void gameOverCondition() {
		prisoner.hp=0;
		gp.update();
		assertEquals(gp.gameState,gp.gameOver);
	}
	@Test
	void runIntoEnemy() {
		prisoner.interactEnemy(1);
		assertEquals(prisoner.hp,0);
		assertTrue(prisoner.invincible);
	}
	@Test
	void pickUpBoots() {
		gp.obj[0]=new Boots(gp);
		int score=prisoner.score;
		prisoner.pickUpObject(0);
		assertEquals(prisoner.speed,5);
		assertEquals(score+500,prisoner.score);
		
	}
	@Test
	void pickUpHeart() {
		gp.obj[0]=new Heart(gp);
		int score=prisoner.score;
		prisoner.pickUpObject(0);
		assertEquals(prisoner.hp,10);
		assertEquals(score+1000,prisoner.score);
		
	}
	@Test
	void pickUpChest() {
		gp.obj[0]=new Chest(gp);
		int score=prisoner.score;
		prisoner.pickUpObject(0);
		assertEquals(prisoner.score,score+200);
		
		
	}
	@Test
	void pickUpSkull() {
		gp.obj[0]=new Skull(gp);
		int score=prisoner.score;
		prisoner.pickUpObject(0);
		assertEquals(score+200,prisoner.score);
		
		
	}
	@Test
	void setEnemyOnPath() {
		enemy.mapX=0;
		enemy.mapY=0;
		gp.prisoner.mapX=enemy.mapX;
		gp.prisoner.mapY=enemy.mapY;
		enemy.onPath=false;
		enemy.update();
		assertTrue(enemy.onPath);
		
		
		
	}
	@Test
	void setEnemyOffPath() {
		enemy.mapX=0;
		enemy.mapY=0;
		gp.prisoner.mapX=20*gp.tileSize+enemy.mapX;
		gp.prisoner.mapY=20*gp.tileSize+enemy.mapY;
		enemy.onPath=true;
		enemy.update();
		assertTrue(!enemy.onPath);
		
		
		
	}
	@Test
	void enemyRandomDirection() {
		int count=0;
		String direction=enemy.direction;
		//chances of count remaining 0 is 1/100
		for (int i=0;i<6000;i++) {
		enemy.onPath=false;
		enemy.setAction();
		if(direction!=enemy.direction) {
			direction=enemy.direction;
			count++;
		}
		
	}
		assertTrue(0<count);
	}

	
	@Test
	void animationCheckerDown() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.prisoner=mock(Prisoner.class);
		
		character.animationCounter=13;
		character.update();
		assertEquals(character.animationCounter,0);
	}
	@Test
	void animationCheckerUp() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.prisoner=mock(Prisoner.class);
		character.direction="up";
		character.animationCounter=13;
		character.update();
		assertEquals(character.animationCounter,0);
	}
	@Test
	void animationCheckerRight() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.prisoner=mock(Prisoner.class);
		character.direction="right";
		character.animationCounter=13;
		character.update();
		assertEquals(character.animationCounter,0);
	}
	@Test
	void animationCheckerLeft() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.prisoner=mock(Prisoner.class);
		character.direction="left";
		character.animationCounter=13;
		character.update();
		assertEquals(character.animationCounter,0);
	}
	@Test
	void invincible() {
		prisoner.keyPressed.upPressed=true;
		prisoner.invincible=true;
		for (int i=0;i<61; i++) {
		prisoner.update();
		}
		assertTrue(!prisoner.invincible);
			
	}
	@Test
	void drawRight1() {
		prisoner.direction="right";
		prisoner.animationNum=1;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
		
		
	}
	@Test
	void drawRight2() {
		prisoner.direction="right";
		prisoner.animationNum=2;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}
	@Test
	void drawUp1() {
		prisoner.direction="up";
		prisoner.animationNum=1;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}@Test
	void drawUp2() {
		prisoner.direction="up";
		prisoner.animationNum=2;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}@Test
	void drawDown1() {
		prisoner.direction="down";
		prisoner.animationNum=1;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}@Test
	void drawDown2() {
		prisoner.direction="down";
		prisoner.animationNum=2;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}@Test
	void drawLeft1() {
		prisoner.direction="left";
		prisoner.animationNum=1;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}@Test
	void drawLeft2() {
		prisoner.direction="left";
		prisoner.animationNum=2;
		Graphics2D g2=mock(Graphics2D.class);
		prisoner.draw(g2);
	}
	
	@Test
	void searchPathDownCheckCollision1() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=0;
	    character.mapY=0;
	    Node node=new Node(3,3);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(3, 3);
	    
	    assertTrue(!character.onPath);
	}
	@Test
	void searchPathDownCheckCollision2() {
		
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=1000;
	    character.mapY=0;
	    Node node=new Node(1,1);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(3, 3);
	    
	    assertTrue(!character.onPath);
	}
	@Test
	void searchPathUpCheckCollision2() {
		
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=1000;
	    character.mapY=1000;
	    Node node=new Node(1,1);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(3, 3);
	    
	    assertTrue(!character.onPath);
	}
	@Test
void searchPathUpCheckCollision1() {
		
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=1000;
	    character.mapY=1000;
	    Node node=new Node(1,1);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(3, 3);
	    
	    assertTrue(!character.onPath);
	}
	@Test
	void searchPathRight() {
			
			mockgp.cChecker=mock(CollisionChecker.class);
			mockgp.pFinder=mock(EnemyAI.class);
			mockgp.pFinder.pathList=mock(ArrayList.class);
			when(mockgp.pFinder.search()).thenReturn(true);
		    character.mapX=1000;
		    character.mapY=132;
		    Node node=new Node(1,3);
		    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
		    character.searchPath(3, 3);
		    
		    assertTrue(!character.onPath);
		}
	
	@Test
	void searchPathDown() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=0;
	    character.mapY=0;
	    Node node=new Node(0,3);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(3, 3);
	    
	    assertTrue(!character.onPath);
	}
	@Test
	void searchPathUp() {
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=48;
	    character.mapY=48;
	    Node node=new Node(1,0);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(1, 0);
	    
	    assertTrue(!character.onPath);
	}
	@Test
	void searchPathUpCheckCollision() {
		mockgp.cChecker=mock(CollisionChecker.class);
		mockgp.pFinder=mock(EnemyAI.class);
		mockgp.pFinder.pathList=mock(ArrayList.class);
		when(mockgp.pFinder.search()).thenReturn(true);
	    character.mapX=48;
	    character.mapY=48;
	    Node node=new Node(0,0);
	    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
	    character.searchPath(2, 2);
	    
	    assertTrue(!character.onPath);
	}
	@Test
	void searchPathLeft() {
			
			mockgp.cChecker=mock(CollisionChecker.class);
			mockgp.pFinder=mock(EnemyAI.class);
			mockgp.pFinder.pathList=mock(ArrayList.class);
			when(mockgp.pFinder.search()).thenReturn(true);
		    character.mapX=0;
		    character.mapY=132;
		   
		    Node node=new Node(1,3);
		  
		    when(mockgp.pFinder.pathList.get(0)).thenReturn(node);
		    character.searchPath(3, 3);
		    
		    assertTrue(!character.onPath);
		}
	
}
