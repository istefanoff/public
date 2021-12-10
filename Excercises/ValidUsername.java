package Excercises;

import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (int i = 0; i < usernames.length; i++) {
            String currentUsername = usernames[i];

            if (currentUsername.length() > 3 && currentUsername.length() < 16){
                boolean isValid = false;
                for (int j = 0; j < currentUsername.length(); j++) {
                    char currentChar = currentUsername.charAt(j);
                    if (Character.isLetterOrDigit(currentChar) || currentChar == '_' || currentChar == '-'){
                        isValid = true;
                    }else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(currentUsername);
                }
            }


        }
    }
}
