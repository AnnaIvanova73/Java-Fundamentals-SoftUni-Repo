import java.util.Scanner;

public class RefactoredPalindromeIntegers {

    public static String isItPalindrome(String input) {

        int firstIndex = 0;
        int secondIndex = input.length() - 1;
        boolean isPalindrome = false;

        if (input.length() == 1) {
            isPalindrome = true;
        }

        while (firstIndex < secondIndex) {
            isPalindrome = true;

            if (input.charAt(firstIndex) != input.charAt(secondIndex)) {
                isPalindrome = false;
            }
            firstIndex++;
            secondIndex--;
        }

        String isIt = "";

        if (isPalindrome) {
            isIt = "true";
        } else {
            isIt = "false";
        }
        return isIt;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!"END".equals(input)) {

            String result = isItPalindrome(input);
            System.out.println(result);
            input = scan.nextLine();
        }
    }


}




