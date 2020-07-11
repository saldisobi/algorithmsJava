package algoexpert;

import java.util.Arrays;

public class TwoArraySmallestDifference {

    public int getSmallestDifferenceTwoArrays(int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);
        int firstPointer = 0;
        int secondPointer = 0;
        int smallestDifference = Integer.MAX_VALUE;
        while (firstPointer < first.length  && secondPointer < second.length) {
            if (first[firstPointer] == second[secondPointer]) {
                return 0;
            } else if (first[firstPointer] < second[secondPointer]) {
                if (Math.abs(first[firstPointer] - second[secondPointer]) < smallestDifference) {
                    smallestDifference = Math.abs(first[firstPointer] - second[secondPointer]);
                }
                firstPointer++;
            } else {
                if (Math.abs(first[firstPointer] - second[secondPointer]) < smallestDifference) {
                    smallestDifference = Math.abs(first[firstPointer] - second[secondPointer]);
                }
                secondPointer++;
            }
        }

        return smallestDifference;
    }

    public static void main(String args[]) {
        System.out.println("smallest difference is " + new TwoArraySmallestDifference().getSmallestDifferenceTwoArrays(new int[]{12, 23, 14}, new int[]{153, 28, 32}));
    }


}
