package backToBasics.dynamic;

public class LongestIncreasingSubsequence {

    // {

    int[] longestSubSeqArray;

    public String getLongestIncreasingSubsequence(int[] input) {
        longestSubSeqArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            longestSubSeqArray[i] = 1;
        }


        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (input[j] < input[i]) {
                    longestSubSeqArray[i] = Math.max(longestSubSeqArray[j] + 1, longestSubSeqArray[i]);
                }
            }
        }

        System.out.println(longestSubSeqArray[input.length-1]);



        return "";
    }


    public static void main(String args[]){
        new LongestIncreasingSubsequence().getLongestIncreasingSubsequence(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80});
    }
}
