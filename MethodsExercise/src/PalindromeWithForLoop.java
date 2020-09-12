import java.util.Scanner;

public class PalindromeWithForLoop {

    public static void palindrome(String input){

        String first = "";
        String second = "";
        for (int i = 0; i <input.length() ; i++) {
            char symbols = input.charAt(i);
            first+=symbols;
        }
        for (int i = input.length() -1; i >= 0 ; i--) {
            char symbols = input.charAt(i);
            second+=symbols;
        }

        if(first.equals(second)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!"END".equals(input)) {

           palindrome(input);
            input = scan.nextLine();
        }

    }
}