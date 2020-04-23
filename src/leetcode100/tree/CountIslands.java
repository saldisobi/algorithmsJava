package leetcode100.tree;

public class CountIslands {


    public int getIslandCount(int[][] inputMatrix) {
        int isLandCount = 0;
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                if (inputMatrix[i][j] == 1) {
                    isLandCount++;
                    callBFS(inputMatrix, i, j);
                }
            }
        }

        return isLandCount;
    }


    private void callBFS(int[][] inputMatrix, int i, int j) {
        if (i < 0 || i > inputMatrix.length - 1 || j < 0 || j > inputMatrix[i].length - 1 || inputMatrix[i][j] == 0) {
            return;
        }

        inputMatrix[i][j] = 0;

        callBFS(inputMatrix, i + 1, j);
        callBFS(inputMatrix, i - 1, j);
        callBFS(inputMatrix, i, j + 1);
        callBFS(inputMatrix, i, j - 1);
    }


    public static void main(String args[]) {


        int[][] seaView = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        System.out.println(new CountIslands().getIslandCount(seaView));
    }
}
