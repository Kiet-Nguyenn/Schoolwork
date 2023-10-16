import java.util.Scanner;

public class Transpose {
    public static void main(String args[]){
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
                matrix[r][c] = (int) (Math.random() * 201) - 100;
            }
        }

        System.out.println("\nOriginal Matrix");
        for(int[] rows : matrix){
            for(int num : rows){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nTranspose");
        for(int c = 0; c < matrix.length; c++){
            for(int r = 0; r < matrix.length; r++){
                System.out.print(matrix[r][c] + " " );
            }
            System.out.println();
        }
    }
}
