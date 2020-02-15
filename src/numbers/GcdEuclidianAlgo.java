package numbers;


public class GcdEuclidianAlgo {

    public static int getGcd(int numOne, int numTwo) {
        if (numTwo == 0)
            return numOne;
        int rem = numOne % numTwo;
        return getGcd(numTwo, rem);
    }

    public static void main(String[] args) {
        System.out.println(getGcd(60, 24) + "");
    }
}


