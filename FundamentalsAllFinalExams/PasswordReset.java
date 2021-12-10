package FundamentalsAllFinalExams;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String command = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        while(!command.equals("Done")){
            String[] commandData = command.split(" ");

            switch (commandData[0]){
                case "TakeOdd":

                    for (int i = 0; i < password.length(); i++) {
                        if ( i % 2 != 0){
                            sb.append(password.charAt(i));
                        }
                    }
                    password = sb.toString();
                    sb.setLength(0);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandData[1]);
                    int length = Integer.parseInt(commandData[2]);
                    String substring = password.substring(index, index + length);
                   password = password.replaceFirst(substring, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String sub = commandData[1];
                    String substitute = commandData[2];
                    if (password.contains(sub)){
                        password = password.replaceAll(sub, substitute);
                        System.out.println(password);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

            }



            command = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}
