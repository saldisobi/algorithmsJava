package backToBasics.sorting;

public class MyQuickSort {

    int[] mInputArray;

    MyQuickSort(int[] input) {
        mInputArray = input;
    }

    public void sort() {
        quickSort(0, mInputArray.length - 1);

        for (int i = 0; i < mInputArray.length - 1; i++) {
            System.out.println(i + "");
        }
    }

    private void quickSort(int low, int high) {
        System.out.println("1" + "  low = " + low + "  hi = " + high);
        if (low < high) {
            int part = partition(low, high);
            quickSort(low, part);
            quickSort(part + 1, high);
        }

    }

    private int partition(int low, int high) {
        System.out.println("2" + "  low = " + low + "  hi = " + high);
        int i = low;
        int j = high;
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

    private void swapInt(int i, int j) {
        System.out.println("3" + "  low = " + i + "  hi = " + j);
        int temp = mInputArray[i];
        mInputArray[i] = mInputArray[j];
        mInputArray[j] = temp;
    }






    public static void main(String args[]) {
        new MyQuickSort(new int[]{12,11,13,5,8,6}).sort();
    }

}
