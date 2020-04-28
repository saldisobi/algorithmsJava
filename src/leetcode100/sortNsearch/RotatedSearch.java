package leetcode100.sortNsearch;

public class RotatedSearch {


    int searchInRotatedMatrix(int[] input) {
        int pivot = getPivot(input, 0, input.length - 1);

        searchInRotatedMatrix(input,pivot);

        return pivot;
    }

    private void searchInRotatedMatrix(int[] input, int pivot) {
        int rightBoundary = pivot-1;

        int leftBoundary = pivot+1;


    }

    private int getPivot(int[] input, int left, int right) {
        if (left < right) {
            int midpoint = left + (right - left) / 2;

            if (input[midpoint] > input[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        return left;
    }

    public static void main(String ass[]) {
        System.out.print(new RotatedSearch().searchInRotatedMatrix(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
    }
}
