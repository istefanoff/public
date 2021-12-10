package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Enemies
        String[] enemies = { "Skeleton", "Zombie", "Shaman", "Assassin", "Golem", "Beast", "Cow Warrior", "Dead Soul"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Player
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // percentage
        int gold = 0;
        int level = 1;
        int exp = 0;
        int neededExpForLevelUp = 100;
        int enemiesSlain = 0;
        int critChance = 5; // percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME:
        while(running){
            System.out.println("-------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while(enemyHealth > 0){
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion  " + "(You have: " + numHealthPotions + ")");
                System.out.println("\t3. Run");
                System.out.println("\t4. Buy Potion (Cost:5 gold) (You have: " + gold + " gold)");

                String input = in.nextLine();
                if(input.equals("1")){
                    boolean critical = false;
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    if (rand.nextInt(100) < critChance){
                        damageDealt *= 2;
                        critical = true;
                    }

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    if (critical){
                        System.out.println("\t> You strike the " + enemy + " for " + damageDealt + "(CRITICAL) damage.");
                        System.out.println("\t> You receive " + damageTaken + " in retaliation!");
                    }
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if (health <=0){
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }

                }else if (input.equals("2")){
                    if (numHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "." + "\n\t You now have " + health + " HP." + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    }else {
                        System.out.println("\t You have no health potions left! Defeat enemies for a chance to get one!\n");
                    }
                }else if (input.equals("3")){
                    System.out.println("\t You run away from the " + enemy + "!");
                    continue GAME;
                }else if(input.equals("4")) {
                    if (gold >= 5){
                        System.out.println("\t You bought 1 health potion.");
                        System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
                        numHealthPotions++;
                        gold -=5;
                    }else {
                        System.out.println("Not enough gold. Potion cost 5 gold, you have " + gold);
                    }
                }else {
                    System.out.println("\t Invalid command!");
                }
            }

            if (health < 1){
                System.out.println("You limp out of the dungeon, weak for battle.");
                System.out.println("You have slain " + enemiesSlain + " enemies.");
                break;
            }

            System.out.println("-------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            System.out.println(" # Gold: " + gold + " #");
            gold += level;
            exp+=5;
            enemiesSlain++;
            if (exp >= neededExpForLevelUp){
                System.out.println("Congratulations! You are now level " + level + ".");
                level++;
                neededExpForLevelUp = neededExpForLevelUp * 2;
                attackDamage += 10;
            }
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
            }
            System.out.println("-------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command");
                input = in.nextLine();
            }

            if (input.equals("1")){
                System.out.println("You continue on your adventure!");
            }else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventures!");
                System.out.println("You have slain " + enemiesSlain + " enemies.");
                break;
            }


        } // end loop
        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");

    }
}
