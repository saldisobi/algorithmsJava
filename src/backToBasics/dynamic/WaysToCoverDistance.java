package backToBasics.dynamic;

public class WaysToCoverDistance {

    int[] mWays;

    public int getWays(int num) {

        mWays = new int[num];

        for (int i = 0; i < num; i++) {
            mWays[i] = -1;
        }
        buildLookUpTable(num);

        return mWays[num-1];


    }

    private int buildLookUpTable(int num) {
        if (num < 0)
            return 0;
        if (num == 0 || num == 1)
            return 1;
        if (mWays[num-1] != -1)
            return mWays[num-1];
        mWays[num-1] = buildLookUpTable(num - 1) + buildLookUpTable(num - 2) + buildLookUpTable(num - 3);

        return mWays[num-1];
    }

    public static void main(String args[]) {

        System.out.print(new WaysToCoverDistance().getWays(4));
    }
}
