package backToBasics.dynamic;

public class ArrayPartition {

    public int[] getPartition(int[] inputArray) {
        int sum = 0;
        int[] result = new int[0];
        for (int i = 0; i < inputArray.length; i++) {
            sum = sum + inputArray[i];
        }

        if (sum % 2 != 0) {
            return result;
        }

        sum = sum / 2;

        boolean[][] lookUpTable = new boolean[inputArray.length + 1][sum + 1];

        for (int i = 0; i < inputArray.length; i++) {
            lookUpTable[i][0] = true; //sum = 0 is possible for not including anything
        }

        for (int i = 1; i < inputArray.length; i++) {
            for (int j = 1; j < sum; j++) {
                if (j < inputArray[i - 1]) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j] || lookUpTable[i - 1][j - inputArray[i]];
                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j - i];
                }
            }
        }


        return result;
    }

    public static void main(String args[]) {

        System.out.print(new ArrayPartition().getPartition(new int[]{1, 6, 11, 5}));
    }
}
