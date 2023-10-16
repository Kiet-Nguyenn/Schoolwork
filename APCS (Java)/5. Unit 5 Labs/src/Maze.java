import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class Maze {
    private int[][] maze;
    private boolean exitFound;
    private boolean[][] visited;
    private int steps;

    public Maze(int size, String line) {
        // instantiate maze 2d Array

        // assign exitFound a value
        maze = new int[size][size];
        visited = new boolean[size][size];
        exitFound = false;
        int index = 0;
        for (int r = 0; r < maze.length; r++)
            for (int c = 0; c < maze[r].length; c++)
                maze[r][c] = Integer.parseInt(line.substring(index, index+++1));
    }

    public boolean checkForExitPath(int r, int c) {
        if(isValid(r,c) && !visited[r][c]) {
            visited[r][c] = true;
            if(maze[r][c] == 1) {
                if (c == maze[r].length -1 || checkForExitPath(r, c + 1) || checkForExitPath(r, c - 1) || checkForExitPath(r - 1, c) || checkForExitPath(r + 1, c)) {
                    if(c == maze[r].length - 1){
                        exitFound = true;
                    }
                    maze[r][c] = 9;
                    steps++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(int r, int c){
        return r >= 0 && r < maze.length && c >= 0 && c < maze[r].length;
    }

    public String toString() {
        String output = "";
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                output += ""+  maze[r][c] + " ";
            }
            output += "\n";
        }

        if(exitFound) {
            output += "exit found\n";
        } else {
            output += "exit not found\n";
        }
        if(steps < 0) steps = 0;
        output += "Steps: " + steps + "\n";


        return output;
    }
}


class MazeRunner {
    public static void main(String args[]) throws IOException {


        Maze test = new Maze(5, "1000111110001010111000001");
        test.checkForExitPath(0, 0);
        System.out.println(test);

        test = new Maze(7, "1000011111101000100100111010010101001011100101001");
        test.checkForExitPath(0, 0);
        System.out.println(test);

        test = new Maze(7, "1000010111101000100100111010010101001011100101010");
        test.checkForExitPath(0, 0);
        System.out.println(test);

        test = new Maze(7, "1011010111111000100010111111010101011111100101010");
        test.checkForExitPath(0, 0);
        System.out.println(test);

        test = new Maze(10, "1011010111111111010100100011110111111101010101010111111101110101010001011101000001010101110111110111");
        test.checkForExitPath(0, 0);
        System.out.println(test);
        test = new Maze(10, "1011011110111111010100100011100111111101010101010111111101100101010000011101001101010101110111110111");
        test.checkForExitPath(0, 0);
        System.out.println(test);

    }
}