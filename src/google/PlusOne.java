package google;

import java.util.Arrays;

public class PlusOne {

    public int[] getPusOneArray(int[] ints) {
        return getPusOneArray(ints, ints.length - 1);
    }

    private int[] getPusOneArray(int[] ints, int index) {
        if (index == -1) {
            int[] tempArray = new int[ints.length + 1];
            tempArray[0] = 1;
            for (int i = 1; i < ints.length + 1; i++)
                tempArray[i] = ints[i - 1];
            return tempArray;
        }
        if (ints[index] == 9) {
            ints[index] = 0;
            return getPusOneArray(ints, index - 1);
        } else {
            ints[index] = ints[index] + 1;

            return ints;
        }
    }

    public static void main(String args[]){
        System.out.print(Arrays.toString(new PlusOne().getPusOneArray(new int[]{9,9,8})));
    }
}
