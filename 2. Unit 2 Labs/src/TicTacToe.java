import java.util.Scanner;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[3][3];
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		int index = 0;
		for(int r = 0; r < mat.length; r++){
			for(int c = 0; c < mat[r].length; c++){
				mat[r][c] = game.charAt(index);
				index++;
			}
		}



	}

	public String getWinner()
	{
		String across = "";
		for(int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[r].length; c++) {
				across += mat[r][c];
			}
			if(across.substring(0,1).equals(across.substring(1,2)) && across.substring(1,2).equals(across.substring(2,3))){
				return across.substring(0,1) + " wins horizontally!";
			}
			across = "";
		}

		String vert = "";
		for(int c = 0; c < mat[0].length; c++) {
			for (int r = 0; r < mat.length; r++) {
				vert += mat[r][c];
			}
			if(vert.substring(0,1).equals(vert.substring(1,2)) && vert.substring(1,2).equals(vert.substring(2,3))){
				return vert.substring(0,1) + " wins vertically!";
			}
			vert = "";
		}

		if((mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]) || (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0])){
			return mat[1][1] + " wins diagonally!";
		}











		return "cat's game - no winner!";
	}

	public String toString()
	{
		String output="";
		for(int r = 0; r < mat.length; r++){
			for(int c = 0; c < mat[r].length; c++){
				output += mat[r][c] + " ";
			}
			output += "\n";
		}
		output += getWinner();

		return output+"\n\n";
	}
}
