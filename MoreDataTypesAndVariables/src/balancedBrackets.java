import java.util.Scanner;

public class balancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // не разбирам
        int inputLines = Integer.parseInt(scan.nextLine());
        int openingBracketsCount = 0;
        int closingBracketsCount = 0;
        boolean isBalanced = true;

        for (int i = 1; i <= inputLines; i++) {

            String input = scan.nextLine();

            if (input.equals("(")) {
                openingBracketsCount++;
                if (openingBracketsCount - closingBracketsCount >= 2) {
                    isBalanced = false;
                    break;
                }
            } else if (input.equals(")")) {
                closingBracketsCount++;

                if (closingBracketsCount > openingBracketsCount) {
                    isBalanced = false;
                    break;
                }
            }

        }
        if (openingBracketsCount != closingBracketsCount) {
            isBalanced = false;
        }

        if (!isBalanced) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}