package google;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }

        else if(strs.length<2){
            return strs[0];
        }

        int currentCounter = 1;
        String comparable1 = strs[0];

        while (currentCounter < strs.length ) {
            comparable1 = getLongestCommonPrefix(comparable1, strs[currentCounter]);
            System.out.print("after "+currentCounter+" comparisons "+" comparable1 "+comparable1);
            currentCounter++;
        }

        return comparable1;
    }

    public String getLongestCommonPrefix(String s1, String s2) {
        int i = 0;
        boolean isValidMatch = true;
        while (i < s1.length() && i < s2.length() && isValidMatch) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                isValidMatch = false;
                return s1.substring(0, i);
            }
        }


        if (s1.length() < s2.length())
            return s1;

        return s2;
    }


    public static void main(String args[]){
        System.out.print(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}