import java.util.Scanner;

public class decryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int keyDecode = Integer.parseInt(scan.nextLine());
        int linesWithLetters = Integer.parseInt(scan.nextLine());

        String message = "";
       // symbols = Character.isAlphabetic()

        for (int i = 1; i <=linesWithLetters ; i++) {
        int symbols =scan.nextLine().charAt(0);
        int decrypt = symbols + keyDecode;
        char messageLetters = (char)decrypt;
        message+=messageLetters;
        }

        System.out.println(message);
    }
}
