import java.util.*;

public class SeatingChart
{
	// instance variables
	private Student[][] chart;  // the seating chart
	int[][] distractionLevels;
	private Scanner keyboard;
	private int numRows;        // number of rows in chart
	private int numCols;        // number of columns in chart

    // default constructor
	public SeatingChart(int rows, int cols)
	{
		chart = new Student[rows][cols];
		distractionLevels = new int[rows][cols];
		keyboard = new Scanner(System.in);
		numRows = rows;
		numCols = cols;

        initChart(chart);
	}

    // another constructor
	public SeatingChart(Student[][] array2D)
	{
		chart = array2D;
		distractionLevels = new int[array2D.length][array2D[0].length];
		keyboard = new Scanner(System.in);
		numRows = chart.length;
		numCols = chart[0].length;
	}

	/*
	 * This method populates array2D with default
	 *   Student objects. A default Student, when
	 *   displayed, prints the word "vacant".
	 */
	public void initChart(Student[][] array2D)
	{
		for(int r=0; r < array2D.length; r++)
		{
			for(int c=0; c < array2D[r].length; c++)
			{
				array2D[r][c] = new Student();
			}
		}
	}

	/* This method displays the seating chart on the
	 *   console window.
	 */
	public void displayChart()
	{
		for(int r=0; r < chart.length; r++)
		{
			for(int c=0; c < chart[r].length; c++)
			{
				System.out.print("("+r+","+c+") " + chart[r][c]);
			}
			System.out.println();
		}
	}

	/** This method will return the student who is most distracted. You might also consider printing the chart of distraction levels.
	 *  Consider writing other methods to help implement different smaller tasks.
	 * @return
	 */
	public Student getMostDistractedStudent(){
		Student mostDistracted = chart[0][0];
		int mostX = 0;
		int mostY = 0;
		for(int r = 0; r < distractionLevels.length; r++){
			for(int c = 0; c < distractionLevels[r].length; c++){
				if(distractionLevels[r][c] > distractionLevels[mostX][mostY]){
					mostX = r;
					mostY = c;
				}
			}
		}
		mostDistracted = chart[mostX][mostY];
		return mostDistracted;

	}

	public void checkDistracted(Student[][] array2D, int r, int c){
		for(int row = r-1; row <= r+1; row++){
			for(int col = c-1; col <= c+1; col++){
				if(row >= 0 && col >= 0 && row < array2D.length && col < array2D[r].length){
					if(array2D[row][col].getDistractor()) {
						distractionLevels[r][c]++;
					}
				}
			}
		}
	}

	public void initDistracted(Student[][] array2D){
		for(int r = 0; r < array2D.length; r++){
			for(int c = 0; c < array2D[r].length; c++){
				checkDistracted(array2D,r,c);
			}
		}
	}

	public void displayDistracted(){
		for(int r = 0; r < distractionLevels.length; r++){
			for(int c = 0; c < distractionLevels[r].length; c++){
				System.out.print(distractionLevels[r][c] + " ");
			}
			System.out.println();
		}
	}

	/* This method adds a Student to the seating chart at
	 *   the specified location. If the specified location is
	 *   a valid location the Student is added to the chart
	 *   and the method returns true; otherwise the Student is
	 *   not added to the chart and the method returns false.
	 * @param student the Student to be added to the seating chart
	 * @param row the row location where Student should be added.
	 * @param col the column location where Student should be added.
	 */
	public boolean addStudent(Student student, int row, int col)
	{
		if(row < 4 && col < 5 && chart[row][col].getName().equalsIgnoreCase("vacant")){
			chart[row][col] = student;
			return true;
		}
		return false;
	}

	/*
	 *	This method swaps seats of two Students in the seating chart.
	 *  If both seat locations are valid the Students are swapped and
	 *     the method returns true; otherwise the Students are not
	 *     swapped and the method returns false.
	 * @ row1, col1 location of first student
	 * @ row2, col2 location of second student
	 */
	public boolean swapSeats(int row1, int col1, int row2, int col2)
	{
		if(row1 < 4 && col1 < 5 && row2 < 4 && col2 < 5 && !chart[row1][col2].getName().equalsIgnoreCase("vacant") && !chart[row2][col2].getName().equalsIgnoreCase("vacant")){
			Student temp = chart[row1][col1];
			chart[row1][col1] = chart[row2][col2];
			chart[row2][col2] = temp;
			return true;
		}
		return false;
	}
	/*
	 * This method creates a new 2D array of Students by
	 *   taking all the students from the seating chart and
	 *   placing them in the new chart at random locations. Any
	 *   seats not assigned to a student should be assigned
	 *   a default Student object which, when displayed, will
	 *   print the word "vacant".
	 *   @ return the new 2D array
	 */
	public Student[][] scrambleChart()
	{
		Student[][] scramble = new Student[4][5];
		int randomRow = (int) (Math.random() * 4);
		int randomCol = (int) (Math.random() * 5);

		for(int r = 0; r < chart.length; r++){
			for(int c = 0; c < chart[r].length; c++) {
				while (scramble[randomRow][randomCol] != null) {
					randomRow = (int) (Math.random() * 4);
					randomCol = (int) (Math.random() * 5);
				}
				scramble[randomRow][randomCol] = chart[r][c];
			}
		}
		for(int r = 0; r < scramble.length; r++){
			for(int c = 0; c < scramble[r].length; c++){
				if(scramble[r][c] == null){
					scramble[r][c] = new Student();
				}
			}
		}
	return scramble;
	}
}
