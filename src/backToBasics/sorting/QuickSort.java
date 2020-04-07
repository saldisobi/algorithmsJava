package backToBasics.sorting;

public class QuickSort {

    private int[] mInputArray;

    QuickSort(int[] inputArray) {
        mInputArray = inputArray;
    }

    public void sort() {
        sort(0, mInputArray.length - 1);

        for (int i = 0; i < mInputArray.length - 1; i++) {
            System.out.println(mInputArray[i] + "");
        }
    }

    private void sort(int low, int hi) {
        System.out.println("low = "+low + " hi = " + hi);
        if (low < hi) {
            int part = partition(low, hi);
            System.out.println("low = "+low + " hi = " + hi+ " part = " + part);
            sort(low, part);
            sort(part + 1, hi);
        }
    }

    private int partition(int low, int hi) {


        int i = low;
        int j = hi;

        while (i < j) {

            while (mInputArray[i] < mInputArray[low]) {
                i++;
            }

            while (mInputArray[j] > mInputArray[low]) {
                j--;
            }

            swapInt(i, j);
        }
        swapInt(low, j);
        return j;
    }

    private void swapInt(int begIndex, int endIndex) {
       // System.out.println("swapping beg  = "+begIndex + " endIndex = " + endIndex);
        int temp = mInputArray[begIndex];
        mInputArray[begIndex] = mInputArray[endIndex];
        mInputArray[endIndex] = temp;

    }


    public static void main(String args[]) {
        new QuickSort(new int[]{12,11,13,5,8,6}).sort();
    }
}
