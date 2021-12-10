package Excercises;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            int repeatTime = words[i].length();
            for (int j = 0; j < repeatTime; j++) {
                sb.append(currentWord);
            }
        }
        System.out.println(sb);
    }
}
