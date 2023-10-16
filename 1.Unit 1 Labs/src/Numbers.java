import java.util.*;

public class Numbers
{
    private int[] nums = new int[20];
    private int[] positives = new int[20];
    private int[] negatives = new int[20];
    private int p = 0;                      // logical size of positives array
    private int n = 0;                      // logical size of negatives array

    /** precondition: none
     *  postcondition: nums has been populated with random numbers
     *     in the range of -100 to 100.
     */
    public void populateNums()
    {
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random() * 200) - 100;
        }
    }

    /** precondition: none
     *  postcondition: positives has been populated with all the
     *     numbers in nums that were positive. The variable p has
     *     has been updated to reflect the logical size of
     *     positives array.
     */
    public void populatePositives()
    {
        for(int i  = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                positives[p] = nums[i];
                p++;
            }
        }
    }

    /** precondition: none
     *  postcondition: negatives has been populated with all the
     *     numbers in nums that were negative. The variable n has
     *     has been updated to reflect the logical size of
     *     negatives array.
     */
    public void populateNegatives()
    {
        for(int i = 0; i < nums.length; i++){
            if (nums[i] < 0) {

                negatives[n] = nums[i];
                n++;
            }
        }
    }

    /** precondition: size >=0
     *  postcondition: all the values of array have been printed 
     *     from index 0 to the logical size of the array.
     *  @param array the array to be printed.
     *  @param size the logical size of array
     */
    public String print(int[] array, int size)
    {
        String list = "";
        for(int i = 0; i < size; i++) {
            list += array[i] + " ";
        }
        return list;
    }

    /** precondition: none
     *  postcondition: all three arrays have been printed with 
     *     appropriate labelling.
     */
    public String toString()
    {
        return "Random Numbers = 20" +
                "\n======================\n" +
                print(nums, 20) +
                "\nPositive Numbers = " + p +
                "\n======================\n" +
                print(positives, p) +
                "\nNegative Numbers = " + n +
                "\n======================\n" +
                print(negatives, n);


    }

    public static void main(String[] args)
    {
        Numbers app = new Numbers();
        app.populateNums();
        app.populatePositives();
        app.populateNegatives();
        System.out.println(app);
    }
}