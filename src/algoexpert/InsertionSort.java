package algoexpert;

public class InsertionSort {

    public int[] insertionSort(int[] nums) {
        int i = 0;


        while (i <= nums.length) {
            int j = i - 1;
            while (j > 0) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                j--;
            }
            i++;
        }
        return nums;
    }

    public static void main(String args[]) {
        int[] nums = new InsertionSort().insertionSort(new int[]{3, 2, 4, 5, 1});
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
