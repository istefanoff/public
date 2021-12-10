package FundamentalsAllFinalExams;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Generate")){
            String[] commandData = command.split(">>>");

            switch(commandData[0]){
                case "Contains":
                    String checkSubstring = commandData[1];
                    if (activationKey.contains(checkSubstring)){
                        System.out.printf("%s contains %s%n", activationKey, checkSubstring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startFlip = Integer.parseInt(commandData[2]);
                    int endFlip = Integer.parseInt(commandData[3]);
                    String textToReplace = activationKey.substring(startFlip, endFlip);
                    if (commandData[1].equals("Upper")){
                       String change = activationKey.substring(startFlip, endFlip).toUpperCase();
                       activationKey = activationKey.replace(textToReplace, change);
                    }else{ // lower
                        String change = activationKey.substring(startFlip, endFlip).toLowerCase();
                        activationKey = activationKey.replace(textToReplace, change);
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(commandData[1]);
                    int endIndex = Integer.parseInt(commandData[2]);
                    String delete = activationKey.substring(startIndex, endIndex);
                    activationKey = activationKey.replace(delete, "");
                    System.out.println(activationKey);
                    break;

            }


            command = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey);
    }
}
