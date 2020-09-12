import java.util.Scanner;

public class Exercise_6_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String repeatingLetter = scan.nextLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <repeatingLetter.length() -1 ; i++) {
            char first = repeatingLetter.charAt(i);
            char second = repeatingLetter.charAt(i + 1);
            if(first != second){
                result.append(first);
            }
        }
        result.append(repeatingLetter.charAt(repeatingLetter.length()-1));
        System.out.println(result);
    }
}
