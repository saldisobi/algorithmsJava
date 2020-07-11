package algoexpert;

public class BubbleSort {

    public int[] bubbleSort(int[] nums) {

        boolean iterationRequired = true;

        int index = 1;
        while (iterationRequired) {
            System.out.println("iteration happened");
            iterationRequired = false;
            index = 1;
            while (index < nums.length) {
                if (nums[index] < nums[index - 1]) {
                    int temp = nums[index];
                    nums[index] = nums[index - 1];
                    nums[index - 1] = temp;
                    iterationRequired = true;
                }

                index++;
            }
        }


        return nums;
    }

    public static void main(String args[]){
        int[] num = new BubbleSort().bubbleSort(new int[]{1,3,4,8,2,9,8,4,2});
        for(int i =0;i<num.length;i++){
            System.out.println(num[i]);
        }
    }
}
