import java.util.Scanner;

public class PalindromeIntegers {

    public static boolean isPalindromeCoolCode (String input) {

        int firstIndex = 0;
        int secondIndex = input.length() - 1;

        if(input.length()==1){
            return true;
        }

        while (firstIndex < secondIndex) {


            if (input.charAt(firstIndex) != input.charAt(secondIndex)) {
                return false;
            }

            firstIndex++;
            secondIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!"END".equals(input)) {

            boolean isPalindrome = isPalindromeCoolCode(input);
            input = scan.nextLine();
            System.out.println(isPalindrome);
        }


    }
}


