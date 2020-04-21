package leetcode100.arraystring;

public class FIncreasingTripletSubSequence {

    public boolean isIncreasingSubSequence(int[] ints) {

        int firstMinimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;


        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < firstMinimum && ints[i] < secondMinimum) {
                firstMinimum = ints[i];
            } else if (ints[i] < secondMinimum) {
                secondMinimum = ints[i];
            } else {
                if (firstMinimum < Integer.MAX_VALUE && secondMinimum < Integer.MAX_VALUE)
                    return true;
            }
        }


        return false;


    }



    public static void main(String args[]){
        System.out.println(new FIncreasingTripletSubSequence().isIncreasingSubSequence(new int[]{3,2,3}));
    }
}
