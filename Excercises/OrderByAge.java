package Excercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    static class Person {
        String name;
        String ID;

        public String getName() {
            return name;
        }

        public String getID() {
            return ID;
        }

        int age;

        public int getAge() {
            return age;
        }

        public Person (String name, String ID, int age){
            this.name = name;
            this.ID = ID;
            this.age = age;
        }


        @Override public String toString(){
            return String.format("%s with ID: %s is %d years old.%n", this.name, this.getID(), this.age);

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Person> personList = new ArrayList<>();

        while(!command.equals("End")){
            String[] commandData = command.split(" ");
            String name = commandData[0];
            String ID = commandData[1];
            int age = Integer.parseInt(commandData[2]);

            Person person = new Person(name, ID, age);

            personList.add(person);



            command = scanner.nextLine();
        }

        personList.sort(Comparator.comparing(Person::getAge));

        for (Person p : personList) {
            System.out.println(p);
        }
    }
}
