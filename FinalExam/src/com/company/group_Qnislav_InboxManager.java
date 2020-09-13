package com.company;

import java.util.*;

public class group_Qnislav_InboxManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, List<String>> map = new TreeMap<>();
        int counter = 0;

        while (!input.equals("Statistics")) {
            String[] command = input.split("->");
            String action = command[0];
            String username = command[1];
            switch (action) {
                case "Add":
                    if (map.containsKey(username)) {
                        System.out.printf("%s is already registered%n", username);
                    } else {
                        map.put(username, new ArrayList<>());
                        counter++;
                    }
                    break;
                case "Send":
                    String email = command[2];
                    if (map.containsKey(username)) {
                        map.get(username).add(email);
                    }
                    break;
                case "Delete":
                    if (map.containsKey(username)) {
                        map.remove(username);
                        counter--;
                    } else {
                        System.out.printf("%s not found!%n", username);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", counter);
        map
                .entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size())
                .forEach(s -> System.out.printf("%s\n- %s%n", s.getKey(), String.join("\n- ", s.getValue())));

    }
}
