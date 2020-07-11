package algoexpert;

public class ThreeLargestNumbersInArray {

    static class ThreeLargest {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
    }

    public ThreeLargest getThreeLargest(int[] nums) {
        if (nums.length < 3) throw new RuntimeException("Invalid input min three numbers required");

        ThreeLargest threeLargest = new ThreeLargest();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threeLargest.secondLargest) {
                if (nums[i] > threeLargest.largest) {
                    threeLargest.thirdLargest = threeLargest.secondLargest;
                    threeLargest.secondLargest = threeLargest.largest;
                    threeLargest.largest = nums[i];
                } else {
                    threeLargest.thirdLargest = threeLargest.secondLargest;
                    threeLargest.secondLargest = nums[i];
                }
            } else {
                if (nums[i] > threeLargest.thirdLargest) {
                    threeLargest.thirdLargest = nums[i];
                }
            }
        }
        return threeLargest;

    }

    public static void main(String args[]) {
        ThreeLargestNumbersInArray threeLargestNumbersInArray = new ThreeLargestNumbersInArray();
        ThreeLargest threeLargest = threeLargestNumbersInArray.getThreeLargest(new int[]{1, 1122, 3, 4, 5, 9, 12, 33, 45});
        System.out.println(threeLargest.largest);
        System.out.println(threeLargest.secondLargest);
        System.out.println(threeLargest.thirdLargest);
    }

}
