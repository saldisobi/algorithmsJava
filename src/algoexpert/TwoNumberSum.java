package algoexpert;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {

    public Pair<Integer, Integer> solveUsingHashSet(int[] nums, int target) {

        HashSet<Integer> alreadySeen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (alreadySeen.contains(target - nums[i])) {
                return new Pair<>(nums[i], target - nums[i]);
            } else {
                alreadySeen.add(nums[i]);
            }
        }

        return new Pair<>(0, 0);
    }

    public Pair<Integer, Integer> solveUsingSorting(int[] nums, int target) {

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i > j) {
            if ((nums[i] + nums[j]) > target) {
                i++;
            } else if ((nums[i] + nums[j]) > target) {
                j--;
            } else {
                return new Pair<>(nums[i], nums[j]);
            }
        }

        return new Pair<>(0, 0);
    }

    public static void main(String args[]) {
        Pair<Integer, Integer> result = new TwoNumberSum().solveUsingHashSet(new int[]{1, 2, 3, 4, 5}, 17);
        System.out.println(result.getKey().toString() + "  " + result.getValue().toString());

        Pair<Integer, Integer> resultSorting = new TwoNumberSum().solveUsingHashSet(new int[]{1, 2, 3, 4, 5}, 9);
        System.out.println(resultSorting.getKey().toString() + "  " + resultSorting.getValue().toString());
    }
}
