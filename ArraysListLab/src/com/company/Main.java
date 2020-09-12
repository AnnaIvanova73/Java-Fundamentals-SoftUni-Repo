package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String line = scan.nextLine();
        List<Integer> numbers = parseLineOfNumbers(line);

        int index = 0;

        while (index < numbers.size() - 1) {
            int currentElement = numbers.get(index);
            int nextElement = numbers.get(index + 1);

            if (currentElement == nextElement) {
                int sum = currentElement + nextElement;
                numbers.set(index, sum);
                numbers.remove(index + 1);
                index = 0;
            } else {
                index++;
            }

        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }


    private static List<Integer> parseLineOfNumbers(String line) {
        String[] strings = line.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            int number = Integer.parseInt(string);
            numbers.add(number);
        }

        return numbers;
    }

}
