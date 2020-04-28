package leetcode100.sortNsearch;

import javafx.util.Pair;

public class SearchRange {

    Pair<Integer, Integer> getRange(int[] input, int target) {

        return getRange(input, target, 0, input.length - 1);
    }

    private Pair<Integer, Integer> getRange(int[] input, int target, int i, int i1) {

        int median = (i + i1) / 2;

        if (i == i1) {
            return new Pair<>(i, -i + 1);
        } else if (input[median] < target) {
            return getRange(input, target, i, median);
        } else if (input[median] > target) {
            return getRange(input, target, median + 1, i1);
        }

        return new Pair<>(-1, -1);
    }

    public static void main(String srgs[]) {
        Pair<Integer, Integer> res = new SearchRange().getRange(new int[]{0, 1, 2, 3, 3, 4}, 3);
        System.out.print(res.getKey());
    }
}
