package FundamentalsAllFinalExams;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> townPeopleMap = new TreeMap<>();
        Map<String, Integer> townGoldMap = new TreeMap<>();

        while(!command.equals("Sail")){
                String[] cityInfo = command.split("\\|\\|");
                String town = cityInfo[0];
                int population = Integer.parseInt(cityInfo[1]);
                int gold = Integer.parseInt(cityInfo[2]);

                if (!townPeopleMap.containsKey(town)){
                    townPeopleMap.put(town, population);
                    townGoldMap.put(town, gold);
                }else {
                    int currentPopulation = townPeopleMap.get(town);
                    int currentGold = townGoldMap.get(town);
                    townPeopleMap.put(town, currentPopulation + population);
                    townGoldMap.put(town, currentGold + gold);
                }

            command = scanner.nextLine();
        }

        String pirateCommand = scanner.nextLine();
        while(!pirateCommand.equals("End")){
            String[] pirateData = pirateCommand.split("=>");

            switch (pirateData[0]){
                case "Plunder":
                    String targetTown = pirateData[1];
                    int killedPeople = Integer.parseInt(pirateData[2]);
                    int stolenGold = Integer.parseInt(pirateData[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", targetTown, stolenGold, killedPeople);
                    int currentPopulation = townPeopleMap.get(targetTown);
                    townPeopleMap.put(targetTown, currentPopulation - killedPeople);
                    int currentGold = townGoldMap.get(targetTown);
                    townGoldMap.put(targetTown, currentGold - stolenGold);
                    if (townPeopleMap.get(targetTown) == 0 || townGoldMap.get(targetTown) == 0){
                        townPeopleMap.remove(targetTown);
                        townGoldMap.remove(targetTown);
                        System.out.printf("%s has been wiped off the map!%n", targetTown);
                    }

                    break;
                case "Prosper":
                    String prosperTown = pirateData[1];
                    int goldGained = Integer.parseInt(pirateData[2]);
                    if (goldGained >= 0){
                        int currentGoldInTown = townGoldMap.get(prosperTown);
                        townGoldMap.put(prosperTown, currentGoldInTown + goldGained);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldGained, prosperTown, townGoldMap.get(prosperTown));
                    }else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;

            }


            pirateCommand = scanner.nextLine();
        }

        if (townGoldMap.size() == 0){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townGoldMap.size());
            townGoldMap.entrySet().stream().sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c -> {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", c.getKey(), townPeopleMap.get(c.getKey()), c.getValue());
                    });


        }

    }
}
