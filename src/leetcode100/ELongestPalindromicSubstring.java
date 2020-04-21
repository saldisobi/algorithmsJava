package leetcode100;

public class ELongestPalindromicSubstring {


    public String getLongestPalindromicSubString(String input) {
        int[] result = new int[input.length() * 2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            sb.append('#');
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = 1; //every string si 1 length palindrome
        }


        String newString = sb.toString();
        int currentMaxLength = 1;
        int currentMaxPos = 0;
        for (int i = 0; i < newString.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            while (j > 0 && k < result.length - 1) {
                if (newString.charAt(j) == newString.charAt(k)) {
                    result[i] = result[i] + 2;
                }
                j--;
                k++;
            }

            if (result[i] > currentMaxLength) {
                currentMaxLength = result[i];
                currentMaxPos = i;
            }
        }


        return sb.toString();
    }


    public static void main(String args[]) {
        System.out.println(new ELongestPalindromicSubstring().getLongestPalindromicSubString("cbbd"));
    }
}
