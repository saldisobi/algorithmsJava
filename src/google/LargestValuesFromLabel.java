package google;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 * <p>
 * Then, we choose a subset S of these items, such that:
 * <p>
 * |S| <= num_wanted
 * For every label L, the number of items in S with label L is <= use_limit.
 * Return the largest possible sum of the subset S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * Output: 9
 * Explanation: The subset chosen is the first, third, and fifth item.
 * Example 2:
 * <p>
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * Output: 12
 * Explanation: The subset chosen is the first, second, and third item.
 * Example 3:
 * <p>
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * Output: 16
 * Explanation: The subset chosen is the first and fourth item.
 * Example 4:
 * <p>
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * Output: 24
 * Explanation: The subset chosen is the first, second, and fourth item.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i] <= 20000
 * 1 <= num_wanted, use_limit <= values.length
 */
public class LargestValuesFromLabel {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        HashMap<Integer, Integer> valueLabelMap = new HashMap<>();

        HashMap<Integer, Integer> remainingLabelsMap = new HashMap<>();

        int numExhausted = 0;

        int sum = 0;


        PriorityQueue<Integer> maxHeap = new PriorityQueue(values.length, Collections.reverseOrder());


        for (int i = 0; i < values.length; i++) {
            valueLabelMap.put(values[i], labels[i]);
            maxHeap.add(values[i]);
            remainingLabelsMap.put(labels[i], use_limit);
        }

        while (numExhausted < num_wanted) {
            int largest = maxHeap.remove();
            int label = valueLabelMap.get(largest);
            if (remainingLabelsMap.get(label) > 0) {
                remainingLabelsMap.put(label, remainingLabelsMap.get(label) - 1);
                sum += largest;
                numExhausted++;
            }

        }
        return sum;

    }
}
