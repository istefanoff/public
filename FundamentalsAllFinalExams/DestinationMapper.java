package FundamentalsAllFinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([=\\/])(?<destinations>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int travelPoints = 0;
        List<String> destinationList = new ArrayList<>();

                while (matcher.find()){
                    String textArr = matcher.group("destinations");
                    destinationList.add(textArr);
                    travelPoints += textArr.length();
                }

        System.out.println("Destinations: " + String.join(", ", destinationList));
        System.out.println("Travel Points: " + travelPoints);
    }
}
