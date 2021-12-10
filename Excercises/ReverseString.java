package Excercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        while (!input.equals("end")){
            String word = input;
            for (int i = input.length()-1; i >= 0; i--) {
                char currentChar = input.charAt(i);
                sb.append(currentChar);
            }

            System.out.printf("%s = %s%n",word, sb );
            sb.setLength(0);
            input = scanner.nextLine();
        }


    }
}
