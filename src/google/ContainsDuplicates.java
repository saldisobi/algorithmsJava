package google;

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicates {

    public boolean containsDuplicate(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (!set.contains(input[i])) {
                set.add(input[i]);
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        System.out.print(new ContainsDuplicates().containsDuplicate(new int[]{1,1}));
    }
}
