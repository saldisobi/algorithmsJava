package careercup;

public class IntToString {


    public int decodeNumber(String number) {

        int dp[] = new int[number.length() + 1];

        dp[0] = 1;
        dp[1] = number.charAt(0) == '0' ? 0 : 1;


        for (int i = 2; i <= number.length(); i++) {
            int first = Integer.parseInt(number.substring(i-1,i));
            int second  =  Integer.parseInt(number.substring(i-2,i));
            if(first>0){
                dp[i] = dp[i]+dp[i-1]+1;
            }

            if(second>9&&second<27){
                dp[i] = dp[i] +dp[i-2];
            }
        }

        return dp[number.length()];


    }


    public static void main(String args[]) {
        System.out.print(new IntToString().decodeNumber("128"));
    }
}
