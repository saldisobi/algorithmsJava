package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Leetcode 1055: Shortest Way to Form String
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.
 * <p>
 * Example 1:
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * Example 2:
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
 * Example 3:
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 */
public class ShortestWayToString {


    public int shortestWay(String source, String target) {
        int result = 1;
        HashSet<Character> sourceSet = new HashSet<>();


        for (int i = 0; i < source.length(); i++) {
            sourceSet.add(source.charAt(i));
        }

        int i = 0;

        int j = 0;

        boolean isFound;

        while (j < target.length() - 1) {
            char targetCurrentChar = target.charAt(j);
            isFound = false;

            if (!sourceSet.contains(targetCurrentChar)) {
                return -1;
            }

            for (int index = i; index < source.length(); index++) {
                if (source.charAt(index) == targetCurrentChar) {
                    i = index;
                    j++;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                i = 0;
                result++;
            }


        }

        return result;
    }


    public static void main(String args[]) {
        System.out.print(new ShortestWayToString().shortestWay("abc", "acbdcbc"));
    }
}
