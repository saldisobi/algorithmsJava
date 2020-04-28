package google;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {

    public int getNumberOfIslands(int[][] ints) {
        int counter = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] == 1) {
                    counter++;
                    callBfs(i, j, ints);
                }
            }
        }
        return counter;
    }

    private void callBfs(int i, int j, int[][] ints) {
        if (i < 0 || i > ints.length - 1 || j < 0 || j > ints[i].length - 1 || ints[i][j] == 0) {
            return;
        }

        ints[i][j] = 0;
        callBfs(i + 1, j, ints);
        callBfs(i - 1, j, ints);
        callBfs(i, j + 1, ints);
        callBfs(i, j - 1, ints);

    }


    public static void main(String args[]) {
        int[][] seaView = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        System.out.print(new NumberOfIslands().getNumberOfIslands(seaView));
    }
}
