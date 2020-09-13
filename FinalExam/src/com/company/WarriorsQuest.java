package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class WarriorsQuest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String skill = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder(skill);

        while (!input.equals("For Azeroth")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "GladiatorStance":
                    String strUpper = output.toString().toUpperCase();
                    output.setLength(0);
                    output.append(strUpper);
                    System.out.println(output);
                    break;
                case "DefensiveStance":
                    String strLower = output.toString().toLowerCase();
                    output.setLength(0);
                    output.append(strLower);
                    System.out.println(output);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < output.length()) {
                        char letter = tokens[2].charAt(0);
                        output.setCharAt(index, letter);
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    String action = tokens[1];
                    String substring = tokens[2];
                    int firstIndex = output.indexOf(substring);

                    //Правим си променлива в която копираме стойността на output (StringBuilder)
                    //Защото командата която ни подават може да е грешна ПРИМЕР ->
                    //Вместо - Target Change или Target Remove тя може да е - Target flumfiDumfi или Targer pikachu все тая
                    //Но ако е валидна тя е променила нещо в стойноста
                    //И все пак просто няма тест който да ни е подал следните стойности ->
                    //"Target Change {something} {where}" и ако нашият output == SunnyDay резултата от командата ще бъде
                    // SunnyDay което ни чупи логиката за това дали output.equals(saveChecker) Което ще бъде равно на true
                    //Затова е по-добре при команди с два индекса да провериш и двата.
                    //Също така виждам още няколко варианта при които кодът ти може да даде фира (Така да се каже)
                    //Бърз пример - Ако командата която ни дадът е Target neshtoSi something и нашият output == IHaveneshtoSi
                    //firstIndex = output.indexOf(substring)  substring=neshtoSi
                    //while (firstIndex != -1)  ======   firstIndex = output.indexOf(substring) ----- Реално влизаме в безкраен цикъл

                    //И така общо взето това са дребни грешки от недоглеждане пожелавам ти късмет
                    //П.П. Ако някъде имам граматически грешки да знаеш че съм неграмотен не е от бързане,аз мога да пиша само на JAVA


                    String saveChecker=output.toString();

                    while (firstIndex != -1) {
                        switch (action) {
                            case "Change":
                                String strongSubstring = tokens[3];
                                output.replace(firstIndex, firstIndex + substring.length(), strongSubstring);
                                break;
                            case "Remove":
                                output.delete(firstIndex, firstIndex + substring.length());
                                break;
                        }
                        firstIndex = output.indexOf(substring);
                    }
                    if(saveChecker.equals(output.toString())){
                        System.out.println("Command doesn't exist!");
                    }else {
                        System.out.println(output);
                    }

                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
            input = scanner.nextLine();
        }
    }
}