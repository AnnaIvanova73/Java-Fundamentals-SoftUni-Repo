import java.util.Scanner;

public class brackets {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scan.nextLine());

        int firstBalanced = 0;
        int secondBalanced = 0;
        boolean balanced = true;
        boolean has = false;


        for (int counter = 1; counter <= numberOfLines; counter++) {

            String input = scan.nextLine();

            if (has && "(".equals(input)) {
                System.out.println("UNBALANCED");
                balanced = false;
                break;
            } else {
                has = false;
            }
            if ("()".equals(input)) {
                System.out.println("UNBALANCED");
                balanced = false;
                break;
            }
            if ("(".equals(input)) {
                firstBalanced++;
                has = true;
            } else if (")".equals(input)) {
                secondBalanced++;
            }
            if ("(".equals(input) && counter == numberOfLines) {
                System.out.println("UNBALANCED");
                balanced = false;
                break;
            }


        }
        if (balanced) {
            if (firstBalanced == secondBalanced) {
                System.out.println("BALANCED");
            } else {
                System.out.println("UNBALANCED");
            }


        }
    }
}