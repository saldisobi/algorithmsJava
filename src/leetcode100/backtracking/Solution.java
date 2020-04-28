package leetcode100.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    /*
     * @param : A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] input) {
        List<List<Integer>> resultSet = new ArrayList<>();
        helper(input, new HashSet<>(), new ArrayList<>(), resultSet);

        return resultSet;
    }

    private void helper(int[] input, HashSet<Integer> used, List<Integer> cur, List<List<Integer>> resultSet) {
        if (input.length == used.size()) {
            resultSet.add(new ArrayList<Integer>(cur));
        }

        for (int i : input) {
            if (used.contains(i)) {
                continue;
            }

            used.add(i);
            cur.add(i);
            helper(input, used, cur, resultSet);
            used.remove(i);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String args[]) {
        new Solution().permute(new int[]{1, 2, 3}).forEach(
                list -> {
                    System.out.println();
                    list.forEach(item -> {
                        System.out.print(item);
                    });

                });
    }
}