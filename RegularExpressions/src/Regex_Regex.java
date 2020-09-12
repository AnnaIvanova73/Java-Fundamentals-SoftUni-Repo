package SoftUniFund.RegEx.More;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        String firstPart = input[0];
        String secondPart = input[1];
        String thirdPart = input[2];
        LinkedHashMap<Character, Integer> letters = new LinkedHashMap<>();
        //малко съм ти преправил патърна, номисля, че и твоя вървеше правилно
        Pattern patternText = Pattern.compile("([#$%*&])([A-Z]+)\\1");
        Matcher matcherText = patternText.matcher(firstPart);

        String capitalLetters = "";
        while (matcherText.find()) {
            String current = matcherText.group();
            capitalLetters = current.substring(1, current.length() - 1);
        }


        //([65-90]{1,2})\:([0-9]{2})

        for (int i = 0; i < capitalLetters.length(); i++) {
            char symbol = capitalLetters.charAt(i);

            // патърна съм го вкарал в лупа, за да се инициализира на ново всеки път!
            Pattern patternDigits = Pattern.compile("([0-9]{2}):([0-9]{2})");
            Matcher matcherDigits = patternDigits.matcher(secondPart);

            while (matcherDigits.find()) {
                String current = matcherDigits.group();
                String[] digits = current.split(":");
                int asciiCode = Integer.parseInt(digits[0]);
                int length = Integer.parseInt(digits[1]);

                //добавил съм и едно условие , да не презаписва дължината на думата, ако вече сме записали ентри с този ключ
                // (в противен случай ще ъпдейтне стойноста с последната намерена, а на нас ни трябва първата намерена
                if (symbol == asciiCode && !letters.containsKey(symbol)) {
                    letters.put(symbol, length + 1);
                    break;
                }
            }
        }

        String[] thirdText = thirdPart.split("\\s+");
        for (int i = 0; i < capitalLetters.length(); i++) {

            char firstLetter = capitalLetters.charAt(i);
            int length = letters.get(firstLetter);

            for (String word : thirdText) {

                int lengthWord = word.length();
                String wordFirstChar = word.substring(0, 1);
                char firstChar = wordFirstChar.charAt(0);

                if (lengthWord == length && firstLetter == firstChar) {
                    System.out.println(word);
                }
            }

        }
    }
}