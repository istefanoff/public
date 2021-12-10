package Excercises;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonymsMaps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList> words = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();


            words.putIfAbsent(word, new ArrayList());
            words.get(word).add(synonym);
        }


        for (Map.Entry<String, ArrayList> w : words.entrySet()) {
            System.out.printf("%s - %s%n", w.getKey(), String.join(", ", w.getValue()));
        }
    }
}
