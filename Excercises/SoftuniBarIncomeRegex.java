package Excercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniBarIncomeRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String regex = "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        Double grandTotal = 0.0;

        while(!input.equals("end of shift")){
            matcher = pattern.matcher(input);

            if (matcher.find()){
                double currentTotal = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("count"));
                grandTotal += currentTotal;
                System.out.printf("%s: %s - %.2f%n", matcher.group("name"), matcher.group("product"), currentTotal);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", grandTotal);
    }
}
