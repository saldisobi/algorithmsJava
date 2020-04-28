package leetcode100.sortNsearch;

/**
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Note:
 * <p>
 * Your solution should be in logarithmic complexity.
 */
public class FindPeak {

    public int getPeakIndex(int[] input) {
        int median = input.length / 2;
        return getPeakIndex(input, median);
    }

    private int getPeakIndex(int[] input, int median) {
        if (getValueForPosition(input, median) > getValueForPosition(input, median + 1) && getValueForPosition(input, median) > getValueForPosition(input, median - 1)) {
            return median;
        } else {
            if (getValueForPosition(input, median + 1) > getValueForPosition(input, median - 1)) {

                return getPeakIndex(input, median + 1);

            } else {
                return getPeakIndex(input, median - 1);
            }
        }
    }


    public int getValueForPosition(int[] input, int pos) {

        if (pos < 0 || pos > input.length - 1) {
            return Integer.MIN_VALUE;
        } else {
            return input[pos];
        }
    }


    public static void main(String args[]) {
        System.out.print(new FindPeak().getPeakIndex(new int[]{0, 1, 2, 5}));
    }
}
