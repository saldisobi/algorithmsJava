package backToBasics.sorting;

public class MyMergeSort {


    private void mergeSort(int[] inputArray, int beg, int end) {

        if (beg < end) {
            int median = (beg + end) / 2;
            mergeSort(inputArray, beg, median);
            mergeSort(inputArray, median + 1, end);
            merge(inputArray, beg, median, end);
        }
    }

    private void merge(int[] inputArray, int beg, int median, int end) {

        int leftLength = median - beg + 1;
        int rightLength = end - median;
        int[] arrOne = new int[leftLength];
        int[] arrTwo = new int[rightLength];


        for (int i = 0; i <= leftLength; i++) {
            arrOne[0] = inputArray[beg + i];
        }
        for (int i = 0; i <= rightLength; i++) {
            arrTwo[0] = inputArray[median + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = beg;

        while (i < leftLength && j < rightLength) {
            if (arrOne[i] <= arrTwo[j]) {
                inputArray[k] = arrOne[i];
                i++;
            } else {
                inputArray[k] = arrTwo[j];
                j++;
            }

            k++;
        }

        while (i < leftLength) {
            inputArray[k] = arrOne[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            inputArray[k] = arrTwo[j];
            j++;
            k++;
        }
    }

}
