package FundamentalsAllFinalExams;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")){
            String[] command = input.split("\\|");

            switch (command[0]){
                case "Move":
                    int endIndex = Integer.parseInt(command[1]);
                    String msgToMove = encryptedMessage.substring(0,endIndex);
                    encryptedMessage.replace(0, endIndex, "");
                    encryptedMessage.append(msgToMove);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    String value = command[2];
                    encryptedMessage.insert(index, value);
                    break;
                case "ChangeAll":
                    String substringValue = command[1];
                    String replacement = command[2];
                    int word = encryptedMessage.indexOf(substringValue);
                    while(word != -1){
                        encryptedMessage.replace(word, word + substringValue.length(), replacement);
                        word = encryptedMessage.indexOf(substringValue);
                    }

                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
