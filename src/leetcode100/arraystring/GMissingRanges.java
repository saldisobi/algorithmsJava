package leetcode100.arraystring;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GMissingRanges {

    public List<Pair<Integer, Integer>> getMissingRanges(int[] inputArray, int lowerBound, int upperBound) {

        List<Pair<Integer, Integer>> resultList = new ArrayList<>();
        int currentLowerBound = lowerBound;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] - currentLowerBound == 0) {
                currentLowerBound = inputArray[i];
                //exact range is present
            } else if (inputArray[i] - currentLowerBound == 1) {
                //it is continuation case
                currentLowerBound = inputArray[i];

            } else {
                resultList.add(new Pair<>(currentLowerBound + 1, inputArray[i] - 1));
                currentLowerBound = inputArray[i];
                //range missing
            }
        }

        if (inputArray[inputArray.length-1] < upperBound) {
            resultList.add(new Pair<>(currentLowerBound + 1, upperBound));
        }
        return resultList;

    }

    public static void main(String args[]) {
        new GMissingRanges().getMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
    }
}
