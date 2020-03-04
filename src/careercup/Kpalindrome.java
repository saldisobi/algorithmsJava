package careercup;

public class Kpalindrome {

    private int errorMarginK = 0;

    private Boolean[][] resultMatrix;

    public boolean isKPalindrome(String palindromeString, int k, int startIndex, int endIndex) {

        if (resultMatrix == null)
            resultMatrix = new Boolean[palindromeString.length()][palindromeString.length()];


        if (startIndex <= endIndex) {

            if (resultMatrix[startIndex][endIndex] != null)
                return resultMatrix[startIndex][endIndex];


            if (palindromeString.charAt(startIndex) == palindromeString.charAt(endIndex)) {
                resultMatrix[startIndex][endIndex] = true;
                startIndex++;
                endIndex--;

                return isKPalindrome(palindromeString, k, startIndex, endIndex);

            } else {

                errorMarginK++;

                if (errorMarginK > k) {

                    return false;
                }

                return isKPalindrome(palindromeString, k, startIndex + 1, endIndex) || isKPalindrome(palindromeString, k, startIndex, endIndex - 1);
            }


        }

        return true;
    }


    public static void main(String args[]) {

        System.out.print(new Kpalindrome().isKPalindrome("qeeft89tfeeq", 3, 0, 11));
    }
}
