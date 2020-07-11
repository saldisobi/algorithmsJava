package algoexpert;

public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        int i = 0;
        int smallestIndex = 0;
        while (i < nums.length) {
            int j = i;
            smallestIndex = i;
            while (j < nums.length) {
                if (nums[j] < nums[smallestIndex]) {
                    smallestIndex = j;
                }
                j++;
            }
            int temp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = temp;
            i++;
        }

        return nums;
    }

    public static void main(String args[]) {
        int[] nums = new SelectionSort().selectionSort(new int[]{6, 2, 3, 1, 4, 5,});
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
