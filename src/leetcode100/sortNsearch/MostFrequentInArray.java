package leetcode100.sortNsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentInArray {

    List<Integer> getMostFrequentArray(int[] input, int num) {

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMapper = new HashMap<>();
        List<List<Integer>> resultSet = new ArrayList<>(input.length);
        for (int i = 0; i < input.length; i++) {

            int insertNum = frequencyMapper.getOrDefault(i, 0);

            frequencyMapper.put(i, insertNum);

            resultSet.add(new ArrayList<>());

        }





        for (Map.Entry<Integer, Integer> mapEntry : frequencyMapper.entrySet()) {

            int key = mapEntry.getKey();

            int val = mapEntry.getValue();
            List<Integer> results;
            if (resultSet.get(val) != null) {
                results = resultSet.get(val);
                results.add(key);
            } else {
                results = new ArrayList<>();
                results.add(key);
            }


            resultSet.add(val, results);
        }

        int currentCounter = 0;
        for (int i = input.length - 1; i > 0; i--) {

            if (resultSet.get(i) != null) {
                result.addAll(i,resultSet.get(i));
            }

            currentCounter = currentCounter + result.size();

            if (currentCounter >= num)
                break;
        }

        return result;
    }

    public static void main(String args[]) {
        List<Integer> mostFreq = new ArrayList<>();

        mostFreq = new MostFrequentInArray().getMostFrequentArray(new int[]{1, 1, 2, 2, 3, 3, 3, 8, 8, 8, 8}, 2);

        mostFreq.forEach(it -> {
            System.out.print(it);
        });
    }
}
