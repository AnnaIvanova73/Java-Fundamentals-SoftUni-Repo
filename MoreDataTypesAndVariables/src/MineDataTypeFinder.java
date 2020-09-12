import java.util.Scanner;

public class MineDataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        while (!"End".equals(input)) {
            boolean isNumInt = true;

            try {
                int inputToInt = Integer.parseInt(input); // за инт - инт дава true
            } catch (NumberFormatException e ) {
               // System.out.println(e);
                isNumInt = false;
            }

            boolean isNumDouble = true;

            try {
                double inputToDouble = Double.parseDouble(input); //  за инт - double Хвърля true
            } catch (NumberFormatException e) { // exceptions are different types !!!
                isNumDouble = false;
            }

            if (isNumInt) { // проверяваме първо за инт число,защото double побира инт и също е дал true,
                // ще влезе в неговата проверка
                System.out.printf("%s is integer type\n", input);
            } else if (isNumDouble) {
                System.out.printf("%s is floating point type\n", input);
            } else if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
                System.out.printf("%s is boolean type\n", input);

            } else if (input.length() > 1) { // ако думата  има повече от една стойности
                System.out.printf("%s is string type\n", input);
            } else {
                System.out.printf("%s is character type\n", input);
            }

            input = scan.nextLine();

            if ("end".equalsIgnoreCase(input)){
                break;
            }
        }

    }
}
