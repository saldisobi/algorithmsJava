package leetcode100.arraystring;

import java.util.HashSet;

public class DLongestSubStringWithoutRepeat {


    public String longestSubStringWithoutRepeat(String input) {
        int longestEndPosition = 0;
        int longestEndLength = 0;
        int setStartPosition = 0;
        HashSet<Character> myHashSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {

            if (!myHashSet.contains(input.charAt(i))) {
                myHashSet.add(input.charAt(i));
            } else {

                if (longestEndLength > myHashSet.size()) {
                    longestEndLength = myHashSet.size();
                    longestEndPosition = i;
                }

                myHashSet.clear();

            }
        }

        if (longestEndLength < myHashSet.size()) {
            longestEndLength = myHashSet.size();
            longestEndPosition = input.length()-1;
        }


        int start = longestEndPosition - longestEndLength;
        return input.substring(start, longestEndPosition);

    }


    public static void main(String args[]) {
        System.out.println(new DLongestSubStringWithoutRepeat().longestSubStringWithoutRepeat("pwwkew"));
    }

}
