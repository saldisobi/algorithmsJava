package sorting;

import leetcode.ThreeSum;

import java.lang.reflect.Array;

public class MergeSort {

    public void mergeSort(int[] nums, int startIndex, int endIndex) {

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

        while ((i<leftLength)){
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        while ((j<rightLength)){
            nums[k] = righttArray[j];
            j++;
            k++;
        }


    }


    public static void main(String args[]) {

        int[] myArr = {-1, 0, 1, 2, -1, -4};

        new MergeSort().mergeSort(myArr, 0, myArr.length - 1);

        for(int i=0;i<myArr.length;i++){
            System.out.println(myArr[i]+"");
        }
    }
}
