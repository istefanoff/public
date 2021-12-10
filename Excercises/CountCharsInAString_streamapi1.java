package Excercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_streamapi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> lettersMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == ' '){
                continue;
            }
            if (!lettersMap.containsKey(currentChar)){
                lettersMap.put(currentChar, 0);
            }
            int currentCount = lettersMap.get(currentChar);
            lettersMap.put(currentChar, currentCount + 1);
        }

        lettersMap.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue())).forEach(e -> {
            System.out.printf("%c -> %d%n", e.getKey(), e.getValue());
        });
        }

    }

