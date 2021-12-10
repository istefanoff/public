package FundamentalsAllFinalExams;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();


        String command = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while (!command.equals("Reveal")){
            String[] data = command.split(":\\|:");

            switch (data[0]){
                case "InsertSpace":
                    int insertIndex = Integer.parseInt(data[1]);
                    String firstPart = message.substring(0, insertIndex);
                    String secondPart = message.substring(insertIndex);
                    message = firstPart + " " + secondPart;
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = data[1];

                    if (message.contains(substring)){
                        sb.append(substring);
                        sb.reverse();
                        message = message.replaceFirst(substring, "");
                        message = message.concat(sb.toString());
                        sb.setLength(0);
                        System.out.println(message);
                    }else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String toReplace = data[1];
                    String replacement = data[2];
                    if (message.contains(toReplace)){
                        message = message.replace(toReplace, replacement);
                        System.out.println(message);
                    }else {
                        System.out.println("error");
                    }

                    break;
            }



            command = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + message);
    }
}
