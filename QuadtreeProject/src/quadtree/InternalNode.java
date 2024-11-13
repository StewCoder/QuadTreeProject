package quadtree;

/**
 * The InternalNode class represents a node in the Quadtree that contains child nodes.
 * It divides the space into four quadrants and stores references to its children nodes.
 * It is responsible for managing the space between rectangles within the Quadtree.
 */
public class InternalNode extends Node {
    private Node[] children;

    /**
     * Constructs an InternalNode with specified boundaries.
     * This node divides the space into four quadrants and initializes its children.
     *
     * @param xMin The minimum x-coordinate of the space represented by this node.
     * @param yMin The minimum y-coordinate of the space represented by this node.
     * @param xMax The maximum x-coordinate of the space represented by this node.
     * @param yMax The maximum y-coordinate of the space represented by this node.
     */
    public InternalNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        this.children = new Node[4]; // Four quadrants: 0 - top-left, 1 - top-right, 2 - bottom-left, 3 - bottom-right
    }

    /**
     * Inserts a rectangle into one of the child nodes of this InternalNode.
     * The rectangle will be inserted into a child node depending on its location.
     *
     * @param rect The rectangle to insert.
     * @return true if the rectangle was successfully inserted, false otherwise.
     */
    @Override
    public boolean insert(Rectangle rect) {
        // Attempt to insert the rectangle into one of the children nodes
        for (Node child : children) {
            if (child != null && child.insert(rect)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a rectangle from one of the child nodes of this InternalNode.
     *
     * @param rect The rectangle to delete.
     * @return true if the rectangle was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(Rectangle rect) {
        // Attempt to delete the rectangle from one of the children nodes
        for (Node child : children) {
            if (child != null && child.delete(rect)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a rectangle at the specified coordinates (x, y) within this InternalNode's children.
     *
     * @param x The x-coordinate of the point to search for.
     * @param y The y-coordinate of the point to search for.
     * @return The rectangle at the specified location, or null if no rectangle is found.
     */
    @Override
    public Rectangle find(double x, double y) {
        // Search for the rectangle in the children nodes
        for (Node child : children) {
            if (child != null) {
                Rectangle rect = child.find(x, y);
                if (rect != null) {
                    return rect;
                }
            }
        }
        return null;
    }

    /**
     * Dumps the contents of this InternalNode and its children to the console.
     * Displays the bounds of the node and recursively dumps the child nodes.
     *
     * @param level The depth level in the Quadtree to determine the indentation.
     */
    @Override
    public void dump(int level) {
        // Print the bounds of this InternalNode
        System.out.println("\t".repeat(level) + "Internal Node: [" + xMin + ", " + yMin + "] to [" + xMax + ", " + yMax + "]");
        // Recursively dump the children nodes
        for (Node child : children) {
            if (child != null) {
                child.dump(level + 1);
            }
        }
    }
}
