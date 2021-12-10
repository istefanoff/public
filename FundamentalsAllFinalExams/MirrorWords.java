package FundamentalsAllFinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([@#])(?<name>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);

        List<String> validNames = new ArrayList<>();
        List<String> validSecondNames = new ArrayList<>();
        List<String> mirrorWords = new ArrayList<>();
        Boolean goCheck = false;
        StringBuilder sb = new StringBuilder();

        while(matcher.find()){
            validNames.add(matcher.group("name"));    // проверка валидни чифтове
            sb.append(matcher.group("second")).reverse();
            String secondWord = sb.toString();
            validSecondNames.add(secondWord);    // проверка валидни чифтове
            sb.setLength(0);
        }
        if (validNames.size() != 0){
            goCheck = true;
            System.out.printf("%d word pairs found!%n", validNames.size());
        }else {
            System.out.println("No word pairs found!");
        }

        if(goCheck){
            for (int i = 0; i < validNames.size(); i++) {
                String firstWord = validNames.get(i);
                String secondWord = validSecondNames.get(i);


                if (firstWord.equals(secondWord)){
                    sb.append(secondWord).reverse();
                    secondWord = sb.toString();
                    mirrorWords.add(firstWord + " <=> " + secondWord);
                    sb.setLength(0);
                }
            }

        }

        if (mirrorWords.size() > 0){
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }else {
            System.out.println("No mirror words!");
        }


    }
}
