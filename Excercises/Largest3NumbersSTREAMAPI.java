package Excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3NumbersSTREAMAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1,n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());


        if (numList.size() >= 3){
            for (int i = 0; i < 3; i++) {
                System.out.print(numList.get(i) + " ");
            }
        }else {
            for (int n: numList) {
                System.out.print(n + " ");
            }
        }


    }
}
