package google;

class EditPalindrome {
    public boolean validPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return true;
        }


        return validPalindrome(s, 0, s.length() - 1, 1);

    }

    private boolean validPalindrome(String s, int startPos, int endPos, int livesLeft) {
        if (startPos <= endPos) {
            if (s.charAt(startPos) == s.charAt(endPos)) {
                return validPalindrome(s, startPos + 1, endPos - 1, livesLeft);
            } else {
                if (livesLeft > 0) {
                    livesLeft--;
                    return validPalindrome(s, startPos, endPos - 1, livesLeft) && validPalindrome(s, startPos + 1, endPos, livesLeft);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}