package game.Dungeon.enemyAiTest;

import main.GamePanel;
import object.*;
import main.KeyChecker;
import character.Enemy;
import character.Prisoner;
import enemyAi.EnemyAI;
import enemyAi.Node;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyAITest {
	@Mock
	private GamePanel mockgp;
	
	EnemyAI pFinder;
	
	
@BeforeEach
void setup() {
	mockgp=mock(GamePanel.class) ;
	pFinder=new EnemyAI(mockgp);
}
@Test
void openNode() {
	Node node=new Node(0,0);
	pFinder.openNode(node);
	assertTrue(node.open);
	
}
@Test
void setNodes() {
	pFinder.node[0][0]=new Node(3,3);
	pFinder.node[1][1]=new Node(4,4);
	pFinder.currentNode=new Node(0,0);
	pFinder.startNode=new Node(1,1);
	pFinder.goalNode=new Node(2,2);
	//testing functionality, throws a runtime error as GamePanel Class has many dependencies
	try {
	pFinder.setNodes(0, 0, 1, 1);
	}
	catch(Exception e) {
		
	}
	assertEquals(pFinder.currentNode,pFinder.startNode);
	assertEquals(pFinder.currentNode,pFinder.node[0][0]);
	assertEquals(pFinder.goalNode,pFinder.node[1][1]);
}
@Test
void getCost() {
	Node testNode=new Node(0,0);
	pFinder.startNode=new Node(1,1);
	pFinder.goalNode=new Node(2,2);
	pFinder.getCost(testNode);
	assertEquals(testNode.fCost,6);
}
@Test
void trackThePath() {
	int temp = pFinder.pathList.size();
	pFinder.startNode=new Node(1,1);
	pFinder.goalNode=new Node(2,2);
	pFinder.goalNode.parent=pFinder.startNode;
	pFinder.trackThePath();
	assertTrue(temp<pFinder.pathList.size());
	
}
@Test 
void searchFail() {
	pFinder.currentNode=new Node(1,1);
	pFinder.startNode=new Node(1,1);
	pFinder.goalNode=new Node(0,0);
	pFinder.node[0][1]=new Node(0,1);
	pFinder.getCost(pFinder.node[0][1]);
	pFinder.node[1][0]=new Node(1,0);
	pFinder.getCost(pFinder.node[1][0]);

	pFinder.openList.add(pFinder.currentNode);
	
	assertTrue(!pFinder.search());
	
	
	
}

}
