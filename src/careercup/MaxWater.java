package careercup;

public class MaxWater {



    
    public int getMaxWater(int[] inputArray, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return inputArray[startIndex]*(startIndex-endIndex);
        } else {
            int max = Math.max(getMaxWater(inputArray, startIndex, endIndex - 1), getMaxWater(inputArray, startIndex + 1, endIndex));

            return max;
        }

    }

    public static void main(String args[]){
        System.out.print(new MaxWater().getMaxWater(new int[]{1,8,6,2,5,4,8,3,7},0,1)+"");
    }

}
