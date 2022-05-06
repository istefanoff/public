package com.company.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution_Part1 {
    public static void main(String[] args) throws IOException {
        String FILE_PATH = "C:\\Users\\Code\\Desktop\\input_day3.txt";

        List<String> allLines = Files.readAllLines(Path.of(FILE_PATH));

        StringBuilder gamma = new StringBuilder();
        StringBuilder epilson = new StringBuilder();


        int length = allLines.get(0).length();

        for (int i = 0; i < length; i++) { // each column
            int zeroesCount = 0;
            int onesCount = 0;

            for (int j = 0; j < allLines.size(); j++) {
                char currentChar = allLines.get(j).charAt(i);
                if (currentChar == '0') {
                    zeroesCount++;
                } else {
                    onesCount++;
                }
            }

            if (zeroesCount > onesCount) {
                gamma.append(0);
                epilson.append(1);
            } else {
                gamma.append(1);
                epilson.append(0);
            }
        }

        int gammaDecimal = Integer.parseInt(gamma.toString(), 2);
        int epilsonDecimal = Integer.parseInt(epilson.toString(), 2);
        System.out.println(gammaDecimal * epilsonDecimal);


    }
}
