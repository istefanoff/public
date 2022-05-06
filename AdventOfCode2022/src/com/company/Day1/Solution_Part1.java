package com.company.Day1;

import java.io.*;

public class Solution_Part1 {
    public static void main(String[] args) throws IOException {


        int currentNum = 0;
        int count = 0;

        String FILE_PATH = "C:\\Users\\Code\\Desktop\\input.txt";
        File inputFile = new File(FILE_PATH);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String x = null;
        while((x = reader.readLine()) != null){
            int line = Integer.parseInt(x);

            if (currentNum == 0){
                currentNum = line;
                continue;
            }

            if (line > currentNum){
                count++;
            }
                currentNum = line;
        }

        System.out.println(count);

    }

}
