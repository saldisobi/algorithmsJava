package leetcode100.arraystring;

import java.util.HashSet;

public class BMatrixZeroes {

    public void setMatrixZeroes(int[][] inputMatrix){
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();

        for(int i = 0;i<inputMatrix.length;i++){
            for(int j = 0;j<inputMatrix[i].length;j++){
                if(inputMatrix[i][j]==0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }


        for(int i = 0;i<inputMatrix.length;i++){
            for(int j = 0;j<inputMatrix[i].length;j++){
                if(rowSet.contains(i)||columnSet.contains(j)){
                   inputMatrix[i][j] = 0;
                }
            }
        }
        for(int i = 0;i<inputMatrix.length;i++){
            System.out.println();
            for(int j = 0;j<inputMatrix[i].length;j++){

                   System.out.print(inputMatrix[i][j]);

            }
        }
    }


    public static void main(String args[]){
        int[][] inputMatrix = { {0, 2, 3}, {5, 5, 5}, {2, 4, 6}, {3, 5, 0} };
        new BMatrixZeroes().setMatrixZeroes(inputMatrix);
    }
}
