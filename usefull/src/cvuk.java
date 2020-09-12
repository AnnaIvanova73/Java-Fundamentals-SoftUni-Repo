import java.util.Scanner;

public class cvuk {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = "first 81234 even";
        String input = "";

        while (!"end".equals(str = scan.nextLine())) {

            String[] command = str.split("\\s+");

            String s = command[0];
            boolean something = "exchange".equals(command[0]);

        }
    }


}




