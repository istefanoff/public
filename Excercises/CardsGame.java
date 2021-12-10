package Excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (firstHand.size() > 0 && secondHand.size() > 0) {
            if (firstHand.get(0) > secondHand.get(0)){
                firstHand.add(firstHand.get(0));
                firstHand.add(secondHand.get(0));
                firstHand.remove(0);
                secondHand.remove(0);

            }else if ( secondHand.get(0) > firstHand.get(0)){
                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));
                secondHand.remove(0);
                firstHand.remove(0);

            }else {   //equal
                    firstHand.remove(0);
                    secondHand.remove(0);

            }

        }

        if (firstHand.size() > 0){
            int sumFirst = firstHand.stream().mapToInt(Integer::intValue).sum();
            System.out.println("First player wins! Sum: "+ sumFirst);
        }else {
            int sum = secondHand.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Second player wins! Sum: "+ sum);
        }
    }
}
