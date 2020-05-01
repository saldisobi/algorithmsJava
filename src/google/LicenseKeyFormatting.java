package google;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int i = S.length() - 1;
        int counter = 0;
        while (i >= 0) {
            char charact = Character.toUpperCase(S.charAt(i));
            if (charact == '-') {
                i--;
            } else if (counter != 0 && counter % 4 == 0) {
                sb.insert(0, '-');
                counter = 0;
            } else {
                sb.insert(0, charact);
                i--;
                counter++;
            }

        }

        return sb.toString();
    }


    public static void main(String args[]) {
        System.out.print(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
