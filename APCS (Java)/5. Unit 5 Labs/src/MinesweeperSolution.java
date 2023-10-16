import java.util.Scanner;

public class MinesweeperSolution {
    private boolean[][] mineGrid;
    private int[][] numberGrid;
    private String[][] stringGrid;


    /** This constructor instantiates mineGrid and randomly assigns true to 10%
     * of cells.
     * @param rows
     * @param cols
     */
    public MinesweeperSolution(int rows, int cols){
        mineGrid = new boolean[rows][cols];
        numberGrid = new int[rows][cols];
        stringGrid = new String[rows][cols];

        for(int r = 0; r < mineGrid.length; r++){
            for(int c = 0; c < mineGrid[0].length; c++){
                if(Math.random() < .10)
                    mineGrid[r][c] = true;
            }
        }
    }


    /** This method will return true when [row][col] is a valid location on the matrix.
     * @param row
     * @param col
     */
    private boolean inBounds(int row, int col){
        return row >= 0 && row < numberGrid.length && col >= 0 && col < numberGrid[0].length ;
    }


    /* Recursively reveal cells from [row][col]
        numberGrid is a matrix representing number of adjacent cells.
        stringGrid is a String matrix storing text representation of each cell.
        Unvisited cells are represented by null and print out as "[ ]"

        1. Reveal the cell at row, col by placing its value in stringGrid
            e.g. stringGrid[row][col] = "["+numberGrid[r][c]+"]";
        2. If numberGrid[r][c] == 0, make calls to all valid neighbors equal to null in stringGrid
     */
    public void revealCells(int row, int col){
        stringGrid[row][col] = "[" + numberGrid[row][col] + "]";

        if(numberGrid[row][col] == 0) {
            for(int r = row - 1; r <= row+1; r++){
                for(int c = col-1; c <= col+1; c++){
                    if(inBounds(r,c) && stringGrid[r][c] == null){
                            revealCells(r,c);
                    }
                }
            }
        }
    }





    //This method will be called to increment the number of adjacent mines in all cells surrounding a mine.
    private void addMines(int row, int col){
        for(int r = row-1; r <= row+1; r++){
            for(int c = col-1; c <= col+1; c++){
                if(inBounds(r,c) && numberGrid[r][c] != 9)
                    numberGrid[r][c]++;
            }
        }
    }



    /** This method will determine the grid values indicating the number of mines and adjacent mines
     *  for each cell.
     *
     *  If the cell contains a mine, that cell should be set to 9.
     *  Cells not containing a mine should display the number of adjacent mines.
     *
     */
    public void setNumberGrid(){
        for(int r = 0; r < mineGrid.length; r++) {
            for (int c = 0; c < mineGrid[0].length; c++) {
                if(mineGrid[r][c]) {
                    numberGrid[r][c] = 9;
                    addMines(r,c);
                }
            }
        }
    }

    /** This method returns the total number of mines in the grid.
     */
    public int getMineCount(){
        int count = 0;
        for(int r = 0; r < mineGrid.length; r++) {
            for (int c = 0; c < mineGrid[0].length; c++) {
                if(mineGrid[r][c]) count++;
            }
        }
        return count;
    }



    public String toString(){
        String output = "\nNumber Grid: \n";
        for(int[] nums : numberGrid){
            for(int n : nums){
                output += n + " ";
            }
            output += "\n";
        }

        output += "\nNumber Grid: \n";
        for(String[] str : stringGrid){
            for(String s : str){
                output += s == null ? "[ ]" : s;
            }
            output += "\n";
        }
        output += "\nNumber of Mines: " + getMineCount();
        return output;
    }

}

class MinesweeperSolutionTester {
    public static void main(String[] args) {
        MinesweeperSolution minesweeper = new MinesweeperSolution(10,10);
        minesweeper.setNumberGrid();
        Scanner key = new Scanner(System.in);
        while(minesweeper.getMineCount() > 0) {

            System.out.println(minesweeper);
            System.out.println("Remove mine: ");
            System.out.print("Enter row: ");
            int row = key.nextInt();
            System.out.print("Enter col: ");
            int col = key.nextInt();

            //minesweeper.removeMines(row,col);
            minesweeper.revealCells(row,col);
        }
    }
}