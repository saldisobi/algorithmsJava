package backToBasics.dynamic;

public class DiceThrow {

    int countWays;
    int[][] lookupTable;

    DiceThrow(int sum, int diceCount, int faces) {
        lookupTable = new int[diceCount+1][sum+1];
        for (int i = 0; i < diceCount; i++) {
            for (int j = 0; j < sum; j++) {
                lookupTable[diceCount][sum] = -1;
            }
        }
    }

    private int getWaysToDiceSum(int sum, int diceCount, int faces) {

        if(diceCount<=0&&sum<=0){
            return 0 ;
        }
        if (sum > diceCount * faces || sum < diceCount) {
            return 0;
        }

        if (diceCount == 1) {
            return 1;
        }

        if (lookupTable[diceCount][sum] != -1)
            return lookupTable[diceCount][sum];



        for (int i = 1; i <= faces; i++) {

            countWays = countWays + getWaysToDiceSum(sum - i, diceCount--, faces);

            lookupTable[diceCount][sum] = countWays;

        }

        return countWays;
    }

    public static void main(String args[]) {
        System.out.println(new DiceThrow(5,5,6).getWaysToDiceSum(5, 5, 6));
    }
}
