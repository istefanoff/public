package FundamentalsAllFinalExams;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int piecesCount = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> compositorNotes = new TreeMap();

        for (int i = 0; i < piecesCount; i++) {
            String[] pieceInfo = scanner.nextLine().split("\\|");
            String piece = pieceInfo[0];
            String composer = pieceInfo[1];
            String key = pieceInfo[2];

            compositorNotes.put(piece, new ArrayList<>());
            compositorNotes.get(piece).add(composer);
            compositorNotes.get(piece).add(key);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] commandData = command.split("\\|");

            switch (commandData[0]) {
                case "Add":
                    String piece = commandData[1];
                    String composer = commandData[2];
                    String key = commandData[3];

                    if (!compositorNotes.containsKey(piece)){
                        compositorNotes.put(piece, new ArrayList<>());
                        compositorNotes.get(piece).add(composer);
                        compositorNotes.get(piece).add(key);
                        System.out.println(piece + " by " + composer + " in " + key + " added to the collection!");
                    }else {
                        System.out.println(piece + " is already in the collection!");
                    }
                    break;
                case "Remove":
                    String pieceToRemove = commandData[1];
                    if (compositorNotes.containsKey(pieceToRemove)){
                        compositorNotes.remove(pieceToRemove);
                        System.out.println("Successfully removed " + pieceToRemove + "!");
                    }else {
                        System.out.println("Invalid operation! " + pieceToRemove + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String oldPiece = commandData[1];
                    String newKey = commandData[2];
                    if (compositorNotes.containsKey(oldPiece)){
                        compositorNotes.get(oldPiece).set(1, newKey);
                        System.out.println("Changed the key of " + oldPiece + " to " + newKey + "!");
                    }else {
                        System.out.println("Invalid operation! " + oldPiece + " does not exist in the collection.");
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        compositorNotes.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));

    }
}
