public class RandomMaze {
    private char[][] maze;
    private boolean[][] visited;
    private int steps;

    public RandomMaze(int size) {
        maze = new char[size][size];

        boolean result = false;

        setMaze();
        visited = new boolean[size][size];
        int row = (int)(Math.random()*size);
        int col = (int)(Math.random()*size);
        maze[row][col] = 'A';

        int row2 = (int)(Math.random()*size);
        int col2 = (int)(Math.random()*size);
        maze[row2][col2] = 'Z';
        result = validPath(row,col);

        System.out.println("Valid path: "  + result);

    }

    /** This method returns true when there is a valid path from 'A' to 'Z'
     */
    public boolean validPath(int row, int col){
        if(isValid(row, col) && !visited[row][col]){
            visited[row][col] = true;
            if(maze[row][col] != '_'){
                if (maze[row][col] == 'Z' || validPath(row - 1, col) || validPath(row + 1, col) || validPath(row, col + 1) || validPath(row, col - 1)) {
                    steps++;
                    if (maze[row][col] == 'Z') {
                        return true;
                    }
                    if(maze[row][col] != 'A'){
                        maze[row][col] = 'O';
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(int r, int c){
        return r >= 0 && r < maze.length && c >= 0 && c < maze[0].length;
    }

    public String toString() {
        String output = "";
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                output += ""+  maze[r][c] + " ";
            }
            output += "\n";
        }
        output += "Steps: " + steps + "\n";

        return output;
    }

    public void setMaze(){
        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                if(Math.random() < .7)
                    maze[r][c] = '1';
                else
                    maze[r][c] = '_';
            }
        }
    }

}

class MazeTester {
    public static void main(String[] args) {
        RandomMaze maze = new RandomMaze(10);
        System.out.println(maze);

    }
}