package Excercises;

import java.util.Scanner;

public class CharacterMultiplierWithMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        System.out.println(getCharSum(input[0], input[1]));

    }

    public static int getCharSum(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += s1.charAt(i) * s2.charAt(i);
        }
        if (s1.length() > s2.length()){
            String toAdd = s1.substring(s2.length());
            for (int i = 0; i < toAdd.length(); i++) {
                sum += toAdd.charAt(i);
            }
        }else {
            String toAdd = s2.substring(s1.length());
            for (int i = 0; i < toAdd.length(); i++) {
                sum += toAdd.charAt(i);
            }
        }

        return sum;
    }


}
