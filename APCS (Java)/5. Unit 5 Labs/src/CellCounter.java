public class CellCounter {
    private char[][] matrix;
    private boolean[][] visited;

    public CellCounter() {
        matrix = new char[][]{{'@', '-', '@', '-', '-', '@', '-', '@', '@', '@'},
                {'@', '@', '@', '-', '@', '@', '-', '@', '-', '@'},
                {'-', '-', '-', '-', '-', '-', '-', '@', '@', '@'},
                {'-', '@', '@', '@', '@', '@', '-', '@', '-', '@'},
                {'-', '@', '-', '@', '-', '@', '-', '@', '-', '@'},
                {'@', '@', '@', '@', '@', '@', '-', '@', '@', '@'},
                {'-', '@', '-', '@', '-', '@', '-', '-', '-', '@'},
                {'-', '@', '@', '@', '-', '@', '-', '-', '-', '-'},
                {'-', '@', '-', '@', '-', '@', '-', '@', '@', '@'},
                {'-', '@', '@', '@', '@', '@', '-', '@', '@', '@'}};

        visited = new boolean[matrix.length][matrix[0].length];
    }

    public boolean isValid(int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
    }

    public int countCells(int r, int c) {
        if (isValid(r, c) && !visited[r][c]) {

            if (matrix[r][c] == '@'){
                visited[r][c] = true;
                return 1 + countCells(r-1, c) + countCells(r+1, c) + countCells(r, c+1) + countCells(r, c-1);
            }

        }
        return 0;
    }


    /*
     *this method will return all values in the matrix
     *this method should return a view of the matrix
     *that looks like a matrix
     */
    public String toString() {
        String output = "";
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                output += matrix[r][c] + " ";
            }
            output += "\n";
        }
        return output;
    }
}

class CellCounterRunner {
    public static void main(String args[]) {
        //instantiate an AtCounter
        CellCounter c = new CellCounter();
        System.out.println(c);
        //test the code
        System.out.println("0 0 has " + c.countCells(0, 0) + " @s connected.");
        System.out.println("2 5 has " + c.countCells(2, 5) + " @s connected.");
        System.out.println("5 0 has " + c.countCells(5, 0) + " @s connected.");
        System.out.println("9 9 has " + c.countCells(9, 9) + " @s connected.");
        System.out.println("3 9 has " + c.countCells(3, 9) + " @s connected.");
        System.out.println("0 8 has " + c.countCells(0, 8) + " @s connected.");

        //add more test cases
    }
}