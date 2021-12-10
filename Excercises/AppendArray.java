package Excercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\|+")).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i).trim().replaceAll("\\s+", " ");
            list.set(i, current);
        }
        Collections.reverse(list);


        System.out.println(list.toString()
                .replace("[", "")
                .replace("]", "")
                .replaceAll(",", "")
                .replaceAll("\\s+", " ")
                .trim());




    }
}
