package leetcode100.sortNsearch;

import java.util.Arrays;

public class SortColors {

    public int[] sortAdjacentColors(int[] input) {

        int start = 0;
        int end = input.length - 1;
        int current = 0;


        while (current <= end && start < end) {

            if (input[current] == 0) {
                input[current] = input[start];
                input[start] = 0;
                start++;
                current++;
            } else if (input[current] == 2) {
                input[current] = input[end];
                input[end] = 2;
                end--;
            } else {
                current++;
            }


        }

        return input;
    }


    public static void main(String args[]) {
        int[] sorted = new SortColors().sortAdjacentColors(new int[]{0, 2, 1, 1, 2, 0, 0});

        System.out.print(Arrays.toString(sorted));
    }
}
