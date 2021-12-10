package Excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String executeCommand = command.split(" ")[0];
            int element = Integer.parseInt(command.split(" ")[1]);
            switch (executeCommand) {
                case "Delete":
                    for (int i = 0; i <numList.size() ; i++) {
                        if (numList.get(i) == element){
                            numList.remove(numList.get(i));
                        }
                    }
                    break;
                case "Insert":
                    int position = Integer.parseInt(command.split(" ")[2]);
                    numList.add(position, element);
                    break;

            }


            command = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));


    }
}
