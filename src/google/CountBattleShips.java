package google;

public class CountBattleShips {

    int getBattleShips(char[][] inputArray) {
        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] == 'X') {

                    int res = isValid(getValueForPosition(i - 1, j, inputArray), getValueForPosition(i + 1, j, inputArray),
                            getValueForPosition(i, j - 1, inputArray), getValueForPosition(i, j + 1, inputArray));

                    if (res == -1) {
                        throw new IllegalStateException();
                    } else if (res == 1) {
                        counter++;
                    }

                }
            }
        }


        return counter;
    }

    private int isValid(char i, char i1, char j, char j1) {
        if ((i == 'X' || i1 == 'X') && (j == 'X' || j1 == 'X')) {
            return -1;
        } else if ((i == 'X' && i1 != 'X')) {
            //this is returning case ends here
            return 1;
        } else if ((i != 'X' && i1 == 'X')) {
            //this is definitely noy last as we would have sent a dot in x+1
            return 0;
        } else if ((j == 'X' && j1 != 'X')) {
            //this is returning case ends here
            return 1;
        }
        return 0;
    }


    char getValueForPosition(int i, int j, char[][] inputArray) {
        if (i < 0 || j < 0 || i > inputArray.length - 1 || j > inputArray[i].length - 1) {
            return '.';
        } else {
            return inputArray[i][j];
        }
    }
    
    
    public static void main(String args[]){
       char[][] board = new char[][] {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};


    }
}
