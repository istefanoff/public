package FundamentalsAllFinalExams;

import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsAndRarity = new HashMap<>();
        Map<String,List<Double>> plantsRatingMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantsInfo = scanner.nextLine().split("<->");
            String plant = plantsInfo[0];
            int rarity = Integer.parseInt(plantsInfo[1]);;

            plantsAndRarity.put(plant,rarity);
            plantsRatingMap.put(plant, new ArrayList<>());
            plantsRatingMap.get(plant).add(0.0);
        }

        String command = scanner.nextLine();

        while(!command.equals("Exhibition")){
            String[] commandData = command.split(" ");

            switch (commandData[0]){
                case "Rate:":
                    String plantToRate = commandData[1];
                    Double rating = Double.parseDouble(commandData[3]);
                        plantsRatingMap.get(plantToRate).add(rating);
                    break;
                case "Update:":
                    if (plantsAndRarity.containsKey(commandData[1])){
                        int rarity = Integer.parseInt(commandData[3]);
                        plantsAndRarity.put(commandData[1],rarity);
                    }else {
                        System.out.println("error");
                    }

                    break;
                case "Reset:":
                    if (plantsRatingMap.containsKey(commandData[1]))
                        plantsRatingMap.get(commandData[1]).clear();

                    break;
            }


            command = scanner.nextLine();
        }
            Map<String,Double> averageRating = new HashMap<>();

            plantsAndRarity.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toList());

        plantsRatingMap.entrySet().stream().forEach(e ->
        {

            double sum = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                sum += e.getValue().get(i);
            }
            if (sum == 0){
                averageRating.put(e.getKey(), 0.0);
            }else {
                double averageSum = sum / (e.getValue().size()-1);
                averageRating.put(e.getKey(), averageSum);
            }


        });
        System.out.println("Plants for the exhibition:");
        plantsAndRarity.entrySet().forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(), averageRating.get(e.getKey())));


    }
}
