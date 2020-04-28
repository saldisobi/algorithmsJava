package leetcode100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {

    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    PhoneNumberCombination() {

    }

    public List<String> getPhoneNumberCombination(String digit) {

        List<String> myList = new ArrayList<>();

        if (digit == null || digit.length() == 0) {
            return myList;
        }
        //  myList = getCombinations(digit, 0, "", myList);

        return myList;
    }

   /* private List<String> getCombinations(String digit, int index, String s, List<String> myList) {

        if(index==digit.length()){
            myList.add(s);

        }
        for (int i = 0; i < digit.length(); i++) {
            int numericCharacter  =  Character.getNumericValue(digit.charAt(i));



        }
    }*/


    public static void main(String args[]) {
        new PhoneNumberCombination().getPhoneNumberCombination("91");
    }
}
