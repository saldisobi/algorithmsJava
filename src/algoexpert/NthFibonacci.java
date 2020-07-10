package algoexpert;

public class NthFibonacci {

    public int getFibonacci(boolean recursive, int num) {
        if (recursive) {
            return getFibonacciRecursive(num);
        } else {
            return getFibonacciIterative(num);
        }
    }

    private int getFibonacciIterative(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            int counter = 3;
            int last = 1;
            int secondLast = 1;
            int current = 0;

            while (counter <= num) {
                current = last + secondLast;
                secondLast = last;
                last = current;
                counter++;
            }

            return current;
        }
    }

    private int getFibonacciRecursive(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            return getFibonacciRecursive(num - 1) + getFibonacciRecursive(num - 2);
        }
    }

    public static void main(String args[]) {
        System.out.println(new NthFibonacci().getFibonacci(true, 8));
        System.out.println(new NthFibonacci().getFibonacci(false, 9));
    }
}
