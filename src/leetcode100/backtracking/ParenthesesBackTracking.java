package leetcode100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesBackTracking {

    private static final Character LEFT_PARENTHESES = '(';

    private static final Character RIGHT_PARENTHESES = ')';

    public List<String> generateParentheses(int pairCount) {

        List<String> resultSet = new ArrayList<>();
        char[] current = new char[pairCount * 2];

        generateAll(current, 0, resultSet,0,0,pairCount);

        return resultSet;
    }

    private void generateAll(char[] current, int i, List<String> resultSet, int leftCount, int rightCount, int pairCount) {

        System.out.println("i = "+i+" left count = "+leftCount+" right count = "+rightCount+" pair count = "+pairCount);
        if (i == current.length) {
            resultSet.add(new String(current));
        } else {
            if(leftCount<pairCount){
                current[i] = LEFT_PARENTHESES;
                generateAll(current,i+1,resultSet,leftCount+1,rightCount,pairCount);
            }

            if(leftCount>rightCount){
                current[i] = RIGHT_PARENTHESES;
                generateAll(current,i+1,resultSet,leftCount,rightCount+1,pairCount);
            }

        }
    }


    public static void main(String args[]) {
        List<String> resultSet = new ParenthesesBackTracking().generateParentheses(10);
        for (int i = 0; i < resultSet.size(); i++) {
            System.out.println(resultSet.get(i));
        }
    }
}
