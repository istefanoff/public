package FundamentalsAllFinalExams;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String , List<Integer>> heroesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] heroData = scanner.nextLine().split(" ");
            String heroName = heroData[0];
            int HP = Integer.parseInt(heroData[1]);
            int MP = Integer.parseInt(heroData[2]);

            heroesMap.putIfAbsent(heroName, new ArrayList<>());
            heroesMap.get(heroName).add(0, HP);
            heroesMap.get(heroName).add(1, MP);
        }

        String command = scanner.nextLine();
        while(!command.equals("End")){
            String[] commandData = command.split(" - ");
            String heroName = commandData[1];

            switch (commandData[0]){
                case "CastSpell":
                    int spellCost = Integer.parseInt(commandData[2]);
                    String spellName = commandData[3];
                    int heroMana = heroesMap.get(heroName).get(1);

                    if (heroMana >= spellCost){
                        heroesMap.get(heroName).set(1, heroMana - spellCost);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName,heroesMap.get(heroName).get(1));
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandData[2]);
                    String attacker = commandData[3];
                    int currentHeroHealth = heroesMap.get(heroName).get(0);

                    if (currentHeroHealth - damage > 0){
                        heroesMap.get(heroName).set(0, currentHeroHealth - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroesMap.get(heroName).get(0));
                    }else {
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int potionAmount = Integer.parseInt(commandData[2]);
                    int currentHeroMana = heroesMap.get(heroName).get(1);
                    if (currentHeroMana + potionAmount > 200){
                        heroesMap.get(heroName).set(1, 200);
                        System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentHeroMana);
                    }else {
                        heroesMap.get(heroName).set(1, currentHeroMana + potionAmount);
                        System.out.printf("%s recharged for %d MP!%n", heroName, potionAmount);
                    }
                    break;
                case "Heal":
                    int healPotion = Integer.parseInt(commandData[2]);
                    int currentHP = heroesMap.get(heroName).get(0);
                    if (currentHP + healPotion > 100){
                        heroesMap.get(heroName).set(0, 100);
                        System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHP);
                    }else {
                        heroesMap.get(heroName).set(0, currentHP + healPotion);
                        System.out.printf("%s healed for %d HP!%n", heroName, healPotion);
                    }
                    break;
            }



            command = scanner.nextLine();
        }

        heroesMap.entrySet().stream().sorted((h1,h2) -> h2.getValue().get(0).compareTo(h1.getValue().get(0)))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    System.out.printf("  HP: %d%n", entry.getValue().get(0));
                    System.out.printf("  MP: %d%n", entry.getValue().get(1));
                });


    }
}
