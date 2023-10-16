public class Player
{
    // instance variables
    private String playerName;
    private int ftm;
    private int fta;
    private int fgm2;
    private int fga2;
    private int fgm3;
    private int fga3;
    // constructors
    public Player(String playerName, int ftm, int fta,
                  int fgm2, int fga2, int fgm3, int fga3)
    {
        this.playerName = playerName;
        this.ftm = ftm;
        this.fta = fta;
        this.fgm2 = fgm2;
        this.fga2 = fga2;
        this.fgm3 = fgm3;
        this.fga3 = fga3;
    }
    // accessor methods
    public String getPlayerName(){
        return playerName;
    }
    public int getFtm(){
        return ftm;
    }
    public int getFta() {
        return fta;
    }
    public int getFgm2() {
        return fgm2;
    }
    public int getFga2() {
        return fga2;
    }
    public int getFgm3() {
        return fgm3;
    }
    public int getFga3() {
        return fga3;
    }
    // other methods
    public double getFTPercentage(){
        return ((double) ftm / fta) * 100;
    }
    public double getFG2Percentage(){
        return ((double) fgm2 / fga2) * 100;
    }
    public double getFG3Percentage(){
        return ((double) fgm3 / fga3) * 100;
    }
    public int getPointsScored(){
        return ftm + (fgm2 * 2) + (fgm3 * 3);
    }
}