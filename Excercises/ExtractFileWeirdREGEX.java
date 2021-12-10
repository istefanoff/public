package Excercises;

import java.util.Scanner;

public class ExtractFileWeirdREGEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] path = scanner.nextLine().split("[\\\\.]");
        String name = path[path.length-2];
        String extension = path[path.length-1];



        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);


    }
}
