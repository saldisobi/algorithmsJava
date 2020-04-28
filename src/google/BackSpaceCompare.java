package google;

public class BackSpaceCompare {

    public boolean isBackSpaceStringEqual(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;

        int s1Counter = s1.length() - 1;
        int s2Counter = s2.length() - 1;

        while (s1Counter != 0 || s2Counter != 0) {
            if (s1.charAt(s1Counter) == s2.charAt(s2Counter)) {
                s1Counter--;
                s2Counter--;
            } else if (s1.charAt(s1Counter) == '#') {
                s1Counter = s1Counter - 2;

            } else if (s2.charAt(s2Counter) == '#') {
                s2Counter = s2Counter - 2;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.print(new BackSpaceCompare().isBackSpaceStringEqual("sald", "saldi#"));
    }
}
