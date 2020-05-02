package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatDnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> seen = new HashMap<>();
        int i = 0;
        while (i + 10 < s.length()) {
            String sub = s.substring(i, i + 10);
            int currentCounter = seen.getOrDefault(sub, 0) + 1;
            if (currentCounter > 1) {
                result.add(sub);
                System.out.println(sub);
            }
            seen.put(sub, currentCounter);

            i++;
        }

        return result;
    }


    public static void main(String args[]) {
        new RepeatDnaSequence().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
