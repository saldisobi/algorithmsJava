package algoexpert;

public class BinarySearch {

    public int search(int[] nums, int searchkey) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int median = (start + end) / 2;
            if (nums[median] == searchkey) {
                return median;
            } else if (nums[median] < searchkey) {
                start = median + 1;
            } else {
                end = median - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9));
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 12));
    }
}
