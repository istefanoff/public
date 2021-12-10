package FundamentalsAllFinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "@#*(?<name>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            matcher = pattern.matcher(barcode);

            if (matcher.find()){
                String name = matcher.group("name");
                for (int j = 0; j < name.length(); j++) {
                    if (Character.isDigit(name.charAt(j))){
                        sb.append(name.charAt(j));
                    }
                }
                if (sb.length() == 0){
                    System.out.println("Product group: 00");
                }else {
                    System.out.println("Product group: "+ sb);
                    sb.setLength(0);
                }

            }else {
                System.out.println("Invalid barcode");
            }

        }

    }
}
