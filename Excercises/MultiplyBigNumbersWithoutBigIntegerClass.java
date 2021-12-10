package Excercises;

import java.util.Scanner;

public class MultiplyBigNumbersWithoutBigIntegerClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bigNumber = scanner.nextLine().split("");
        int num = Integer.parseInt(scanner.nextLine());


        StringBuilder sb = new StringBuilder();
        int leftDigit = 0;

        if (num > 0){
            for (int i = bigNumber.length-1 ; i >= 0; i--) {
                int currentNum = Integer.parseInt(bigNumber[i]);


                int result = (currentNum * num) + leftDigit;
                if (result >9){
                    int lastDigit = result % 10;
                    sb.append(lastDigit);
                    leftDigit = result /10;
                }else {
                    sb.append(result);
                    leftDigit = 0;
                }

            }
            if (leftDigit > 0){
                sb.append(leftDigit);
            }

            System.out.println(sb.reverse());

        }



    }
}
