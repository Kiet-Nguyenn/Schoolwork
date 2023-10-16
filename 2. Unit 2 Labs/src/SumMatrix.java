import java.util.Scanner;

public class SumMatrix {
    public static void main(String args[]){
        SumMatrix app = new SumMatrix();
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
                matrix[r][c] = (int) (Math.random() * 10);
            }
        }

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println("   " + app.sumRow(matrix[r]));
        }

        for(int i = 0; i < matrix[0].length; i++){
            System.out.print(app.sumCol(matrix, i) + " ");
        }
    }

    public int sumRow(int[] row){
        int sum = 0;
        for(int i = 0; i< row.length; i++){
            sum += row[i];
        }
        return sum;
    }

    public int sumCol(int[][] matrix, int col){
        int sum = 0;
        for(int row = 0; row < matrix.length; row++){
            sum += matrix[row][col];
        }
        return sum;
    }
}
