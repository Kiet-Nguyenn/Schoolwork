import java.util.Scanner;

public class Minesweeper {
    private boolean[][] mineGrid;
    private int[][] numberGrid;
    private Scanner key;
    /** This constructor instantiates mineGrid and randomly assigns true to 10%
     * of cells.
     * @param rows
     * @param cols
     */
    public Minesweeper(int rows, int cols){
        key = new Scanner(System.in);
        mineGrid = new boolean[rows][cols];
        for(int r  = 0; r < mineGrid.length; r++){
            for(int c = 0; c < mineGrid[r].length; c++){
                if(Math.random() < .1){
                    mineGrid[r][c] = true;
                }
            }
        }
    }

    /** This method prints the mineGrid with a 1 for each cell containing a mine.
     * Empty cells should display 0.
     */
    private void printBooleanGrid(){
        System.out.println("Boolean Grid:");
        for(int r = 0; r < mineGrid.length; r++){
            for(int c = 0; c < mineGrid[r].length; c++){
                if(mineGrid[r][c]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    /** This method will determine the grid values indicating the number of mines and adjacent mines
     *  for each cell.
     *
     *  If the cell contains a mine, that cell should be set to 9.
     *  Cells not containing a mine should display the number of adjacent mines.
     * @return an integer matrix with int values for each cell.
     */
    private int[][] setNumberGrid(){
        numberGrid = new int[mineGrid.length][mineGrid[0].length];
        //reset grid
        for(int r = 0; r < mineGrid.length; r++){
            for(int c = 0; c < mineGrid[r].length; c++){
                numberGrid[r][c] = 0;
            }
        }
        //set mines from mine grid
        for(int r = 0; r < mineGrid.length; r++){
            for(int c = 0; c < mineGrid.length; c++){
                if(mineGrid[r][c]){
                    numberGrid[r][c] = 9;
                }
            }
        }
        //set numbers
        for(int r = 0; r < numberGrid.length; r++){
            for(int c = 0; c < numberGrid[r].length; c++){
                detectMines(r,c);
            }
        }
        return numberGrid;
    }

    public void printNumberGrid(){
        int[][] game = setNumberGrid();
        System.out.println("Number Grid: ");
        for(int r = 0; r < game.length; r++){
            for(int c = 0; c < game[r].length; c++){
                System.out.print(game[r][c] + " ");
            }
            System.out.println();
        }
    }

    private void detectMines(int r, int c){
        if(!mineGrid[r][c]){
            for (int row = r - 1; row <= r + 1; row++) {
                for (int col = c - 1; col <= c + 1; col++) {
                    if (inBounds(row, col)) {
                        if (mineGrid[row][col]) {
                            numberGrid[r][c]++;
                        }
                    }
                }
            }
        }
    }

    /** This method returns the total number of mines in the grid.
     */
    public int getMineCount(){
        int mines = 0;
        for(int r = 0; r < mineGrid.length; r++){
            for(int c = 0; c < mineGrid[r].length; c++){
                if(mineGrid[r][c]){
                    mines++;
                }
            }
        }
        return mines;
    }

    /** This method will return true when [row][col] is a valid location on the matrix.
     * @param row
     * @param col
     */
    private boolean inBounds(int row, int col){
        if(row >= 0 && col >= 0 && row < mineGrid.length && col < mineGrid[0].length){
            return true;
        }
        return false;
    }

    public void removeMines(){
        System.out.print("Remove Mine: \nEnter Row: ");
        int r = key.nextInt();
        key.nextLine();
        System.out.print("Enter Col: ");
        int c = key.nextInt();
        key.nextLine();
        //success
        if (inBounds(r, c)) {
            if (mineGrid[r][c]) {
                mineGrid[r][c] = false;
                System.out.println("Removed mine at location [" + r + "] [" + c + "]");
            } else {
                System.out.println("Invalid, no mine at location [" + r + "] [" + c + "]");
            }
        } else {
            System.out.println("Invalid, out of bounds.");
        }

    }


    public String toString(){
        String output = "\nNumber of Mines: " + getMineCount();
        printNumberGrid();
        return output;
    }

}

class MinesweeperTester {
    public static void main(String[] args) {
        Minesweeper test = new Minesweeper(10,10);
        while(test.getMineCount() > 0){
            System.out.println(test);
            test.removeMines();
            System.out.println();
        }
        System.out.println("All Mines Found!");
    }
}
