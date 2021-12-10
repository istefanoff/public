package Excercises;

import java.util.*;

public class CoursesStreamIntegerSortAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, ArrayList<String>> coursesList = new TreeMap<>();

        while (!command.equals("end")){
            String[] commandData = command.split(" : ");
            String course = commandData[0];
            String student = commandData[1];

            if (!coursesList.containsKey(course)){
                coursesList.put(course, new ArrayList<>());
            }

            coursesList.get(course).add(student);

            command = scanner.nextLine();
        }

        coursesList.entrySet().stream().sorted((e1,e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(( entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());

                entry.getValue().stream().sorted().forEach(student -> System.out.println("--" + student));

                }));



    }
}
