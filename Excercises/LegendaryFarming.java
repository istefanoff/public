package Excercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Map<String, Integer> matsMap = new TreeMap<>();
        matsMap.put("motes", 0);
        matsMap.put("shards", 0);
        matsMap.put("fragments", 0);

        Map<String, Integer> junkMap = new TreeMap<>();

        boolean gotItem = false;

        while(!gotItem){

            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length; i+=2) {
                String material = input[i+1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);

                if (material.equals("motes") || material.equals("shards") || material.equals("fragments")){
                    matsMap.put(material, matsMap.get(material) + quantity);

                    if (matsMap.get(material) >= 250) {
                        switch (material){
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                        }
                        matsMap.put(material, matsMap.get(material) - 250);
                        gotItem = true;
                        break;
                    }

                }else {
                    if (!junkMap.containsKey(material)){
                        junkMap.put(material, 0);
                    }
                    junkMap.put(material, junkMap.get(material) + quantity);
                }

            }
        }

        matsMap.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue())).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
        junkMap.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));



    }
}