package careercup;

import java.util.HashMap;

class RomanToInteger {
    public int romanToInt(String s) {


        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int isSpecialCase = -1;
            if (i + 1 != s.length())
                isSpecialCase = isSpecialCase(s, i);
            if (isSpecialCase != -1) {
                sum = sum + isSpecialCase;
                i++;
            } else {
                sum = sum + romanToInt(s.charAt(i));
            }


        }

        return sum;
    }


    private int romanToInt(Character roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return -1;

    }

    private int isSpecialCase(String s, int i) {

        if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
            return 4;
        } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {

            return 9;

        } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {

            return 40;

        } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {

            return 90;

        } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {

            return 400;

        } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {

            return 900;

        }

        return -1;
    }


}