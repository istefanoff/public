package Excercises;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String,Double> productAndPrice = new LinkedHashMap<>();
        Map<String,Integer> productAndQuantity = new HashMap<>();

        while (!command.equals("buy")) {
            String[] product = command.split(" ");
            String name = product[0];
            Double price = Double.parseDouble(product[1]);
            int quantity = Integer.parseInt(product[2]);

            productAndPrice.put(name, price);

            if (!productAndQuantity.containsKey(name)){
                productAndQuantity.put(name, quantity);
            }else {
                productAndQuantity.put(name, productAndQuantity.get(name) + quantity);
            }

            command = scanner.nextLine();
        }

        productAndPrice.entrySet().stream().forEach(e -> {
            int quantity = productAndQuantity.get(e.getKey());
            double totalPrice = e.getValue() * quantity;

            System.out.printf("%s -> %.2f%n", e.getKey(), totalPrice);
        });

        System.out.println(productAndQuantity.get("Beer"));
    }
}