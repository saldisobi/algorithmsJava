package algoexpert;

public class CaesarCipherEncrypt {
    public String encryptCaesarCipher(String input, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(getCharacterCipher(input.charAt(i), shift));
        }

        return sb.toString();

    }

    private char getCharacterCipher(char charAt, int shift) {
        int charInt = charAt;
        return (char)( (charInt+shift - 65)%26 + 65);
    }

    public static void main(String args[]) {
        System.out.println("caesar encryption for ABCDEFGHIJKLMNOPQRSTUVWXYZ shifted 23 is " + new CaesarCipherEncrypt().encryptCaesarCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 23));
    }
}
