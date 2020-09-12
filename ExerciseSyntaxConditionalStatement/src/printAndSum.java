import java.util.Scanner;

public class printAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = first; i <= second ; i++) {
            System.out.printf("%d ",i);
            sum+=i;
        }
        System.out.printf("%nSum: %d",sum);
    }
}
