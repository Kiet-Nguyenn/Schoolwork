import java.util.ArrayList;

public class Carcassonne {
    private Tile[][] board;
    private ArrayList<Tile> tileStack; //Add Generic Type Tile

    public Carcassonne(){
        board = new Tile[5][5];
        this.tileStack = testTiles1();
        //this.tilePool = randomTilePool(); //uncomment this line to test for a random set of tiles.
        board[2][2] = tileStack.remove(0);
        int placed  = placeTiles(2,2);
        System.out.println("placed tiles: " + (placed+1));
    }

    /** placeTiles()
     * This method recursively places tiles on the board starting from location [r][c].
     * From location [r][c], check all valid neighbors to determine if the first Tile tileStack can be placed in that location.
     * For each potential location, consider using canPlaceTile to determine if the tiles edges will match all adjacent values.
     * When a tile is placed on the board, it must be removed from the ArrayList tilePool.
     *
     * This method will return the number of tiles placed on the board. Consider using a sum variable where each recursive call
     * increases that sum. Each call should return the sum after making all recursive calls.
     * @param r
     * @param c
     * @return
     */
    public int placeTiles(int r, int c){
        int sum = 0;


        return sum;
    }

    /**
     * canPlaceTile() this method receives a parameter tile and the location [r][c] where it might be placed in the board.
     * The method will check the four valid neighbor elements in the array to determine if the tile can be placed at location [r][c].
     * When placing a tile
     *  1. All edges of the tile must match the corresponding edges of the valid neighbor tiles.
     *  2. Any edge may be placed next to a null element.
     *  3. Edges placed next to non-null elements (other tiles) must match values.
     *  E.G. A bottom edge "R" may only be placed next to a null element or a tile that has a top edge "R".
     *
     *  If the tile may be placed at [r][c] canPlaceTile() will return true, otherwise false.
     * @param tile, the tile that might be placed at position[r][c]
     * @param r
     * @param c
     * @return true if the tiles edges match the edges of all adjacent tiles.
     */
    public boolean canPlaceTile(Tile tile, int r, int c){
        int check = 0;
        //check above
        if(!isValid(r - 1, c) || board[r - 1][c].getDownEdge() == tile.getUpEdge()){
            check++;
        }
        //check right
        if(!isValid(r, c + 1) || board[r][c + 1].getLeftEdge() == tile.getRightEdge()){
            check++;
        }
        //check below
        if(!isValid(r + 1, c) || board[r + 1][c].getUpEdge() == tile.getDownEdge()){
            check++;
        }
        //check left
        if(!isValid(r, c - 1) || board[r][c - 1].getRightEdge() == tile.getLeftEdge()){
            check++;
        }

        return check == 4;
    }

    public Tile[][] getTiles(){
        return board;
    }

    public boolean isValid(int r, int c){
        return r >= 0 && r < board.length && c>= 0 && c < board[0].length;
    }

    public void display(){
        for(Tile[] row: board){
            for(Tile tile : row){
                System.out.printf("%5s",tile == null ? "[ ] " : "["+tile.getTileId()+"] ");
            }
            System.out.println();
        }
    }

    public ArrayList randomTilePool(){
        ArrayList<Tile> tilePool = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            tilePool.add(makeRandomTile());
        }
        return tilePool;
    }

    public Tile makeRandomTile(){
        char[] arr = new char[4];
        for(int i = 0 ; i < arr.length;i++) {
            double random = Math.random();
            if(random < .20)
                arr[i] = 'C';
            else if(random < .50)
                arr[i] = 'R';
            else
                arr[i] = 'F';
        }

        return new Tile(arr);
    }
    public ArrayList testTiles1(){
        ArrayList<Tile> tiles = new ArrayList<>();
        //     U   R   D   L
        tiles.add(new Tile(new char[]{'F','F','R','F'}));
        tiles.add(new Tile(new char[]{'R','R','R','R'}));
        tiles.add(new Tile(new char[]{'C','F','R','C'}));
        tiles.add(new Tile(new char[]{'C','C','F','R'}));
        tiles.add(new Tile(new char[]{'F','R','F','R'}));
        tiles.add(new Tile(new char[]{'F','R','R','R'}));
        tiles.add(new Tile(new char[]{'R','F','R','F'}));
        tiles.add(new Tile(new char[]{'F','F','F','F'}));
        tiles.add(new Tile(new char[]{'C','C','F','F'}));
        tiles.add(new Tile(new char[]{'C','C','C','C'}));
        tiles.add(new Tile(new char[]{'R','C','F','R'}));
        tiles.add(new Tile(new char[]{'F','R','F','R'}));
        tiles.add(new Tile(new char[]{'R','R','F','F'}));
        tiles.add(new Tile(new char[]{'R','R','R','R'}));
        tiles.add(new Tile(new char[]{'F','F','R','F'}));
        tiles.add(new Tile(new char[]{'F','R','R','F'}));
        tiles.add(new Tile(new char[]{'R','F','R','F'}));
        tiles.add(new Tile(new char[]{'R','F','R','F'}));
        tiles.add(new Tile(new char[]{'R','R','R','F'}));
        tiles.add(new Tile(new char[]{'R','F','F','R'}));
        tiles.add(new Tile(new char[]{'R','F','R','F'}));
        tiles.add(new Tile(new char[]{'R','F','C','F'}));
        tiles.add(new Tile(new char[]{'R','R','F','F'}));
        tiles.add(new Tile(new char[]{'C','C','C','C'}));
        tiles.add(new Tile(new char[]{'C','C','F','F'}));



        return tiles;
    }
}
