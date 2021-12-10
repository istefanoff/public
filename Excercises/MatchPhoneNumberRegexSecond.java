package Excercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumberRegexSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while ((matcher.find())){
            System.out.println(matcher.group());
        }

    }
}
