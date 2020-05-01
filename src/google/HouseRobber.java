package google;

public class HouseRobber {


    public int rob(int[] nums) {
        int[] lookUpArray = new int[nums.length];
        lookUpArray[0] = nums[0];

        lookUpArray[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            lookUpArray[i] = Math.max(nums[i] + lookUpArray[i - 2], lookUpArray[i - 1]);
        }

        return lookUpArray[nums.length - 1];

    }


    public static void main(String args[]) {
        System.out.print(new HouseRobber().rob(new int[]{1, 3, 7, 9, 6, 4}));
    }
}
