public class StoreLargest {
    public static void main(String args[]){
        int[][] mat1 = new int[4][4];
        int[][] mat2 = new int[4][4];
        int[][] largMat = new int[4][4];

        for(int r = 0; r < mat1.length; r++){
            for(int c = 0; c < mat1[r].length; c++){
                mat1[r][c] = (int) (Math.random() * 10);
            }
        }

        for(int r = 0; r < mat2.length; r++){
            for(int c = 0; c < mat2[r].length; c++){
                mat2[r][c] = (int) (Math.random() * 10);
            }
        }

        for(int r = 0; r < largMat.length; r++){
            for(int c = 0; c < largMat[r].length; c++){
                if(mat2[r][c] > mat1[r][c]){
                    largMat[r][c] = mat2[r][c];
                } else {
                    largMat[r][c] = mat1[r][c];
                }
            }
        }

        System.out.println("\nMatrix 1");
        for(int[] rows : mat1){
            for(int num : rows){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix 2");
        for(int[] rows : mat2){
            for(int num : rows){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nLargest Elements");
        for(int[] rows : largMat){
            for(int num : rows){
                System.out.print(num + " ");
            }
            System.out.println();
        }



    }
}
