package Excercises;

import java.util.*;

public class CompanyUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> companyMap = new TreeMap<>();


        while(!command.equals("End")){
            String[] commandData = command.split(" -> ");
            String company = commandData[0];
            String employee = commandData[1];

            if (!companyMap.containsKey(company)){
                companyMap.put(company, new ArrayList<>());
            }
            if (!companyMap.get(company).contains(employee)){
                companyMap.get(company).add(employee);
            }


            command = scanner.nextLine();
        }

        companyMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            for (int i = 0; i < e.getValue().size(); i++) {
                System.out.printf("-- %s%n", e.getValue().get(i));
            }
        });
    }
}
