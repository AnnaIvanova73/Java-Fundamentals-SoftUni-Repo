import java.util.Scanner;

public class fromDataTypesPoundToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pounds = Integer.parseInt(scan.nextLine());
      //  int pounds = new Scanner(System.in).nextInt();//  отдели внимание тук ! run time error
        //  в java , прави програмата по бавна ?
        int cents = pounds * 100;
        double usdCents = cents * 1.31;
        double usdDollars = usdCents / 100;

        System.out.print(String.format("%.3f",usdDollars));
    }
}
