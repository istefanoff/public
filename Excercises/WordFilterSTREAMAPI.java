package Excercises;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilterSTREAMAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = Arrays.stream(scanner.nextLine().split(" ")).filter(w -> w.length() % 2 == 0).toArray(String[]::new);


    }
}
