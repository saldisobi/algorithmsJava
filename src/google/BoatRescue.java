package google;

import java.util.Arrays;
import java.util.HashMap;

public class BoatRescue {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int numBoats = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            }else{
                j--;
            }

            numBoats++;
        }
        return numBoats;
    }
}
