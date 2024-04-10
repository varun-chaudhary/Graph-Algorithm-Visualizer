import java.util.ArrayList;
import java.util.Collections;

public class Pathfinder {

    private ArrayList<Node> path;
    private Node[][] grid;
    private Node startNode, endNode, currentNode;

    public Pathfinder(Node[][] grid, Node startNode, Node endNode) {
        this.grid = grid;
        this.startNode = startNode;
        this.endNode = endNode;
        this.currentNode = startNode;
    }

    public ArrayList<Node> getShortestPath() {
        if (this.grid == null || (!this.grid[endNode.getY()][endNode.getX()].isVisited()
                && !Node.isEqual(this.currentNode, this.endNode))) { // Didn't reach end path
            return null;
        } else {
            ArrayList<Node> shortestPath = new ArrayList<>();
            Node pathNode = this.grid[endNode.getY()][endNode.getX()];
            while (pathNode.getParent() != null) {
                pathNode = pathNode.getParent();
                shortestPath.add(pathNode);
            }
            Collections.reverse(shortestPath);
            return shortestPath;
        }
    }

    private ArrayList<Node> getNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        int nodeX = node.getX();
        int nodeY = node.getY();

        if (nodeY > 0) {
            neighbors.add(this.grid[nodeY - 1][nodeX]);
        }
        if (nodeY < this.grid.length - 1) {
            neighbors.add(this.grid[nodeY + 1][nodeX]);
        }
        if (nodeX > 0) {
            neighbors.add(this.grid[nodeY][nodeX - 1]);
        }
        if (nodeX < this.grid[nodeY].length - 1) {
            neighbors.add(this.grid[nodeY][nodeX + 1]);
        }

        return neighbors;
    }

}
