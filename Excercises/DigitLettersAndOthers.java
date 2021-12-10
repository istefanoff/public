package Excercises;

import java.util.Scanner;

public class DigitLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String digits = "";
        String letters = "";
        String symbols = "";

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isDigit(currentChar)){
                digits += currentChar;
            }else if (Character.isLetter(currentChar)) {
                letters += currentChar;
            }else {
                symbols += currentChar;
            }
        }

        System.out.printf("%s%n%s%n%s", digits, letters, symbols);
    }
}
