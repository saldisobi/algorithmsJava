package backToBasics.dynamic;

public class MaxGameStrategy {

    int[][] lookUpTable;

    public int getMaxEarnings(int[] input) {

        lookUpTable = new int[input.length][input.length];
        int groupSize, i, j, x, y, z;
        //important notes before we begin
        //1) here group size means how many elements are we considering each time
        //2 ) to calculate current position we need (i+2,j) , (i+1,j-1) , (i,j-2)
        //  for clarity try a nxn matrix you would see these are actually diagonal elements
        // so we fill it diagonally, to get element I need previous diagonal filled
        //lets now fill diagonal

        for (groupSize = 0; groupSize < input.length; groupSize++) {
            for (i = 0, j = groupSize; j < input.length; i++, j++) {
                x = ((i + 2) <= j) ? lookUpTable[i + 2][j] : 0;
                y = ((i + 1) <= j - 1) ? lookUpTable[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? lookUpTable[i][j - 2] : 0;
                int val = Math.max(input[i] + Math.min(x, y),
                        input[j] + Math.min(y, z));
                lookUpTable[i][j] = val;

                System.out.println("printing value for (" + i + " , " + j +") = "+ val);
            }
        }

        return lookUpTable[0][input.length - 1];
    }


    public static void main(String args[]) {
        System.out.println(new MaxGameStrategy().getMaxEarnings(new int[]{8, 15, 3, 7}));
    }
}
