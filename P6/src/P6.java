//  Assignment
// Author: Tiffany Miao
// Date:   Feb 22, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

public class P6 {

    // Class variables
    public static Maze maze;
    public static int mazeWidth;
    public static int mazeHeight;

    public static void main(String[] args) {

        // Create maze
        String fileName = args[0];
        System.err.println("Maze name: " + fileName);

        // Get dimensions
        maze = new Maze(fileName);
        mazeWidth = maze.getWidth();
        mazeHeight = maze.getHeight();
        System.err.println("Maze width: " + mazeWidth);
        System.err.println("Maze height: " + mazeHeight);

        // Add code to move around maze
        while(true) {
        	while(maze.getRow() % 2 == 0 && maze.getColumn() < maze.getWidth() - 1) {
        		if(maze.moveRight() == false) {
        			maze.moveDown();
        			maze.moveRight();
        			maze.moveRight();
        			maze.moveUp();
        		}
        	}
        while (maze.getRow() % 2 == 1 && maze.getColumn() > 0) {
        	if (maze.moveLeft() == false) {
        		maze.moveDown();
        		maze.moveLeft();
        		maze.moveLeft();
        		maze.moveUp();
        	}
        }
        maze.moveDown();

        }
    }
}   