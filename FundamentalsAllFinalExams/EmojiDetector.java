package FundamentalsAllFinalExams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([:|*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        long coolThreshold = 1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))){
                coolThreshold *= Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        }

        int counter = 0;
        List<String> coolEmojis = new ArrayList<>();
        while (matcher.find()){
            counter++;
            int sum = 0;
            for (int i = 0; i < matcher.group().length(); i++) {
                sum += matcher.group().charAt(i);
            }
            if (sum >= coolThreshold){
                coolEmojis.add(matcher.group());
            }
        }

        System.out.println("Cool threshold: "+ coolThreshold);

        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        coolEmojis.forEach(e -> System.out.println(e));

    }
}
