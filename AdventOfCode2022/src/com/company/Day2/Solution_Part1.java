package com.company.Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Solution_Part1 {
    public static void main(String[] args) throws IOException {


        String FILE_PATH = "C:\\Users\\Code\\Desktop\\input_day2.txt";
        File inputFile = new File(FILE_PATH);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        int X = 0;
        int Y = 0;

        String x = null;

        while ((x = reader.readLine()) != null) {
            String direction = x.split("\\s+")[0];
            int value = Integer.parseInt(x.split("\\s+")[1]);

            switch (direction) {
                case "forward":
                    X += value;
                    break;
                case "up":
                    Y -= value;
                    break;
                case "down":
                    Y += value;
                    break;
            }

        }
            System.out.println(X * Y);
    }
}