package Excercises;

import java.util.*;

public class OddOccurrencesMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] occurence = scanner.nextLine().split(" ");

        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        List<String> odds = new ArrayList<>();

        for (int i = 0; i < occurence.length; i++) {
            String currentWord = occurence[i].toLowerCase();

            if (!wordsMap.containsKey(currentWord)){
                wordsMap.putIfAbsent(currentWord, 1);
            }else {
                wordsMap.put(currentWord, wordsMap.get(currentWord) + 1);
            }

        }
        for (var entry : wordsMap.entrySet()) {  // итерация през всичките стойности на мапа и проверка
            if (entry.getValue() % 2 != 0){
                odds.add(entry.getKey());
            }

        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));  // итерация през листа
            if (i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
