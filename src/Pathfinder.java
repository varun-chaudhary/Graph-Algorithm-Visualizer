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

    public ArrayList<Node> bfs() {
        this.path = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(this.startNode);
        this.grid[this.startNode.getY()][this.startNode.getX()].setVisited(true);
        while (!queue.isEmpty()) {
            if (this.grid[endNode.getY()][endNode.getX()].isVisited()) {
                System.out.println("BFS: End found; breaking");
                break;
            }

            this.currentNode = queue.poll();
            for (Node neighbor : getNeighbors(this.currentNode)) {
                if (neighbor != null && !neighbor.isVisited() && !neighbor.isBarrier()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);

                    neighbor.setParent(this.currentNode);
                    this.path.add(this.grid[neighbor.getY()][neighbor.getX()]);
                }
            }
        }

        return this.path;
    }

    public ArrayList<Node> dfs() {
        this.path = new ArrayList();
        dfsRecursive(this.startNode, null);
        return this.path;
    }

    private void dfsRecursive(Node currentNode, Node parentNode) {
        int currentX = currentNode.getX();
        int currentY = currentNode.getY();
        if (this.grid[endNode.getY()][endNode.getX()].isVisited()) {
            System.out.println("DFS: End found; returning");
            return;
        } else if (currentY < 0 || currentY >= this.grid.length || currentX < 0
                || currentX >= this.grid[currentY].length || this.grid[currentY][currentX].isBarrier()
                || this.grid[currentY][currentX].isVisited()) { // Exit method if out of bounds or on closed node(?)
            return;
        }

        this.grid[currentY][currentX].setVisited(true);
        this.path.add(this.grid[currentY][currentX]);
        if (parentNode != null) {
            currentNode.setParent(parentNode);
        }

        try { // Up
            dfsRecursive(this.grid[currentY - 1][currentX], currentNode);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try { // Right
            dfsRecursive(this.grid[currentY][currentX + 1], currentNode);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try { // Down
            dfsRecursive(this.grid[currentY + 1][currentX], currentNode);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try { // Left
            dfsRecursive(this.grid[currentY][currentX - 1], currentNode);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

}
