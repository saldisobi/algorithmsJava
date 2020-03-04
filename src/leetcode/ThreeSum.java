package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            throw new RuntimeException("input must have at-least 3 numbers");

        List solutionTriplets = new ArrayList<List<Integer>>();

        mergeSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while ((j > k)) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList tempArray = new ArrayList();
                    tempArray.add(nums[i]);
                    tempArray.add(nums[j]);
                    tempArray.add(nums[j - 1]);
                    solutionTriplets.add(tempArray);
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }


        return solutionTriplets;
    }


    private void mergeSort(int[] nums, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int median = (startIndex + endIndex) / 2;
            mergeSort(nums, startIndex, median);
            mergeSort(nums, median + 1, endIndex);
            merge(nums, startIndex, median, endIndex);
        }
    }

    private void merge(int[] nums, int startIndex, int median, int endIndex) {

        int leftLength = median - startIndex + 1;
        int rightLength = endIndex - median;

        int[] leftArray = new int[leftLength];

        int[] righttArray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = nums[startIndex + i];
        }

        for (int j = 0; j < rightLength; j++) {
            righttArray[j] = nums[median + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = startIndex;

        while ((i < leftLength && j < rightLength)) {
            if (leftArray[i] < righttArray[j]) {
                nums[k] = leftArray[i];
                i++;
                k++;
            } else {
                nums[k] = righttArray[j];
                j++;
                k++;
            }
        }

        while ((i < leftLength)) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        while ((j < rightLength)) {
            nums[k] = righttArray[j];
            j++;
            k++;
        }


    }

    public static void main(String args[]) {

        int[] myArr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> myans = new ThreeSum().threeSum(myArr);

        for (int i = 0; i < myans.size() - 1; i++) {
            System.out.println();
            for (int j = 0; j < myans.get(i).size() - 1; j++) {
                System.out.print(myans.get(i).get(j) + "");
            }
        }


    }
}
