package google;

import java.util.HashSet;

/**
 * This is brute force not real solution anyway
 */
public class NextClosestTime {

    public String getNextClosestTime(String time) {
        HashSet<Integer> uniqueDigits = new HashSet<>();

        int minutes = Integer.valueOf(time.substring(0, 2));

        int realMinutes = Integer.valueOf(time.substring(4, 5));

        StringBuilder stringBuilder = new StringBuilder();

        int uniqueDigitOne = minutes / 10;
        int uniqueDigitTwo = minutes % 10;
        int uniqueDigitThree = realMinutes / 10;
        int uniqueDigitFour = realMinutes % 10;

        uniqueDigits.add(uniqueDigitOne);
        uniqueDigits.add(uniqueDigitTwo);
        uniqueDigits.add(uniqueDigitThree);
        uniqueDigits.add(uniqueDigitFour);
        minutes += realMinutes;

        boolean isValid = false;


        while (!isValid) {
            minutes = (minutes + 1) % (24 * 60);


            if (uniqueDigits.contains(minutes % 60 % 10) && uniqueDigits.contains((minutes / 60) % 10)
                    && uniqueDigits.contains((minutes % 60) / 10) && uniqueDigits.contains((minutes % 60) % 10)) {


                stringBuilder.append(minutes / 60);
                stringBuilder.append(":");
                stringBuilder.append(minutes % 60);

                isValid = true;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String args[]) {
        System.out.print(new NextClosestTime().getNextClosestTime("12:45"));
    }
}
