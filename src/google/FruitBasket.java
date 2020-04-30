package google;

import java.util.HashMap;

/**
 * 904. Fruit Into Baskets
 * <p>
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * <p>
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * <p>
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * <p>
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * <p>
 * What is the total amount of fruit you can collect with this procedure?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 * <p>
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 * <p>
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 * <p>
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 */
public class FruitBasket {


    public int getMaxFruitCount(int[] inputArray) {
        if (inputArray == null | inputArray.length < 1) {
            return -1;
        }

        int max = 1;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> fruitPositionMap = new HashMap<>();
        while (j < inputArray.length) {
            if (fruitPositionMap.size() <= 2) {
                fruitPositionMap.put(inputArray[j], j);
                j++;
            }
            int minIndex = Integer.MAX_VALUE;
            if (fruitPositionMap.size() > 2) {
                for (int values : fruitPositionMap.values()) {
                    minIndex = Math.min(minIndex, values);

                }
                fruitPositionMap.remove(inputArray[minIndex]);

                i = minIndex + 1;
            }

            max = Math.max(max, j - i);
        }

        return max;
    }


}
