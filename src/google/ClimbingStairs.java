package google;

public class ClimbingStairs {

    public int getUniqueWays(int stepsCount){
        int[] lookUpArray = new int[stepsCount];

        lookUpArray[0] = 1;

        lookUpArray[1] = 2;


        for(int i =2;i<stepsCount;i++){
            lookUpArray[i] = lookUpArray[i-1]+lookUpArray[i-2];
        }

        return lookUpArray[stepsCount-1];
    }

    public static void main(String args[]){

    System.out.println(new ClimbingStairs().getUniqueWays(5));
    }
}
