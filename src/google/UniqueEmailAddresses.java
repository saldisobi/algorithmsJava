package google;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public int getUniqueEmailAddresses(String[] emailList) {

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < emailList.length; i++) {

            String[] updatedString = emailList[i].split("@");
            StringBuilder tempString = new StringBuilder();
            for (int j = 0; j < updatedString[0].length(); j++) {

                if (updatedString[0].charAt(j) == '.') {
                    continue;
                } else if (updatedString[0].charAt(j) == '+') {
                    break;

                } else {
                    tempString.append(updatedString[0].charAt(j));
                }

            }

            tempString.append(updatedString[1]);


            if (!hashSet.contains(tempString.toString())) {
                hashSet.add(tempString.toString());
            }

        }

        return hashSet.size();
    }


    public static void main(String args[]) {
System.out.print(new UniqueEmailAddresses().getUniqueEmailAddresses(new String[]{"ss@mail.com","s.s@mail.com","ss+abc@mail.com"}));
    }
}
