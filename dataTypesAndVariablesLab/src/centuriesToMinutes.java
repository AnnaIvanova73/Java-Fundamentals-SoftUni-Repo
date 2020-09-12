import java.util.Scanner;

public class centuriesToMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCenturies = Integer.parseInt(scan.nextLine());

        int years = inputCenturies * 100;


        Integer days = (int) (years * 365.2422);

        int hours = days * 24;
        int minutes = hours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes",inputCenturies,years,
                days,hours,minutes);

    }
}
