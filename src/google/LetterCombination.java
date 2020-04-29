package google;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE 17
 */
public class LetterCombination {
    String[] letterCharMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        generateAllCombinations(digits, "", result, 0);

        return result;
    }

    private void generateAllCombinations(String digits, String current, List<String> result, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        } else {
            String letters =  letterCharMap[Character.getNumericValue(digits.charAt(index))];
            System.out.print(letters);
            for (int j = 0; j < letterCharMap[Character.getNumericValue(digits.charAt(index))].length(); j++) {
                generateAllCombinations(digits,   current + letterCharMap[Character.getNumericValue(digits.charAt(index))].charAt(j), result, index + 1);

            }
        }
    }


    public static void main(String args[]) {
        new LetterCombination().letterCombinations("23");
    }
}
