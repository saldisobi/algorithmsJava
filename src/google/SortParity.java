package google;

import java.util.Arrays;

public class SortParity {

    public int[] sortParity(int[] input) {

        int i = 0;
        int j = input.length - 1;

        while (i <= j) {
            if (input[i] % 2 == 0 && input[j] % 2 != 0) {
                i++;
                j--;
            } else if (input[i] % 2 == 0 && input[j] % 2 == 0) {
                i++;
            } else if (input[i] % 2 != 0 && input[j] % 2 != 0) {
                j--;
            } else if (input[i] % 2 != 0 && input[j] % 2 == 0) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }


        return input;
    }

    public static void main(String args[]){
        System.out.print(Arrays.toString(new SortParity().sortParity(new int[]{3,1,2,4})));
    }
}
