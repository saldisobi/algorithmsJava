package leetcode100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesBruteForce {

    private static final Character LEFT_PARENTHESES = '(';

    private static final Character RIGHT_PARENTHESES = ')';

    public List<String> getParenthesesBruteForce(int pairCount) {

        List<String> resultSet = new ArrayList();

        char[] current = new char[pairCount * 2];

        generateAll(current, 0, resultSet);

        return resultSet;
    }

    private void generateAll(char[] current, int i, List<String> resultSet) {
        if (current.length == i) {
            if (isValid(current)) {
                resultSet.add(new String(current));
            }
        } else {
            current[i] = LEFT_PARENTHESES;
            generateAll(current, i + 1, resultSet);
            current[i] = RIGHT_PARENTHESES;
            generateAll(current, i + 1, resultSet);
        }
    }

    private boolean isValid(char[] current) {
        int counter = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] == LEFT_PARENTHESES) {
                counter++;
            } else {
                counter--;
            }

            if (counter < 0)
                return false;
        }

        return counter == 0;
    }


    public static void main(String args[]) {
        List<String> resultSet = new ParenthesesBruteForce().getParenthesesBruteForce(3);
        for (int i = 0; i < resultSet.size(); i++) {
            System.out.println(resultSet.get(i));
        }
    }


}
