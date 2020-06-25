package google;

import java.util.HashMap;

public class ReOrganizeString {

    public String reorganizeString(String S) {

        HashMap<Character, Integer> charCountMapping = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            int count = charCountMapping.getOrDefault(S.charAt(i), 0);
            count++;
            if (count > max) {
                max = count;
            }
            charCountMapping.put(S.charAt(i), count);
        }

        if (max > S.length() / 2) {
            return "";
        } else {



            while (sb.length() < S.length()) {
                //while complete string is not formed, we need top keep on adding
                for (Character key : charCountMapping.keySet()) {
                    int counter = charCountMapping.get(key);

                    if (counter > 0) {
                        sb.append(key);
                        counter--;
                    }

                    if (counter == 0) {
                        charCountMapping.remove(key);
                    }
                }
            }

        }

        return sb.toString();


    }
}
