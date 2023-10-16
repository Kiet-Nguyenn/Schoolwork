public class LinearSearch {
    public static void main(String[] args) {
        /* Searching algorithms are used to find a key value in a collection (Array, ArrayList)
           Linear search finds a value by starting at the first element, going until the end.

         */

        int[] nums = {1,2,3,4,5,6,7,8,9,7,6,5,4,6,4,5,65,6,56,546};

        System.out.println("contains 5: " + linearSearch1(nums, 5));
        System.out.println("contains -55: " + linearSearch1(nums, -55));

        String[] names = {"chad","swaggyD", "sickSteve", "RamGamerYeetYeet", "noCapGod5000", "L+RATIO+BOZO+NOT GAMING"};
    }

    //If nums contains key, return true, else return false.
    public static boolean linearSearch1(int[] nums, int key){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key){
                return true;
            }
        }
        return false;
    }

    //if nums has key, return index of key
    //else return -1
    public static int linearSearch2(int[] nums, int key){
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    //
    public static int stringSearch(String[] names, String key){
        for(int i = 0; i< names.length; i++){
            if(names[i].compareTo(key) == 0) {
                return i;
            }
            /* compares names[i] to key alphabetically.
               if names[i] comes first (less than) returns a negative value.
               if names[i] comes after (greater than) returns a positive.
               if they the same return 0
             */
        }
        return -1;
    }
}

/* Algo analysis
   We often refer to algorithms in terms of how efficiently they solve a problem.

   One of the ways we measure efficiency is Time Complexity.

   Big O notation is used to describe efficiency in algebraic terms. O( )

   Best case - the key is the first value. O(1)
   Worst case - either the key is at end or not in list. O(n) n represents the number of elements

   O(n) - linear time

   avg case - if list is random and looking for a random key, O(n/2)
 */