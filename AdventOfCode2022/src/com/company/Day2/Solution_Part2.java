package com.company.Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Solution_Part2 {
    public static void main(String[] args) throws IOException {

        //down X increases your aim by X units.
        //up X decreases your aim by X units.
        //forward X does two things:
        //It increases your horizontal position by X units.
        //It increases your depth by your aim multiplied by X.

        String FILE_PATH = "C:\\Users\\Code\\Desktop\\input_day2.txt";
        File inputFile = new File(FILE_PATH);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        int X = 0; //horizontal position
        int Y = 0; // depth
        int aim = 0;

        String x = null;

        while ((x = reader.readLine()) != null) {
            String direction = x.split("\\s+")[0];
            int value = Integer.parseInt(x.split("\\s+")[1]);

            switch (direction) {
                case "forward":
                    X += value;
                    Y += (aim * value);
                    break;
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
            }

        }

        System.out.println(X * Y);


    }


}
