package Excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());


        String command = scanner.nextLine();

        while(!command.equals("end")){
            String[] commandData = command.split(" ");

            if (commandData.length == 2){
                wagons.add(Integer.parseInt(commandData[1]));
            }else {
                for (int i = 0; i < wagons.size(); i++) {
                    int passengers = Integer.parseInt(commandData[0]);
                    if (wagons.get(i) + passengers <= maxCapacity){
                        int currentSeats = wagons.get(i);
                        wagons.set(i, currentSeats + passengers);
                        break;
                    }
                }
            }


            command = scanner.nextLine();
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
