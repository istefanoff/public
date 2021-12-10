package Excercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue_stringOverride {

    static class Vehicle {
        String type;
        String model;
        String color;

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public double getHorsePower() {
            return horsePower;
        }

        double horsePower;


        public Vehicle (String type, String model, String color, double horsePower){
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;

        }
        @Override public String toString(){
            String typeVehicle = type.equals("car") ? "Car" : "Truck";
            return String.format("Type: %s\n" +
                    "Model: %s\n" +
                    "Color: %s\n" +
                    "Horsepower: %.2f\n", this.type, this.model, this.color, this.horsePower);
        }


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> catalogue = new ArrayList<>();

        String firstCommand = scanner.nextLine();

        while (!firstCommand.equals("End")){
          String[] firstData = firstCommand.split(" ");
          String type = firstData[0];
          String model = firstData[1];
          String color = firstData[2];
          Double horsePower = Double.parseDouble(firstData[3]);

          Vehicle currentVehicle = new Vehicle(type, model, color, horsePower);

          catalogue.add(currentVehicle);


            firstCommand = scanner.nextLine();
        }

        String modelAsk = scanner.nextLine();

        while(!modelAsk.equals("Close the Catalogue")){
            for (Vehicle v: catalogue) {
                if (v.getModel().equals(modelAsk)){
                    System.out.println(v);
                }
            }

            modelAsk = scanner.nextLine();
        }

        double averageCars = 0;
        int carsCount = 0;
        double averageTrucks = 0;
        int trucksCount = 0;



        for (Vehicle v : catalogue) {
            if (v.getType().equals("car")){
                averageCars += v.getHorsePower();
                carsCount++;
            }
        }

        for (Vehicle v : catalogue) {
            if (v.getType().equals("truck")){
                averageTrucks += v.getHorsePower();
                trucksCount++;
            }
        }

        averageCars = averageCars / carsCount;
        averageTrucks = averageTrucks / trucksCount;

        if (trucksCount == 0){
            averageTrucks = 0.00;
        }else if (carsCount == 0){
            averageCars = 0.00;
        }

        System.out.printf("Cars have average horsepower of: %.2f%n", averageCars);
        System.out.printf("Trucks have average horsepower of: %.2f", averageTrucks);

    }
}
