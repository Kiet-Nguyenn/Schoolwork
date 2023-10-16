public class MatrixRecursion {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println("Sum of array : " + getArraySum(nums, 0));
        System.out.println("Sum of matrix : " + getMatrixSum(1,2));
    }

    public static int getArraySum(int[] nums, int index){
        if(index == nums.length){
            return 0;
        }
        return nums[index] + getArraySum(nums,index + 1);
    }

    private static int[][] matrix = {{1,2,3,4}, {5,6,7,8} , {9,10,11,12}};
    private static boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    private static boolean isValid(int r, int c){
        return r>= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
    }

    public static int getMatrixSum(int r, int c){
        if(isValid(r,c) && !visited[r][c]){
            visited[r][c] = true;
            return matrix[r][c] + getMatrixSum(r-1,c) +  //Checks above
                                  getMatrixSum(r+1,c) +  //Checks below
                                  getMatrixSum(r,c+1) +  //Checks right
                                  getMatrixSum(r,c-1);   //Checks left
        }
        return 0;
    }
}
