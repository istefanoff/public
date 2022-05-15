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

        int length = allLines.get(0).length();

        String oxygenGeneratorRating = getOxygenRating(allLines, length);

        String CO2ScrubberRating = getScrubberRating(allLines, length);

        int oxygen = Integer.parseInt(oxygenGeneratorRating, 2);

        int scrubber = Integer.parseInt(CO2ScrubberRating, 2);

        int lifeSupportRating = oxygen * scrubber;

        System.out.println(lifeSupportRating);


    }

    private static String getOxygenRating(List<String> allLines, int length) {
        List<String> newList = allLines;


        for (int i = 0; i < length; i++) {
            int zeroesCount = 0;
            int onesCount = 0;


            for (int j = 0; j < newList.size(); j++) {
                char currentChar = newList.get(j).charAt(i);
                if (currentChar == '0') {
                    zeroesCount++;
                } else {
                    onesCount++;
                }

            }

                int currentIndex = i;

                if (zeroesCount > onesCount) {

                    newList = newList.stream().filter(a -> a.charAt(currentIndex) == '0').collect(Collectors.toList());

                } else {
                    newList = newList.stream().filter(a -> a.charAt(currentIndex) == '1').collect(Collectors.toList());


                }
                if(newList.size() == 1){
                    return newList.get(0);
                }


            }


        return newList.get(0);
    }


    private static String getScrubberRating(List<String> allLines, int length) {
        List<String> newList = allLines;

        for (int i = 0; i < length; i++) {
            int zeroesCount = 0;
            int onesCount = 0;


            for (int j = 0; j < newList.size(); j++) {
                    char currentChar = newList.get(j).charAt(i);
                    if (currentChar == '0') {
                        zeroesCount++;
                    } else {
                        onesCount++;
                    }

            }
            int currentIndex = i;

            if (zeroesCount < onesCount || zeroesCount == onesCount) {

                newList = newList.stream().filter(a -> a.charAt(currentIndex) == '0').collect(Collectors.toList());

            } else {
                newList = newList.stream().filter(a -> a.charAt(currentIndex) == '1').collect(Collectors.toList());


            }
            if(newList.size() == 1){
                return newList.get(0);
            }

        }
        return newList.get(0);
    }

}