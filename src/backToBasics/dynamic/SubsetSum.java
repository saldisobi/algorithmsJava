package backToBasics.dynamic;

public class SubsetSum {

    boolean[][] lookUpTable;

    public boolean isSubsetSum(int[] inputArray, int sum) {
        lookUpTable = new boolean[inputArray.length + 1][sum + 1];

        for (int j = 0; j < inputArray.length; j++) {
            lookUpTable[j][0] = true;
        }

        for (int i = 1; i <= inputArray.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (inputArray[i - 1] >= 0) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j] || lookUpTable[i - 1][j - inputArray[i - 1]];
                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j];
                }
            }

        }


        return lookUpTable[inputArray.length][sum];
    }

    public static void main(String args[]) {
        System.out.println(new SubsetSum().isSubsetSum(new int[]{1, 2, 3}, 0));
    }
}
