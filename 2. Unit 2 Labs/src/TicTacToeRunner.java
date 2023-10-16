import java.util.Scanner;

public class TicTacToeRunner
{
    public static void main( String args[] )
    {
        TicTacToe game = new TicTacToe("XXXOOXXOO");
        System.out.println(game);

        TicTacToe game2 = new TicTacToe("OXOOXOXOX");
        System.out.println(game2);

        TicTacToe game3 = new TicTacToe("OXOXXOXOO");
        System.out.println(game3);

        TicTacToe game4 = new TicTacToe("OXXOXOXOO");
        System.out.println(game4);

        TicTacToe game5 = new TicTacToe("XOXOOOXXO");
        System.out.println(game5);
    }
}