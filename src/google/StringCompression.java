package google;

public class StringCompression {

    public int compress(char[] chars) {

        int i = 1;

        int counter = 0;

        while (i < chars.length) {
            if (chars[i] == chars[i - 1]) {
                counter++;
            }

           while (counter!=0){

           }
        }
return 0;
    }
}
