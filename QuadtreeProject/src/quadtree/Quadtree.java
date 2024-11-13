package quadtree;

/**
 * The Quadtree class represents a spatial data structure that efficiently stores and manages
 * rectangular regions in a 2D space. The quadtree splits space into four quadrants to facilitate
 * fast searching, insertion, and deletion of rectangles.
 */
public class Quadtree {
    private Node root; // The root node of the quadtree

    /**
     * Constructs a Quadtree with an initial root node. 
     * The root is initially a LeafNode with a predefined space of (-50, -50) to (50, 50).
     */
    public Quadtree() {
        root = new LeafNode(-50, -50, 50, 50); // Starting quadtree root with initial space
    }

    /**
     * Inserts a rectangle into the quadtree. The rectangle is created with the specified coordinates
     * and dimensions, and the insertion is delegated to the root node.
     *
     * @param x The x-coordinate of the bottom-left corner of the rectangle.
     * @param y The y-coordinate of the bottom-left corner of the rectangle.
     * @param length The length (height) of the rectangle.
     * @param width The width of the rectangle.
     * @return true if the rectangle was successfully inserted, false otherwise.
     */
    public boolean insert(double x, double y, double length, double width) {
        Rectangle rect = new Rectangle(x, y, length, width);
        return root.insert(rect);
    }

    /**
     * Deletes a rectangle from the quadtree based on its coordinates. 
     * It finds the rectangle with the specified (x, y) location and deletes it from the tree.
     *
     * @param x The x-coordinate of the rectangle to delete.
     * @param y The y-coordinate of the rectangle to delete.
     * @return true if the rectangle was successfully deleted, false if no rectangle exists at the given coordinates.
     */
    public boolean delete(double x, double y) {
        Rectangle rect = root.find(x, y);
        if (rect != null) {
            return root.delete(rect);
        }
        return false;
    }

    /**
     * Finds and returns the rectangle located at the specified coordinates (x, y).
     * The search is performed starting from the root node of the quadtree.
     *
     * @param x The x-coordinate of the point to search for.
     * @param y The y-coordinate of the point to search for.
     * @return The rectangle at the specified coordinates, or null if no rectangle is found.
     */
    public Rectangle find(double x, double y) {
        return root.find(x, y);
    }

    /**
     * Dumps the contents of the quadtree to the console.
     * This method prints the structure of the tree, including all stored rectangles and their locations.
     */
    public void dump() {
        root.dump(0);
    }
}
