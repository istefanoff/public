package Excercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parking = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            if (command.length == 3){ // register
                String username = command[1];
                String plateNumber = command[2];
                if (!parking.containsKey(username)){
                    parking.put(username, plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                }else {
                    System.out.println("ERROR: already registered with plate number " + plateNumber);
                }
            }else { // unregister
                String unregUsername = command[1];
                if (parking.containsKey(unregUsername)){
                    parking.remove(unregUsername);
                    System.out.println(unregUsername + " unregistered successfully");
                }else {
                    System.out.printf("ERROR: user %s not found", unregUsername);
                }
            }
        }

        parking.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " => " + e.getValue());
        });

    }
}
