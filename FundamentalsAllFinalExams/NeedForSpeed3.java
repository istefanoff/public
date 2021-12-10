package FundamentalsAllFinalExams;

import java.util.*;

public class NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCars = Integer.parseInt(scanner.nextLine());


        Map<String, List<Integer>> garage = new TreeMap<>();

        for (int i = 0; i < numOfCars; i++) {
            String[] currentCar = scanner.nextLine().split("\\|");
            String car = currentCar[0];
            int mileage = Integer.parseInt(currentCar[1]);
            int fuel = Integer.parseInt(currentCar[2]);

            garage.putIfAbsent(car, new ArrayList<>());
            garage.get(car).add(0, mileage);
            garage.get(car).add(1, fuel);

        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")){
            String[] commandData = command.split(" : ");

            switch (commandData[0]){
                case "Drive":
                    String car = commandData[1];
                    int distance = Integer.parseInt(commandData[2]);
                    int fuel = Integer.parseInt(commandData[3]);

                    if (garage.get(car).get(1) >= fuel){  // 1) getFuel
                        int newMileage = garage.get(car).get(0) + distance;
                        int newFuel = garage.get(car).get(1) - fuel;
                        garage.get(car).set(0, newMileage);
                        garage.get(car).set(1, newFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (garage.get(car).get(0) >= 100000){
                            garage.remove(car);
                            System.out.println("Time to sell the " + car + "!");
                        }
                    }else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    String carToRefuel = commandData[1];
                    int givenFuel = Integer.parseInt(commandData[2]);
                    int currentFuel = garage.get(carToRefuel).get(1);
                    int neededFuel = 75 - currentFuel;
                    if (currentFuel + givenFuel > 75){
                        garage.get(carToRefuel).set(1, 75);
                        System.out.printf("%s refueled with %d liters%n", carToRefuel, neededFuel);
                    }else {
                        garage.get(carToRefuel).set(1, currentFuel + givenFuel);
                        System.out.printf("%s refueled with %d liters%n", carToRefuel, givenFuel);
                    }
                    break;
                case "Revert":
                    String carToRevert = commandData[1];
                    int kilometersToRevert = Integer.parseInt(commandData[2]);
                    int currentMileage = garage.get(carToRevert).get(0); // 0 -> getMileage
                    garage.get(carToRevert).set(0,currentMileage - kilometersToRevert );
                    if (garage.get(carToRevert).get(0) < 10000){
                        garage.get(carToRevert).set(0, 10000);
                    }else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carToRevert, kilometersToRevert);
                    }
                    break;

            }

            command = scanner.nextLine();
        }

        garage.entrySet().stream().sorted((c1,c2) -> c2.getValue().get(0).compareTo(c1.getValue().get(0))).forEach(car ->
        {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car.getKey(), car.getValue().get(0), car.getValue().get(1));
        });


    }
}
