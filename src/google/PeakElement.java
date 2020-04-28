package google;

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

public class PeakElement {

    int getPeakElementIndex(int[] inputArray, int index) {
        while (getValueForIndex(inputArray, index) < getValueForIndex(inputArray, index - 1) && getValueForIndex(inputArray, index) < getValueForIndex(inputArray, index + 1)) {

            if (getValueForIndex(inputArray, index + 1) < getValueForIndex(inputArray, index - 1))

                return getPeakElementIndex(inputArray, index - 1);

            else
                return getValueForIndex(inputArray, index + 1);
        }

        return index;
    }


    int getValueForIndex(int[] inputArray, int index) {

        if (index < 0 || index > inputArray.length - 1) {
            return Integer.MIN_VALUE;
        } else {
            return inputArray[0];
        }

    }

    public static void main(String args[]){
        System.out.print(new PeakElement().getValueForIndex(new int[]{1,2,3,1},0));
    }
}
