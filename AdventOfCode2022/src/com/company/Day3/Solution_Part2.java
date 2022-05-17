package com.company.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_Part2 {
    public static void main(String[] args) throws IOException {
        String FILE_PATH = "C:\\Users\\Code\\Desktop\\input_day3.txt";

        List<String> allLines = Files.readAllLines(Path.of(FILE_PATH));

        String oxygenGeneratorRating = "";
        String CO2ScrubberRating = "";

        int length = allLines.get(0).length();

        oxygenGeneratorRating = extracted(allLines, length);
        CO2ScrubberRating = extracted(allLines, length);

        int oxygen = Integer.parseInt(oxygenGeneratorRating, 2);
        int scrubber = Integer.parseInt(CO2ScrubberRating, 2);
        System.out.println(oxygen * scrubber);


    }

    private static String extracted(List<String> allLines, int length) {
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
            int currentIndex = i;

            if (zeroesCount > onesCount) {

                allLines = allLines.stream().filter(a -> a.charAt(currentIndex) == '0').collect(Collectors.toList());
            } else {
                allLines = allLines.stream().filter(a -> a.charAt(currentIndex) == '1').collect(Collectors.toList());

            }
        }
            return allLines.get(0);
    }
}
