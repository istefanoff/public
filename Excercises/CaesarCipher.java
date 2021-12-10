package Excercises;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' '){
                continue;
            }
            char currentChar = text.charAt(i);
            char nextChar = (char) ( currentChar + 3);
            sb.append(nextChar);


        }
        System.out.println(sb);
    }
}
