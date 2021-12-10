package Excercises;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            String banWord = bannedWords[i];

            while (text.contains(banWord)) {
                text = text.replace(banWord, asterix(banWord));
            }

        }
        System.out.println(text);
    }

    public static String asterix(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}

/* or weird lector method

    public static String repeatString(String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;
        }
        return String.join("", repeatArr);
    }


 */