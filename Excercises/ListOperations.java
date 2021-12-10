package Excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandData = command.split("\\s+");

            switch (commandData[0]){
                case "Add":
                    int number = Integer.parseInt(commandData[1]);
                    numList.add(number);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(commandData[1]);
                    int indexToInsert = Integer.parseInt(commandData[2]);
                    if (indexToInsert >= 0 && indexToInsert < numList.size()){
                        numList.add(indexToInsert, numToInsert);
                    }else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandData[1]);
                    if (indexToRemove >= 0 && indexToRemove < numList.size()){
                        numList.remove(indexToRemove);
                    }else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "Shift":
                    int count = Integer.parseInt(commandData[2]);
                    if (commandData[1]. equals("left")){
                        for (int i = 0; i < count; i++) {
                            numList.add(numList.get(0));
                            numList.remove(0);
                        }
                    }else { // equals right
                        for (int i = 0; i < count; i++) {
                            numList.add(0, numList.get(numList.size() - 1));
                            numList.remove(numList.size() - 1);
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
