package FundamentalsAllFinalExams;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while(!command.equals("Travel")){
            String[] commandData = command.split(":");

            switch (commandData[0]){
                case "Add Stop":
                    int index = Integer.parseInt(commandData[1]);
                    String givenString = commandData[2];
                    if (index >= 0 && index < sb.length()){
                        sb.insert(index, givenString);
                    }
                    System.out.println(sb);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandData[1]);
                    int endIndex = Integer.parseInt(commandData[2]) + 1;
                    if (startIndex >= 0 && endIndex >= 0 && startIndex < sb.length() && endIndex < sb.length() && startIndex <= endIndex){
                        sb.replace(startIndex,endIndex,"");
                    }
                    System.out.println(sb);
                    break;
                case "Switch":
                    String oldString = commandData[1];
                    String newString = commandData[2];
                    String text = sb.toString();
                    if (text.contains(oldString)){
                       text = text.replaceAll(oldString,newString);
                        sb.setLength(0);
                        sb.append(text);
                    }
                    System.out.println(sb);
                    break;

            }



            command = scanner.nextLine();
        }
        System.out.print("Ready for world tour! Planned stops: " + sb);
    }
}
