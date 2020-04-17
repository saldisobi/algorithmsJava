package backToBasics.dynamic;

public class EditDistance {


    int[][] valueHolder;

    public int getEditDistance(String s1, String s2) {
        valueHolder = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    valueHolder[i][j] = 0;
                } else if (i == 0) {
                    valueHolder[i][j] = j;
                } else if (j == 0) {
                    valueHolder[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    valueHolder[i][j] = valueHolder[i - 1][j - 1];
                } else {
                    int minVal = Math.min(Math.min(valueHolder[i - 1][j - 1], valueHolder[i - 1][j]), valueHolder[i][j - 1]);
                    valueHolder[i][j] = minVal + 1;
                }
            }
        }


        return valueHolder[s1.length()][s2.length()];

    }


    public static void main(String args[]) {
        System.out.print(new EditDistance().getEditDistance("SAURABH", "RACHITA"));
    }

}
