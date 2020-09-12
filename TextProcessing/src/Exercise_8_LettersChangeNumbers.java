import java.util.Scanner;

public class Exercise_8_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strings = scan.nextLine().split("\\s+");

        double sum = 0;

        for (String string : strings) {
            char firstLetter = string.charAt(0);
            char lastLetter = string.charAt(string.length() - 1);
            String substrNumber = string.substring(1, string.length() - 1);
            int number = Integer.parseInt(substrNumber);
            double currentSum = number * 1.0;

            if (isUpperLetter(firstLetter)) {
                currentSum /= getPositionInAlphabet(firstLetter);
            } else {
                currentSum *= getPositionInAlphabet(firstLetter);
            }

            if (isUpperLetter(lastLetter)) {
                currentSum -= getPositionInAlphabet(lastLetter);
            } else {
                currentSum += getPositionInAlphabet(lastLetter);
            }
            sum+=currentSum;
        }

        System.out.printf("%.2f", sum);
    }

    private static boolean isUpperLetter(char letter) {
        if (letter > 64 && letter < 91) {
            return true;
        }
        return false;
    }


    private static int getPositionInAlphabet(char letter) {
        int asciiLetter = letter;
        if (letter > 64 && letter < 91) {
            asciiLetter -= 64;
        } else {
            asciiLetter -= 96;
        }
        return asciiLetter;
    }

}