package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {

            Map<String, List<String>> recipeBook = new HashMap<>();
            Map<String, String> recipeInstructions = new HashMap<>();
            // Omelette recipe

            recipeBook.put("omelette", new ArrayList<>());
            recipeBook.get("omelette").add("eggs");
            recipeBook.get("omelette").add("butter");
            recipeBook.get("omelette").add("cheese");
            recipeInstructions.put("omelette", "Do you seriously need a recipe for an omelette? Maybe you should go for scrambled eggs instead.");

            // Salad recipe

            recipeBook.put("salad", new ArrayList<>());
            recipeBook.get("salad").add("tomatoes");
            recipeBook.get("salad").add("cucumbers");
            recipeBook.get("salad").add("onion");
            recipeInstructions.put("salad", "Chop it all in a bowl and mix it well with spices");

            // Pizza recipe

            recipeBook.put("pizza", new ArrayList<>());
            recipeBook.get("pizza").add("dough");
            recipeBook.get("pizza").add("salami");
            recipeBook.get("pizza").add("cheese");
            recipeInstructions.put("pizza", "Spread the dough in the form you want your pizza to be, put the other ingredients on top, bake at 180 degrees for 25min.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Add the products you have in your fridge, separated by comma.");
        String[] products = scanner.nextLine().split(",");
        List<String> productsList = new ArrayList<>(Arrays.asList(products));

        List<String> recipesYouCanMake = new ArrayList<>();

            recipeBook.entrySet().forEach(r -> {
                boolean gotItem = false;
                for (int i = 0; i < r.getValue().size(); i++) {
                    for (int j = 0; j < productsList.size(); j++) {
                        if (r.getValue().get(i).equals(productsList.get(j))) {
                            gotItem = true;
                            break;
                        }

                    }
                    if (!gotItem) {
                        break;
                    }
                }
                if (gotItem) {
                    recipesYouCanMake.add(r.getKey());
                }
            });

        System.out.println("Recipes you can make: " + String.join(", ", recipesYouCanMake));
        System.out.println("If you want cooking instructions, please type the name of the recipe.");
        String instrucionsRequest = scanner.nextLine();
        if (recipeInstructions.containsKey(instrucionsRequest)){
            System.out.println(recipeInstructions.get(instrucionsRequest));
        }
        }
    }




