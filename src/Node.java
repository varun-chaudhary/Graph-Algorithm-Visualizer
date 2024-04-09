import java.awt.Color;

public class Node {

    private int x, y;
    private Node parent;
    private int g, h, f;

    private Color color;
    public static final Color EMPTY_NODE = Color.WHITE,
            BARRIER_NODE = Color.BLACK,
            START_NODE = Color.GREEN,
            END_NODE = Color.RED;
    public static Color SEARCHED_NODE = new Color(0, 200, 255),
            SEARCHED_NODE_2 = new Color(255, 215, 0);
    private boolean visited = false;

    public static boolean isEqual(Node start, Node end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getF() {
        return f;
    }

    public Node getParent() {
        return parent;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return this.color == EMPTY_NODE;
    }

    public boolean isBarrier() {
        return this.color == BARRIER_NODE;
    }

    public boolean isStart() {
        return this.color == START_NODE;
    }

    public boolean isEnd() {
        return this.color == END_NODE;
    }

    public boolean isSearched() {
        return this.color == SEARCHED_NODE || this.color == SEARCHED_NODE_2;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setEmpty() {
        this.color = EMPTY_NODE;
    }

    public void setBarrier() {
        this.color = BARRIER_NODE;
    }

    public void setStart() {
        this.color = START_NODE;
    }

    public void setEnd() {
        this.color = END_NODE;
    }

    public void setSearched(boolean shortestNode) {
        if (shortestNode) {
            this.color = SEARCHED_NODE_2;
        } else {
            this.color = SEARCHED_NODE;
        }
    }

    public void setVisited(boolean isVisited) {
        this.visited = isVisited;
    }

    public Node(int x, int y) {
        this.setPos(x, y);
        this.color = EMPTY_NODE;
    }

    public Node(int x, int y, Color color) {
        this.setPos(x, y);
        if (color == EMPTY_NODE || color == BARRIER_NODE || color == START_NODE || color == END_NODE
                || color == SEARCHED_NODE) {
            this.color = color;
        } else {
            this.color = EMPTY_NODE;
        }
    }
}
