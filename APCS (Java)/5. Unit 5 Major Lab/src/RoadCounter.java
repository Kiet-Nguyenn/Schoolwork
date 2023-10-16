public class RoadCounter {
    private Tile[][] tiles;
    private boolean[][] visited;

    public RoadCounter(){
        setTiles();
        visited = new boolean[5][5];

        System.out.println("Road length @ [1][4]: " + getRoadLength(1,4));
        System.out.println("Road length @ [0][0]: " + getRoadLength(0,0));
        System.out.println("Road length @ [4][0]: " + getRoadLength(4,0));
        System.out.println("Road length @ [4][4]: " + getRoadLength(4,4));

    }

    public int getRoadLength(int r, int c){
        int roadCount = 0;
        if (isValid(r, c) && !visited[r][c]) {
            visited[r][c] = true;
            if (tiles[r][c].getUpEdge() == 'R' || tiles[r][c].getRightEdge() == 'R' || tiles[r][c].getDownEdge() == 'R' || tiles[r][c].getLeftEdge() == 'R') {
                roadCount++;
                if (tiles[r][c].getUpEdge() == 'R') {
                    roadCount += getRoadLength(r - 1, c);
                }
                if (tiles[r][c].getRightEdge() == 'R') {
                    roadCount += getRoadLength(r, c + 1);
                }
                if (tiles[r][c].getDownEdge() == 'R') {
                    roadCount += getRoadLength(r + 1, c);
                }
                if (tiles[r][c].getLeftEdge() == 'R') {
                    roadCount += getRoadLength(r, c - 1);
                }
            }
        }
        return roadCount;
    }


    public boolean isValid(int r, int c){
        return r>=0 && r < tiles.length && c >= 0 && c < tiles[0].length;
    }

    public void setTiles(){
        tiles = new Tile[5][5];
        //     U   R   D   L
        tiles[0][0] = new Tile(new char[]{'F','R','F','F'});
        tiles[0][1] = new Tile(new char[]{'F','R','F','R'});
        tiles[0][2] = new Tile(new char[]{'F','R','F','R'});
        tiles[0][3] = new Tile(new char[]{'F','R','F','R'});
        tiles[0][4] = new Tile(new char[]{'F','F','F','R'});

        tiles[1][0] = new Tile(new char[]{'F','F','F','F'});
        tiles[1][1] = new Tile(new char[]{'F','F','F','F'});
        tiles[1][2] = new Tile(new char[]{'F','F','F','F'});
        tiles[1][3] = new Tile(new char[]{'F','F','F','F'});
        tiles[1][4] = new Tile(new char[]{'F','F','F','F'});

        tiles[2][0] = new Tile(new char[]{'F','R','R','F'});
        tiles[2][1] = new Tile(new char[]{'F','R','F','R'});
        tiles[2][2] = new Tile(new char[]{'F','F','R','R'});
        tiles[2][3] = new Tile(new char[]{'F','F','F','F'});
        tiles[2][4] = new Tile(new char[]{'F','F','R','F'});

        tiles[3][0] = new Tile(new char[]{'R','F','R','F'});
        tiles[3][1] = new Tile(new char[]{'F','F','F','F'});
        tiles[3][2] = new Tile(new char[]{'R','F','R','F'});
        tiles[3][3] = new Tile(new char[]{'F','F','F','F'});
        tiles[3][4] = new Tile(new char[]{'R','F','R','F'});

        tiles[4][0] = new Tile(new char[]{'R','F','R','F'});
        tiles[4][1] = new Tile(new char[]{'F','F','F','F'});
        tiles[4][2] = new Tile(new char[]{'R','F','R','F'});
        tiles[4][3] = new Tile(new char[]{'F','F','F','F'});
        tiles[4][4] = new Tile(new char[]{'R','F','R','F'});
    }



    public Tile[][] getTiles(){
        return tiles;
    }
}