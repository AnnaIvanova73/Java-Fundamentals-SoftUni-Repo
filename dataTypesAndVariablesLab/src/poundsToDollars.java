import java.util.Scanner;

public class poundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double pounds = Double.parseDouble(scan.nextLine());
        double usdDollars = pounds * 1.31;

        System.out.print(String.format("%.3f",usdDollars));
    }
}
