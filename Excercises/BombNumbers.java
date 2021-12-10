package Excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String[] data = scanner.nextLine().split(" ");
        int bombNumber = Integer.parseInt(data[0]);
        int power = Integer.parseInt(data[1]);

        while(numList.contains(bombNumber)){
            for (int i = 0; i < power; i++) {
                int index = numList.indexOf(bombNumber);
                if (index -1 >= 0) {
                    numList.remove(index - 1);
                    if (index != 0){
                        index --;
                    }

                }

                if (index + 1 < numList.size()) {
                    numList.remove(index + 1);
                }
            }
            int bombIndex = numList.indexOf(bombNumber);
            numList.remove(bombIndex);
        }

        int sum = numList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
