package phasetwo;

class Solution {
    private int i = 0;
    
    public String decodeString(String s) {
        return decodeStringRecursive(s);
    }
    
    private String decodeStringRecursive(String s) {
        String decoded = "";
        while (i < s.length() && s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {
                int n = 0;
                while (Character.isDigit(s.charAt(i))) {
                    n = 10 * n + s.charAt(i) - '0';
                    i++;
                }
                
                i++;
                String str = decodeStringRecursive(s);
                while (n > 0) {
                    decoded += str;
                    n--;
                }
            } else {
                decoded += s.charAt(i);
            }
            i++;
        }
        return decoded;
    }

    public static void main(String args[]) {

        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }
}