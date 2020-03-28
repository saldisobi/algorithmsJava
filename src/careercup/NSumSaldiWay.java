package careercup;

import java.util.ArrayList;

public class NSumSaldiWay {


    public void printNSumSaldiWay(int number) {
        int[] baseCase = new int[number];
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            baseCase[i] = 1;
        }

        result.add(baseCase);

        int currentSum = 2;

        int currentPointer = 0;

        int currentMultiplier = 1;

        while (currentPointer<number){

        }


    }
}
