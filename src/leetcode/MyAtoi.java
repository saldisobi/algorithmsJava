package leetcode;

public class MyAtoi {

    private int trim(String s) {
        char[] trimmedArray = s.toCharArray();

        boolean isNegative = false;

        Integer num = null;



        for (int i = 0; i < trimmedArray.length; i++) {

            if (trimmedArray[i] == ' ') {
                continue;

            } else if (trimmedArray[i] == '-') {
                if(num == null){
                    isNegative = true;
                }
            } else if (Character.isDigit(trimmedArray[i])) {
                if(num == null){
                    num =Integer.parseInt(String.valueOf(trimmedArray[i])) ;

                }else{

                    num = num *10 + Integer.parseInt(String.valueOf(trimmedArray[i]));

                    System.out.println("number id now "+num);

                    int temp   = isNegative?num*-1:num;
                    if(temp> 2147483647)
                        return Integer.MAX_VALUE;
                    if(temp < -2147483648)
                        return Integer.MIN_VALUE;

                }
            } else {
                return num==null?0:num;
            }
        }
       num  =  num==null?0:num; num = isNegative?num*-1:num;

        return isNegative?num*-1:num;

    }

    public static void main(String args[]){
        System.out.println(new MyAtoi().trim("-91283472332"));
    }
}
