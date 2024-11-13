package quadtree;

/**
 * The Rectangle class represents a rectangular region with a position and size.
 * It stores the coordinates (x, y) of the rectangle's bottom-left corner and its dimensions (length and width).
 */
public class Rectangle {
    private double x, y, length, width;

    /**
     * Constructs a Rectangle with specified coordinates and dimensions.
     *
     * @param x The x-coordinate of the bottom-left corner of the rectangle.
     * @param y The y-coordinate of the bottom-left corner of the rectangle.
     * @param length The length (or height) of the rectangle.
     * @param width The width of the rectangle.
     */
    public Rectangle(double x, double y, double length, double width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    /**
     * Gets the x-coordinate of the bottom-left corner of the rectangle.
     *
     * @return The x-coordinate of the rectangle.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the bottom-left corner of the rectangle.
     *
     * @return The y-coordinate of the rectangle.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the length (height) of the rectangle.
     *
     * @return The length of the rectangle.
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the length (height) of the rectangle.
     *
     * @param length The new length of the rectangle.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width The new width of the rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Returns a string representation of the rectangle, including its position and size.
     *
     * @return A string describing the rectangle.
     */
    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + "): " + length + "x" + width;
    }
}
