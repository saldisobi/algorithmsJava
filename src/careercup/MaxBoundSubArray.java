package careercup;

public class MaxBoundSubArray {

    int[] dp;

    int counter = 0;
    int currentMax = 0;
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        dp = new int[A.length];
        if(A[0]>=L&&A[0]<=R){
            dp[0] =1;
            counter = 1;
            currentMax = A[0];
        }else{
            dp[0] = 0;
        }
        for(int i=1;i<A.length;i++){
            if(A[i]>=L&&A[i]<=R){
                if(dp[i-1]==1)
                    dp[i] =3;
                else if(dp[i-1]==3){
                    dp[i] = dp[i-1]+dp[i-2];
                }else if(dp[i-1]==3){
                    dp[i] = dp[i-1]+dp[i-2];
                }
                if(A[i]>currentMax)
                    currentMax = A[i];
            }else if(dp[i-1]>0&&A[i]<=R){
                dp[i] = dp[i-1]+1;
                if(A[i]>currentMax)
                    currentMax = A[i];
            }else{
                counter+=dp[i-1];
                dp[i] = 0;
                currentMax = 0;
            }
        }

        return counter;
    }


    public static void main(String args[]){


    }
}
