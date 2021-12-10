package Excercises;

import java.util.*;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        double grade;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        @Override public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] studentInfo = scanner.nextLine().split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            Double grade = Double.parseDouble(studentInfo[2]);

            Student currentStudent = new Student(firstName, lastName, grade);

            studentList.add(currentStudent);

        }

        studentList.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(studentList);

        for (Student s: studentList) {
            System.out.println(s);
        }
    }
}
