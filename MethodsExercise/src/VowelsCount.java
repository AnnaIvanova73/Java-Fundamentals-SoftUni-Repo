import java.util.Scanner;

public class VowelsCount {

    public static int countVowels(String countChars) {
        int result = 0;

        String toLowerCase = countChars.toLowerCase();

        for (int i = 0; i < toLowerCase.length(); i++) {

            char getVowels = toLowerCase.charAt(i);

            if (getVowels == 'a' || getVowels == 'e' || getVowels == 'i' ||
                    getVowels == 'o' || getVowels == 'u')

                result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String elements = scan.nextLine();

        int result = countVowels(elements);

        System.out.println(result);

    }


}
