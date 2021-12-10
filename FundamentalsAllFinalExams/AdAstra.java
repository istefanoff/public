package FundamentalsAllFinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\|#])(?<name>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int calories = 0;

        while(matcher.find()){
            calories += Integer.parseInt(matcher.group("calories"));
        }
        int days = calories / 2000;

        System.out.println("You have food to last you for: " + days + " days!");
        matcher.reset();
        while (matcher.find()){
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", matcher.group("name"), matcher.group("date"), matcher.group("calories"));
        }


    }
}
