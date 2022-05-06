package com.company.Day1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution_Part2 {
    public static void main(String[] args) throws IOException {


        int currentNum = 0;
        int count = 0;

        String FILE_PATH = "C:\\Users\\Code\\Desktop\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(FILE_PATH));

        for (int i = 2; i < allLines.size(); i++) {
            int sum =
                    Integer.parseInt(allLines.get(i)) +
                    Integer.parseInt(allLines.get(i - 1)) +
                    Integer.parseInt(allLines.get(i - 2));

            if (currentNum == 0) {
                currentNum = sum;
                continue;
            }

            if (sum > currentNum){
                count++;
            }
            currentNum = sum;
        }

        System.out.println(count);

    }

}
