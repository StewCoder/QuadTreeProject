package quadtree;

import java.util.ArrayList;
import java.util.List;

/**
 * The Node class is an abstract base class for nodes in the Quadtree.
 * It represents a region of space and contains a collection of rectangles that fit within its boundaries.
 * Subclasses will implement specific behaviors for inserting, deleting, finding, and dumping rectangles within the node.
 */
public abstract class Node {
    protected double xMin, yMin, xMax, yMax; // Boundaries of the node
    protected List<Rectangle> rectangles; // Store rectangles in this node

    /**
     * Constructs a Node with specified boundaries.
     * Initializes the list of rectangles that can be stored in the node.
     *
     * @param xMin The minimum x-coordinate of this node.
     * @param yMin The minimum y-coordinate of this node.
     * @param xMax The maximum x-coordinate of this node.
     * @param yMax The maximum y-coordinate of this node.
     */
    public Node(double xMin, double yMin, double xMax, double yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.rectangles = new ArrayList<>();
    }

    /**
     * Inserts a rectangle into the node. 
     * The behavior of this method depends on the type of node.
     *
     * @param rect The rectangle to insert.
     * @return true if the rectangle was successfully inserted, false otherwise.
     */
    public abstract boolean insert(Rectangle rect);

    /**
     * Deletes the selected rectangle from the node.
     * The behavior of this method depends on the type of node.
     *
     * @param rect The rectangle to delete.
     * @return true if the rectangle was successfully deleted, false otherwise.
     */
    public abstract boolean delete(Rectangle rect);

    /**
     * Finds a rectangle at the selected coordinates (x, y) within the node.
     * The behavior of this method depends on the type of node.
     *
     * @param x The x-coordinate of the point to search for.
     * @param y The y-coordinate of the point to search for.
     * @return The rectangle at the specified location, or null if no rectangle is found.
     */
    public abstract Rectangle find(double x, double y);

    /**
     * Dumps the contents of the node to the console.
     * This includes printing the bounds of the node and, for LeafNodes, the stored rectangles.
     * The behavior of this method depends on the type of node.
     *
     * @param level The depth level in the Quadtree to determine the indentation for printing.
     */
    public abstract void dump(int level);
}
