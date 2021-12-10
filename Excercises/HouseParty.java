package Excercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> guestsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String name = command[0];
            if (command.length == 3){  // is going
                if(!guestsList.contains(name)){
                    guestsList.add(name);
                }else {
                    System.out.println(name + " is already in the list!");
                }
            }else { //not going
                if (guestsList.contains(name)){
                    int index = guestsList.indexOf(name);
                    guestsList.remove(index);
                }else {
                    System.out.println(name + " is not in the list!");
                }
            }

        }

        for (String guest: guestsList) {
            System.out.println(guest);
        }
    }
}
