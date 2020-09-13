package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> collect = Arrays.stream(scan.nextLine().split(",\\s+")).collect(Collectors.toList());
        Pattern pattern = Pattern.compile("([@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})");

        for (int i = 0; i < collect.size(); i++) {

            String ticket = collect.get(i).trim();
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String first = ticket.substring(0, 10); // първа част
            String second = ticket.substring(10); //  втора част
            Matcher matcherFirstPart = pattern.matcher(first);
            Matcher matcherSecondPart = pattern.matcher(second);

            boolean hasMatchFirst = matcherFirstPart.find();
            boolean hasMatchSecond = matcherSecondPart.find();

            if (!hasMatchFirst || !hasMatchSecond) { // ако в едната или другата част е -1, нямаме съвпадение
                // прекъсваме програмата до тук и продължавам със следващия елемент
                System.out.printf("ticket \"%s\" - no match%n", ticket);
                continue;
            }

            String left = matcherFirstPart.group(); // взимаме първа част
            String right = matcherSecondPart.group(); // взимаме втора част

            if (left.charAt(0) != right.charAt(0)) { // гледаме дали чаровете, които сме отделили са еднакви, ако не са прекъсваме
                System.out.printf("ticket \"%s\" - no match%n", ticket);
                continue;
            }


            int currentLength = Math.min(left.length(),right.length());
            //в резултата винаги трябва да се принтира шест или десет, за това взимамаме дължината с мин
            if (currentLength == 10) {
                System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, currentLength, left.charAt(0));
            } else {
                System.out.printf("ticket \"%s\" - %d%c%n", ticket, currentLength, left.charAt(0));
            }
        }
    }
}
//private static String getSymbols(String string) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < string.length(); i++) {
//            String current = String.valueOf(string.charAt(i)).toLowerCase();
//            if (!result.toString().contains(current)) {
//                result.append(current);
//            }
//        }
//        return result.toString();