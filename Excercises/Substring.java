package Excercises;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String part = scanner.nextLine();
        String text = scanner.nextLine();

        while(text.contains(part)){
            text = text.replace(part, "");
        }
        System.out.println(text);
    }
}

/* ELSE :

•	Read the input.
•	Find the first index where the key appears.
o	Use the built-in method indexOf()
•	Remove the match.
o	Use the built-in method replace(String oldValue, String newValue)
•	Repeat it until the text doesn't contain the key anymore.

        int index = sentence.indexOf(word);

        while(index != -1) {
            sentence = sentence.replace(word, "");
            index = sentence.indexOf(word);
        }

 */