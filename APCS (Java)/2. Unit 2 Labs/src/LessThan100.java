import java.sql.SQLOutput;
import java.util.Scanner;

public class LessThan100 {
    public static void main(String args[]) {
        Scanner key = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int row = key.nextInt();
        key.nextLine();
        System.out.print("Enter columns: ");
        int col = key.nextInt();
        key.nextLine();

        int[][] matrix = new int[row][col];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                matrix[r][c] = (int) (Math.random() * 200) + 1;
            }
        }

        System.out.println("\nGenerated Matrix");
        for(int[] nums : matrix) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nNumbers Less Than 100");
        System.out.println("Row       Column");
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                if(matrix[r][c] < 100) {
                    System.out.println(" " + r + "          " + c);
                }
            }
        }

    }
}
