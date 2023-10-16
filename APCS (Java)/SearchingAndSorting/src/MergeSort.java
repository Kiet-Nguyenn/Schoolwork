import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1,9,2,8,3,7,4,6,5};
        System.out.println("Array before: " + Arrays.toString(nums));
        sort(nums, 0,nums.length - 1);
        System.out.println("Array after: " + Arrays.toString(nums));
    }

    public static void sort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int len1 = mid - start + 1;
        int len2 = end - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];
        for(int i = 0; i < len1; i++){
            left[i] = arr[start + i];
        }
        for(int i = 0; i < len2; i++){
            right[i] = arr[mid + 1 + i];
        }

        int i = 0; //left index
        int j = 0; //right index
        int k = start; //index of original
        while(i < len1 && j < len2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            } else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < len1){
            arr[k] = left[i];
            k++;
            i++;
        }
        while(j < len2){
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
