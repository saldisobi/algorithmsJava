package google;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        generateAllSubsets(0, nums, new ArrayList<Integer>(), subsets);

        return subsets;

    }

    private void generateAllSubsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateAllSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);

        }

    }

    public static void main(String args[]) {
        List<List<Integer>> result = new SubSets().subsets(new int[]{1, 2, 3});
        for (int i = 0; i < result.size(); i++) {
            System.out.println();
            for (int j = 0; j < result.get(i).size() - 1; j++) {

                System.out.print(result.get(i).get(j));
            }
        }
    }
}
