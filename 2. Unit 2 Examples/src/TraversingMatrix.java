import java.util.Arrays;

public class TraversingMatrix {
    public static void main(String args[]){
        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9,}};

        //1. Row-Major
        //Starts at top left corner of the matrix[0][0] and iterates left to right
        System.out.println("ROW MAJOR: ");
        for(int r = 0; r< mat1.length; r++){
            for(int c = 0; c <mat1.length; c++){
                System.out.print(mat1[r][c] + " ");
            }
            System.out.println();
        }

        //2. Column-Major:
        //Starts at top left corner[0][0] and iterates top to bottom.
        System.out.println("\nColumn Major: ");
        for(int c = 0; c < mat1[0].length; c++){
            for(int r = 0; r < mat1.length; r++){
                System.out.print(mat1[r][c] + " ");
            }
            System.out.println();
        }

        //3. Enhanced for loop
        System.out.println("\nEnhanced for loop");
        for(int[] row : mat1){
            for(int num : row){
                System.out.print(num  + " ");
            }
            System.out.println();
        }

        /*4. Row-by-row array processing
             This traversal:
             1. Assumes we can call a method that receives a 1-d array as a parameter.
             2. Traverses the array using a regular for loop or enhanced for loop.
         */
        System.out.println("\nrow-by-row array processing: ");
        for(int r = 0; r < mat1.length; r++){
            int rowSum = getRowSum(mat1[r]);
            System.out.println("Sum of row " + r + ": " + rowSum);
        }

        //Using row-by-row 2/ nested enhance - print the sum at the end of each row of numbers
        System.out.println("\nNested Enhance / processing");
        for(int[] row : mat1){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println("-> " + getRowSum(row));
        }



    }

    public static int getRowSum(int[] row){
        int sum = 0;
        for(int i = 0; i< row.length; i++){
            sum += row[i];
        }
        return sum;
    }
}
