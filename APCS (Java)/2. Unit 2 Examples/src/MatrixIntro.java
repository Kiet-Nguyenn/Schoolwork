import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixIntro {
    public static void main(String args[]){
        /* A 2D array stores a 1D array for each element.
           2D Arrays are organized into rows and columns.
         */

        int[] arr = new int[5]; //10 array

        int[][]matrix = new int[3][2];
        //matrix is an array that stores int[] arrays.
        /* {0, 0} = matrix[0]
           {0, 0} = matrix[1]
           {0. 0} = matrix[2]
         */
        //1st row
        matrix[0][0] = 1; //matrix[row][col]
        matrix[0][1] = 2;
        //2nd row
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        //3rd row
        matrix[2][0] = 5;
        matrix[2][1] = 6;

        //Using toString to print matrix
        System.out.println(Arrays.toString(matrix));

        System.out.println();
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++){
                System.out.println(matrix[row][col] + " ");
            }
            System.out.println();
        }

        //enhanced for loop with matrix
        for(int [] nums: matrix){ //for each int array in matrix
            for(int num: nums){
                System.out.println(num + " ");
            }
            System.out.println();
        }

        for(int r = 0; r <matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                matrix[r][c] = 10;
            }
        }

        //initializer list to make 2d array
        int[][] matrix2 = {{1,2,3},
                           {4,5,6},
                           {7,8,9,10}};

    }
}
