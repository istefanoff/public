package Excercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Map<String,Integer> resourceMap = new LinkedHashMap<>();
        String currentKey = data;
        int count = 1;
        while(!data.equals("stop")){

            if (count % 2 == 1){ // is a resource
                currentKey = data;
                if (!resourceMap.containsKey(data)){
                    resourceMap.put(data, 0);
                    count++;
                }

            }else { // quantity
                int quantity = Integer.parseInt(data);
                resourceMap.put(currentKey, resourceMap.get(currentKey) + Integer.parseInt(data));
                count++;
            }

            data = scanner.nextLine();
        }


        resourceMap.entrySet()
                .forEach(e -> {
                    System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
                });

    }
}
