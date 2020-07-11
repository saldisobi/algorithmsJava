package algoexpert;

public class PalindromeCheck {

    public boolean isPalindrome(String s) {

        int beg = 0;
        int end = s.length() - 1;
        while (beg <= end) {
            if (s.charAt(beg) == s.charAt(end)) {
                beg++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        System.out.println(new PalindromeCheck().isPalindrome("nitin"));
    }
}
