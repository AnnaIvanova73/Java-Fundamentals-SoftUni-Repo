import java.util.Scanner;

public class Exercise_6_ReplaceRepeatingChars_Luybo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();

        char baseLetter = input.charAt(0);
        result.append(baseLetter);
        for (int i = 0; i < input.length() ; i++) {
            char currentLetter = input.charAt(i);

            if(baseLetter!=currentLetter){
                result.append(currentLetter);
                baseLetter = currentLetter;
            }
        }
        System.out.println(result);
    }
}
