package careercup;

import java.util.Iterator;

public class AscendingIterator implements Iterator<Integer> {

    int[] nums;

    int currentIndex = -1;

    AscendingIterator(int[] num1, int[] num2, int[] num3) {
        int size = num1.length + num2.length + num3.length;

        nums = new int[size];

        int i = 0, j = 0, k = 0, l = 0;

        while (i < num1.length || j < num2.length || k < num3.length) {

            int intOne, intTwo, intThree;
            intOne = intTwo = intThree = Integer.MAX_VALUE;
            if (i < num1.length)
                intOne = num1[i];
            if (j < num2.length)
                intTwo = num2[j];
            if (k < num3.length)
                intThree = num3[k];
            if (getMin(intOne, intTwo, intThree) == 0) {
                nums[l] = num1[i];
                l++;
                i++;
            } else if (getMin(intOne, intTwo, intThree) == 1) {
                nums[l] = num2[j];
                l++;
                j++;
            } else {
                nums[l] = num3[k];
                l++;
                k++;
            }
        }


    }

    private int getMin(int i, int i1, int i2) {

        if (i < i1 && i < i2)
            return 0;
        else if (i1 < i && i1 < i2)
            return 1;
        else
            return 2;
    }

    @Override
    public boolean hasNext() {
        return (currentIndex + 1) < nums.length;
    }

    @Override
    public Integer next() {
        currentIndex++;
        if (currentIndex < nums.length)
            return nums[currentIndex];
        else
            throw new IndexOutOfBoundsException("reached limit");
    }

    public static void main(String args[]) {
      AscendingIterator ascendingIterator =   new AscendingIterator(new int[]{1, 5, 7}, new int[]{2, 3, 10}, new int[]{4, 6, 9});
      while (ascendingIterator.hasNext()){
          System.out.print(ascendingIterator.next()+"");
      }


    }
}
