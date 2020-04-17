package backToBasics.dynamic;

public class LongestDistanceInMatrix {

    int[][] lookUpTable;

    int result = Integer.MIN_VALUE;

    private int getLongestDistance(int[][] inputMatrix) {
        lookUpTable = new int[inputMatrix.length][inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                lookUpTable[i][j] = -1;
            }
        }
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                lookUpTable[i][j] = getLongestDistanceFromCell(inputMatrix, i, j);
                if (lookUpTable[i][j] > result) {
                    result = lookUpTable[i][j];
                }
            }
        }

        return result;
    }

    private int getLongestDistanceFromCell(int[][] inputMatrix, int i, int j) {
        System.out.println("call for" + inputMatrix[i][j]);
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;

        //covering base cases

        if (i < 0 || j < 0 || i > inputMatrix.length || j > inputMatrix[0].length) {
            return 0;
        }

        if (lookUpTable[i][j] != -1)
            return lookUpTable[i][j];

        if (i < inputMatrix.length - 1 && inputMatrix[i][j] + 1 == inputMatrix[i + 1][j]) {
            //bottom case
            bottom = lookUpTable[i][j] = getLongestDistanceFromCell(inputMatrix, (i + 1), j) + 1;
            System.out.println("longest distance from " + inputMatrix[i][j] + " is " + bottom);
        }
        if (i > 0 && inputMatrix[i][j] + 1 == inputMatrix[i - 1][j]) {
            //top case
            top = lookUpTable[i][j] = getLongestDistanceFromCell(inputMatrix, (i - 1), j) + 1;
            System.out.println("longest distance from " + inputMatrix[i][j] + " is " + top);
        }
        if (j > 0 && inputMatrix[i][j] + 1 == inputMatrix[i][j - 1]) {

            left = lookUpTable[i][j] = getLongestDistanceFromCell(inputMatrix, (i), j - 1) + 1;
            System.out.println("longest distance from " + inputMatrix[i][j] + " is " + left);
        }
        if (j < inputMatrix.length - 1 && inputMatrix[i][j] + 1 == inputMatrix[i][j + 1]) {
            right = lookUpTable[i][j] = getLongestDistanceFromCell(inputMatrix, i, j + 1) + 1;
            System.out.println("longest distance from " + inputMatrix[i][j] + " is " + right);

        }


        return Math.max(left, Math.max(right, Math.max(top, Math.max(bottom, 1))));
    }

    public static void main(String args[]) {
        System.out.println("Length of the longest path is " + new LongestDistanceInMatrix().getLongestDistance(new int[][]{{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}}));
    }
}
