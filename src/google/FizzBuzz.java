package google;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private static final String FIZZ = "FIZZ";
    private static final String BUZZ = "BUZZ";

    public List<String> getFizzBuzz(int num) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            if (i % 15 == 0) {
                result.add(FIZZ + BUZZ);
            } else if (i % 3 == 0) {
                result.add(FIZZ);
            } else if (i % 5 == 0) {
                result.add(BUZZ);
            } else {
                result.add(i + "");
            }
        }

        return result;
    }

    public  static void main(String args[]){
        new FizzBuzz().getFizzBuzz(15).forEach(it->{System.out.println(it);});
    }
}
