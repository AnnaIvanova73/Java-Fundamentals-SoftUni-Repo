import java.util.*;

public class MoreExercise_4_MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?" };

        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };


        List<String> english = new ArrayList<>(Arrays.asList(alphabet));
        List<String> morseCode = new ArrayList<>(Arrays.asList(morse));


        String[] input = scan.nextLine().split("\\s+");

        StringBuilder message = new StringBuilder();

        for (String element : input) {
            if(element.equals("|")){
                message.append(" ");
            }else{
                int index = morseCode.indexOf(element);
                String letter = english.get(index);
                message.append(letter);
            }

        }
        System.out.println(message.toString().toUpperCase());
    }
}
