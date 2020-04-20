package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class AThreeSum {

    public List<List<Integer>> getZeroSumTriplet(int[] input) {

        List<List<Integer>> result = new ArrayList<>();
        mergeSort(input, 0, input.length - 1);


        int i = 0, j = 1, k = input.length - 1;
        int iCounter = 0;

        while ((j < k) || iCounter < input.length - 2) {
            if (j >= k) {
                iCounter++;
                k = input.length - 1 - iCounter;
                i = iCounter;
                j = iCounter + 1;
            }

            if (input[i] + input[j] == input[k]) {
                List<Integer> resultItem = new ArrayList<>();
                resultItem.add(input[i]);
                resultItem.add(input[j]);
                resultItem.add(input[k]);
                result.add(resultItem);
                i++;
                j++;
                k--;
            } else if (input[i] + input[j] < input[k]) {
                i++;
                j++;
            } else {
                k--;
            }


        }

        return result;

    }

    private void mergeSort(int[] input, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(input, left, mid);
            mergeSort(input, mid + 1, right);
            merge(input, left, mid, right);
        }

    }

    private void merge(int[] input, int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = input[left + i];
        }

        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = input[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;


        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j]) {
                input[k] = leftArray[i];
                i++;
            } else {
                input[k] = rightArray[j];
                j++;
            }
            k++;
        }


        while (i < leftLength) {
            input[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            input[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void main(String args[]) {
        System.out.println(new AThreeSum().getZeroSumTriplet(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
