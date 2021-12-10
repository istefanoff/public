package Excercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FurnitureRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String regex = ">>(?<furniture>[A-za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        List<String > items = new ArrayList<>();
        Double totalPrice = 0.0;

        while(!command.equals("Purchase")){
            String text = command;
            matcher = pattern.matcher(text);
            if (matcher.find()){
                items.add(matcher.group("furniture"));
                totalPrice += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }

            command = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
