package quadtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Main class provides a command-line interface for interacting with a Quadtree.
 * It processes commands such as "Insert", "Find", "Delete", "Dump", and "Update"
 * from a file to manipulate the Quadtree.
 */
public class Main {

    /**
     * The main method initializes a Quadtree and processes commands from a file.
     * It should expect a single command-line argument specifying the file containing the commands.
     * Each command in the file is processed to perform operations on the Quadtree.
     *
     * @param args Command-line arguments. Argument should be the path to the command file.
     */
    public static void main(String[] args) {
        Quadtree quadtree = new Quadtree();

        // Check if the correct number of arguments is provided
        if (args.length != 1) {
            System.out.println("Usage: java Main <cmmd-file>");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String command = parts[0];

                // Process each command
                switch (command) {
                    case "Insert":
                        // Insert a rectangle into the Quadtree
                        double x = Double.parseDouble(parts[1]);
                        double y = Double.parseDouble(parts[2]);
                        double length = Double.parseDouble(parts[3]);
                        double width = Double.parseDouble(parts[4]);
                        if (!quadtree.insert(x, y, length, width)) {
                            System.out.println("You can not double insert at a position.");
                        }
                        break;

                    case "Find":
                        // Find a rectangle at the given coordinates
                        x = Double.parseDouble(parts[1]);
                        y = Double.parseDouble(parts[2]);
                        Rectangle found = quadtree.find(x, y);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Nothing is at (" + x + ", " + y + ").");
                        }
                        break;

                    case "Delete":
                        // Delete a rectangle at the given coordinates
                        x = Double.parseDouble(parts[1]);
                        y = Double.parseDouble(parts[2]);
                        if (!quadtree.delete(x, y)) {
                            System.out.println("Nothing to delete at (" + x + ", " + y + ").");
                        }
                        break;

                    case "Dump":
                        // Dump the Quadtree contents
                        quadtree.dump();
                        break;

                    case "Update":
                        // Update the size of an existing rectangle
                        x = Double.parseDouble(parts[1]);
                        y = Double.parseDouble(parts[2]);
                        double newLength = Double.parseDouble(parts[3]);
                        double newWidth = Double.parseDouble(parts[4]);
                        Rectangle rectToUpdate = quadtree.find(x, y);
                        if (rectToUpdate != null) {
                            rectToUpdate.setLength(newLength);
                            rectToUpdate.setWidth(newWidth);
                        } else {
                            System.out.println("Nothing to update at (" + x + ", " + y + ").");
                        }
                        break;

                    default:
                        // Handle unknown commands
                        System.out.println("Unknown command: " + command);
                }
            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur while reading the file
            e.printStackTrace();
        }
    }
}
