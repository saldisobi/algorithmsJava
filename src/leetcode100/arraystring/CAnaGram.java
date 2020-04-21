package leetcode100.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CAnaGram {


    public List<List<String>> getAnaGramGroup(String[] input) {
        HashMap<Integer, List<String>> myMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int hashCode = getHashCode(input[i]);
            List<String> myList = myMap.getOrDefault(hashCode, new ArrayList<String>());
            myList.add(input[i]);
            myMap.put(hashCode, myList);
        }

        myMap.values().forEach(value -> {
            result.add(value);
        });
        return result;
    }

    public int getHashCode(String input) {
        int hashCode = 0;
        for (int i = 0; i < input.length(); i++) {
            hashCode = hashCode + (int) input.charAt(i);
        }

        return hashCode;
    }

    public static void main(String args[]) {
        System.out.println(new CAnaGram().getAnaGramGroup(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
