package google;

public class ReverseInteger {

    public int reverse(int x) {

        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = x * (-1);
        }

        int reversed = 0;

        while (x > 0) {
            reversed = (reversed * 10) + x % 10;
            x /= 10;
        }
        if (isNegative)
            reversed = reversed * (-1);
        return reversed;
    }

    public static void main(String args[]){
        System.out.print(new ReverseInteger().reverse(1234));
    }
}
