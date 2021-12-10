package Excercises;

import java.util.*;

public class StudentAcademyAPIaverageGradeStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsList.containsKey(student)){
                studentsList.put(student, new ArrayList<>());
            }
            studentsList.get(student).add(grade);
        }

        Map<String, Double> betterStudents = new HashMap<>();

        studentsList.forEach((key, value) -> {
            double sum = 0;
            for (int i = 0; i < value.size(); i++) {
                sum += value.get(i);
            }
            double average = sum / value.size();

            if (average >= 4.50){
                betterStudents.put(key, average);
            }
        });

        betterStudents.entrySet().stream().sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue())).forEach(s -> {
            System.out.printf("%s -> %.2f%n", s.getKey(), s.getValue());
        });


    }
}
