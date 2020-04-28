package leetcode100.sortNsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature
 */
public class MergeIntervals {

    public void merge(int[][] intervals) {

        List<List<Integer>> result = new ArrayList<>();

        int[] mergeTracker = new int[intervals.length]; //this will keep track whether we merge current row with its previous


        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
            }
        }

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][0] == intervals[i + 1][0]) {
                continue;
            }

            System.out.print(Arrays.toString(intervals[i]));
        }

        System.out.print(Arrays.toString(intervals[intervals.length - 1]));
    }


    public static void main(String args[]) {

        int[][] jsh = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new MergeIntervals().merge(jsh);
    }

}
