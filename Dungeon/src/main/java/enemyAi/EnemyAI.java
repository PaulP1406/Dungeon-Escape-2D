/**
 * Represents the artificial intelligence responsible for controlling enemy behavior and pathfinding.
 * This class manages pathfinding algorithms and node manipulation for enemy characters.
 */
package enemyAi;
import java.util.ArrayList;

import character.Character;
import main.GamePanel;
public class EnemyAI {
	GamePanel gp;
	public Node[][] node;
	public ArrayList<Node> openList=new ArrayList<>();
	public ArrayList<Node> pathList=new ArrayList<>();
	public Node startNode;
	public Node goalNode;
	public Node currentNode;
	boolean goalReached=false;
	int step=0;
	 /**
     * Constructs an EnemyAI object associated with the given game panel.
     * @param gp The game panel to which the AI belongs.
     */
	public EnemyAI(GamePanel gp) {
		this.gp=gp;
		instantiateNodes();
	}
	  /**
     * Initializes the grid of nodes representing the game world.
     */
	public void instantiateNodes() {
		node=new Node[gp.maxWorldCol][gp.maxWorldRow];
		int col=0;
		int row=0;
		
		while (col<gp.maxWorldCol && row < gp.maxWorldRow) {
			node[col][row]=new Node(col,row);
			col++;
			if(col==gp.maxWorldCol) {
				col=0;
				row++;
			}
			
			
		}
	}
	   /**
     * Resets the state of all nodes in the grid.
     */
	public void resetNodes() {

		int col=0;
		int row=0;

	while(col<gp.maxWorldCol && row < gp.maxWorldRow) {
		
		
		node[col][row].open=false;
		node[col][row].checked=false;
		node[col][row].solid=false;		
		
		col++;
		
		if(col==gp.maxWorldCol) {
			col=0;
			row++;
		}
	}
		openList.clear();
		pathList.clear();
		goalReached=false;
		step=0;
	}

    /**
     * Sets the start and goal nodes for pathfinding.
     * @param startCol The column index of the starting node.
     * @param startRow The row index of the starting node.
     * @param goalCol The column index of the goal node.
     * @param goalRow The row index of the goal node.
     */
	public void setNodes (int startCol, int startRow, int goalCol, int goalRow) {
		resetNodes();
		
		startNode=node[startCol][startRow];
		currentNode=startNode;
		goalNode=node[goalCol][goalRow];
		openList.add(currentNode);
		int col=0;
		int row=0;
		while(col<gp.maxWorldCol && row < gp.maxWorldRow) {
			
			
		int tileNum= gp.tileM.mapTileNum[col][row];
		if(gp.tileM.tile[tileNum].collision==true) {
			node[col][row].solid=true;
		}
		
		
		getCost(node[col][row]);
		col++;
		if(col==gp.maxWorldCol) {
			col=0;
			row++;
		}
		}
		
	}  /**
     * Calculates the cost values (G, H, and F) for a given node.
     * @param node The node for which to calculate costs.
     */	
	public void getCost(Node node) {
		int xDistance=Math.abs(node.col-startNode.col);
		int yDistance=Math.abs((node.row-startNode.row));
		node.gCost=xDistance+yDistance;
		
		xDistance=Math.abs((node.col-goalNode.col));
		yDistance=Math.abs(node.row-goalNode.row);
		node.hCost=xDistance+yDistance;
		
		node.fCost=node.gCost+node.hCost;
		
	}
	/**
     * Executes the pathfinding algorithm to find a path from the start node to the goal node.
     * @return True if a path to the goal node is found, false otherwise.
     */
	public boolean search() {
		while(goalReached == false && step<500) {
			int col=currentNode.col;
			int row=currentNode.row;
			
			currentNode.checked=true;
					openList.remove(currentNode);
					
				if (row-1>=0) {
					openNode(node[col][row-1]);
					
				}
				if (col-1>=0) {
					openNode(node[col-1][row]);
					
				}if (row+1<gp.maxWorldRow) {
					openNode(node[col][row+1]);
				
					
				}if (col+1<gp.maxWorldCol) {
					openNode(node[col+1][row]);
					
				}
				int bestNodeIndex=0;
				int bestNodefCost=999;
				
				for (int i=0; i<openList.size(); i++) {
					if(openList.get(i).fCost<bestNodefCost){
						bestNodeIndex=i;
						bestNodefCost=openList.get(i).fCost;
					}
					else if(openList.get(i).fCost==bestNodefCost){
						if(openList.get(i).gCost<openList.get(bestNodeIndex).gCost) {
							bestNodeIndex=i;
						}
					}
				}
				if(openList.size()==0) {
					break;
				}
				currentNode=openList.get(bestNodeIndex);
				if(currentNode==goalNode) {
					goalReached=true;
					trackThePath();
				}
				step++;
		}
		return goalReached;
	}

    
	 /**
     * Traces the path from the goal node back to the start node and stores it in the path list.
     */
	public void trackThePath() {
		Node current=goalNode;
		while(current!=startNode) {
			pathList.add(0,current);
			current=current.parent;
		}
	}
    /**
     * Marks the given node as open if it meets the criteria for being open.
     * @param node The node to be marked as open.
     */
	public void openNode(Node node) {
		if(node.open==false&&node.checked==false&&node.solid==false) {
			node.open=true;
			node.parent=currentNode;
			openList.add(node);
		}
	}
}
