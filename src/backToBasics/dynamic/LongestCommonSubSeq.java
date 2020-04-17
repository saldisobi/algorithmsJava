package backToBasics.dynamic;

public class LongestCommonSubSeq {


    int[][] dpTable;

    String string1;

    String string2;

    public String getLongestSubSeq(String s1, String s2) {

        string1 = s1;
        string2 = s2;

        dpTable = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int currentMax = Math.max(Math.max(getValueForPosition(i - 1, j), getValueForPosition(i - 1, j - 1)), getValueForPosition(i, j - 1));
                if (s1.charAt(i) == s2.charAt(j)) {
                    dpTable[i][j] = currentMax + 1;
                } else {
                    dpTable[i][j] = currentMax;
                }
            }
        }

        getFromDpTable();

        return dpTable[s1.length() - 1][s2.length() - 1] + "";
    }


    private int getValueForPosition(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        return dpTable[i][j];
    }


    private void getFromDpTable() {

        for (int i = string1.length() - 1; i >= 0; i--) {
            for (int j = string2.length() - 1; j >= 0; j--) {
                if (getValueForPosition(i, j) > getValueForPosition(i - 1, j - 1) && getValueForPosition(i, j) > getValueForPosition(i - 1, j) &&
                        getValueForPosition(i, j) > getValueForPosition(i, j - 1)) {
                    System.out.println(string1.charAt(i));
                }
            }
        }
    }


    public static void main(String args[]) {
        System.out.println(new LongestCommonSubSeq().getLongestSubSeq("ABCDGH", "AEDFHR"));
    }
}

