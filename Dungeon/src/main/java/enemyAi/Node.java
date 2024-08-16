/**
 * Represents a node in the grid used for pathfinding.
 * Each node has coordinates, cost values, and flags indicating its state.
 */
package enemyAi;

public class Node {
	public Node parent;
	public int col;
	public int row;
	public int gCost;
	public int hCost;
	public int fCost;
	boolean solid;
	public boolean open;
	boolean checked;
	

    /**
     * Constructs a node with the specified column and row coordinates.
     * @param col The column index of the node.
     * @param row The row index of the node.
     */
	public Node(int col, int row) {
		this.col=col;
		this.row=row;
		}
}
