package Excercises;


import java.util.*;

public class RaceRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> racers = new LinkedHashMap<>();
        String[] registeredRacers = scanner.nextLine().split( ", ");

        for (int i = 0; i < registeredRacers.length; i++) {
            racers.put(registeredRacers[i], 0);
        }

        String name = "";
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while(!input.equals("end of race")){
            String command = input;
                int currentDistance = 0;
            for (int i = 0; i < command.length(); i++) {
                char currentChar = command.charAt(i);

                if (Character.isLetter(currentChar)){
                    sb.append(currentChar);
                }else if (Character.isDigit(currentChar)){
                    currentDistance += Integer.parseInt(currentChar + "");
                }
                name = sb.toString();
            }
            if (racers.containsKey(name)){
                racers.put(name, racers.get(name) + currentDistance);
            }

            sb.setLength(0);
            input = scanner.nextLine();
        }

        List<String> sortedRacers = new ArrayList<>();

        racers.entrySet().stream().sorted((r1,r2) -> r2.getValue().compareTo(r1.getValue())).limit(3)
                .forEach(r -> sortedRacers.add(r.getKey()));

        System.out.println("1st place: "+ sortedRacers.get(0));
        System.out.println("2nd place: "+ sortedRacers.get(1));
        System.out.println("3rd place: "+ sortedRacers.get(2));

    }
}
