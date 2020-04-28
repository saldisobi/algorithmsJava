package leetcode100.dp;

public class UniquePaths {


    public int getUniquePaths(int rows, int columns) {
        int[][] lookUpTable = new int[rows][columns];

        lookUpTable[rows - 1][columns - 1] = 0; //if you are already on finish point no new possible way certainly

        lookUpTable[rows - 1][columns - 2] = 1;
        lookUpTable[rows - 2][columns - 1] = 0;

        for(int i = 0;i<columns;i++){
            lookUpTable[rows-1][i] =1;
        }

        for(int i = 0;i<rows;i++){
            lookUpTable[i][columns-1] = 1;
        }


        for (int i = 1; i< rows; i++) {
            for (int j = 1; j <columns; j++) {
                lookUpTable[i][j] =lookUpTable[i-1][j]+lookUpTable[i][j-1];
            }
        }

        return lookUpTable[rows-1][columns-1];
    }


    public static void main(String args[]){
        new UniquePaths().getUniquePaths(3,7);
    }
}
