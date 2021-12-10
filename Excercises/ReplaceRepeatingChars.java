package Excercises;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder sb = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < sb.length()-1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)){
                sb.deleteCharAt(i+1);
                i--;
            }
        }
        System.out.println(sb);
    }
}
