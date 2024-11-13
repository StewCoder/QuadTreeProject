package quadtree;

/**
 * The LeafNode class represents a leaf node in the Quadtree.
 * A leaf node stores a collection of rectangles within its boundaries.
 * If a leaf node exceeds its capacity, it will need to split into an InternalNode.
 */
public class LeafNode extends Node {

    /**
     * Constructs a LeafNode with specified boundaries.
     * The node stores rectangles within the given bounds.
     *
     * @param xMin The minimum x-coordinate of the space represented by this node.
     * @param yMin The minimum y-coordinate of the space represented by this node.
     * @param xMax The maximum x-coordinate of the space represented by this node.
     * @param yMax The maximum y-coordinate of the space represented by this node.
     */
    public LeafNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
    }

    /**
     * Inserts a rectangle into this LeafNode if there is enough capacity.
     * If the number of rectangles exceeds the limit, the node cannot insert the rectangle.
     * The node should split into an InternalNode in that case.
     *
     * @param rect The rectangle to insert.
     * @return true if the rectangle was successfully inserted, false if the node is full and cannot insert.
     */
    @Override
    public boolean insert(Rectangle rect) {
        // Check if the rectangle fits in this leaf node's bounds and insert
        if (rectangles.size() < 5) {
            rectangles.add(rect);
            return true;
        } else {
            // If the node exceeds the limit, it should split into an InternalNode
            return false;
        }
    }

    /**
     * Deletes the specified rectangle from this LeafNode.
     *
     * @param rect The rectangle to delete.
     * @return true if the rectangle was successfully deleted, false if the rectangle was not found.
     */
    @Override
    public boolean delete(Rectangle rect) {
        return rectangles.remove(rect);
    }

    /**
     * Finds a rectangle at the specified coordinates (x, y) within this LeafNode.
     *
     * @param x The x-coordinate of the point to search for.
     * @param y The y-coordinate of the point to search for.
     * @return The rectangle at the specified location, or null if no rectangle is found.
     */
    @Override
    public Rectangle find(double x, double y) {
        for (Rectangle rect : rectangles) {
            if (rect.getX() == x && rect.getY() == y) {
                return rect;
            }
        }
        return null;
    }

    /**
     * Dumps the contents of this LeafNode to the console, including its rectangles.
     * It prints the bounds of the node and each stored rectangle.
     *
     * @param level The depth level in the Quadtree to determine the indentation for printing.
     */
    @Override
    public void dump(int level) {
        // Print the bounds of this LeafNode
        System.out.println("\t".repeat(level) + "Leaf Node: [" + xMin + ", " + yMin + "] to [" + xMax + ", " + yMax + "]");
        // Print each stored rectangle in the leaf node
        for (Rectangle rect : rectangles) {
            System.out.println("\t".repeat(level + 1) + rect);
        }
    }
}
