package com.company;


import java.util.*;

public class ReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, ArrayList<String>> courseRegister = new TreeMap<>(Comparator.reverseOrder());
        int valueSize = 0;

        while (!"end".equals(input)) {
            String[] arguments = input.split(" : ");

            courseRegister.putIfAbsent(arguments[0], new ArrayList<>());
            courseRegister.get(arguments[0]).add(arguments[1]);

            input = scanner.nextLine();
        }

        courseRegister
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " : " + entry.getValue().size());
                    entry
                            .getValue()
                            .stream()
                            .forEach(c -> System.out.println("--" + c));
                });
    }
}