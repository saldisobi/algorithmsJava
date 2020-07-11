package algoexpert;

public class MoveElementsToEnd {

    public int[] moveElementToRnd(int[] input, int num) {
        int currentPointer = 0;
        int endPointer = input.length-1;
        while (currentPointer <= endPointer) {
            if (input[currentPointer] == num) {
                if (input[endPointer] == num) {
                    endPointer--;
                } else {
                    int temp = input[currentPointer];
                    input[currentPointer] = input[endPointer];
                    input[endPointer] = temp;
                    currentPointer++;
                }

            } else {
                currentPointer++;
            }
        }

        return input;
    }

    public static void main(String args[]) {
        int[] res = new MoveElementsToEnd().moveElementToRnd(new int[]{2, 1, 2, 2, 2, 3, 4, 2}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
