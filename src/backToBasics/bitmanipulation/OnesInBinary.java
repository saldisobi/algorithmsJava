package backToBasics.bitmanipulation;

public class OnesInBinary {

    public int getOnesInBinary(int num) {
        int sum = 0;

        while (num > 0) {
            sum = sum + (num & 1);
            num >>= 1;

            System.out.println("new no = "+num);
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.println(new OnesInBinary().getOnesInBinary(6));
    }
}
