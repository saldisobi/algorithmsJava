package numbers;

public class Expo {
    public static long raiseToPower(double num1, int num2) {


        if (num2 < 1) {
            return raiseToPower(1 / num1, num2 * -1);
        } else if (num2 == 0) {
            return 1;
        } else if (num2 == 1) {
            return (long) num1;
        } else if (num2 % 2 == 0) {
            return raiseToPower(num1 * num1, num2 / 2);
        } else {
            return (long) (num1*raiseToPower(num1 * num1, (num2 - 1) / 2));
        }
    }


    public static void main(String[] args) {
        System.out.println(raiseToPower(7, 13) + "");
    }
}
