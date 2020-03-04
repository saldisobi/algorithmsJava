package linkedlist;

public class LongestPalindromicSubString {


    public String longestPalindrome(String s) {
        char[] inputArray = s.toCharArray();

        char[] modifiedArray = new char[inputArray.length * 2];

        int realCounter = 0;

        int maxCounter = 1;

        int maxCounterLeft = 0;

        int maxCounterRight = 0;

        for (int i = 0; i < inputArray.length; i++) {
            modifiedArray[realCounter] = inputArray[i];
            realCounter++;
            modifiedArray[realCounter] = '|';
            realCounter++;
        }


        for (int i = 0; i < modifiedArray.length; i++) {

            boolean isMatch = true;
            int counter = 0;
            int left = i;
            int right = i;
            while (left > 0 && right < modifiedArray.length - 1 && isMatch) {
                counter++;
                left--;
                right++;
                isMatch = modifiedArray[left] == modifiedArray[right];
            }

            if(counter>maxCounter){
                maxCounter = counter;
                maxCounterLeft = left;
                maxCounterRight =  right;
            }

        }

        System.out.println("left = "+maxCounterLeft + "right = "+maxCounterRight);

        for(int i = maxCounterLeft;i<maxCounterRight;i++){
            System.out.print(modifiedArray[i]);
        }

        return "";
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println( s.substring(start, end + 1));
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String args[]){
      new  LongestPalindromicSubString().longestPalindrome1("abba");

        new  LongestPalindromicSubString().longestPalindrome("abba");
    }
}