class Item {
    private String name;
    private int value;

    public Item(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}

public class ItemGrid {
    private Item[][] grid;

    public ItemGrid(Item[][] grid){
        this.grid = grid;
    }

    public boolean isValid(int xPos, int yPos){
        return xPos >= 0 && xPos < grid.length && yPos >=0 && yPos < grid[0].length;
    }

    /**Compares the item in row r and column c to the values to  its left and right.
     * returns the name of the item with the highest value.
     */
    public String mostValuableNeighbor(int r, int c){
        Item mostValuable = grid[r][c];
        if(isValid(r,c-1) && grid[r][c-1].getValue() > mostValuable.getValue()){
            mostValuable = grid[r][c-1];
        }
        if(isValid(r,c+1) && grid[r][c+1].getValue() > mostValuable.getValue()){
            mostValuable = grid[r][c+1];
        }
        return mostValuable.getName();
    }

    /** Returns the average value of items in the grid.
     *
     * @return
     */
    public double findAverage(){
        double sum = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                sum += grid[r][c].getValue();;
            }
        }
        return sum / (grid.length * grid[0].length);
    }
    public void printGrid(){
        for(Item[] row: grid){
            for(Item i : row){
                System.out.format("%12s",i.getName() +"-" + i .getValue());
            }
            System.out.println();
        }
    }


    public static void main(String args[]){

        Item[][] grid = {{new Item("Acorn", 7), new Item("Book", 10), new Item("Carrot", 8), new Item("Desk", 9) },
                {new Item("egg", 5), new Item("flag", 8), new Item("globe", 8), new Item("harp", 9)},
                {new Item("island", 7), new Item("jacket", 19), new Item("kale", 8), new Item("lunch", 16)},
        };

        ItemGrid app = new ItemGrid(grid);
        app.printGrid();
    }
}

