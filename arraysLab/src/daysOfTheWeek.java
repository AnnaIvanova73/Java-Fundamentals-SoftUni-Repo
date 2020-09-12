import java.util.Scanner;

public class daysOfTheWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputDay = Integer.parseInt(scan.nextLine());

        String[] daysOfTheWeek = new String[]{"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"
        };

        if (inputDay > 0 && inputDay < 8) {
            System.out.println(daysOfTheWeek[inputDay - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
