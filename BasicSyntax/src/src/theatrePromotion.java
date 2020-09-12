import java.util.Scanner;

public class theatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeDay = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        if ( age < 0 || age > 122){
            System.out.println("Error!");
        }

        if (0 <= age && age <= 18) {
            switch (typeDay) {
                case "Weekday":
                    System.out.println("12$");
                    break;
                case "Weekend":
                    System.out.println("15$");
                    break;
                case "Holiday":
                    System.out.println("5$");
                    break;

            }

        } else if (18 < age && age <= 64) {
            switch (typeDay) {
                case "Weekday":
                    System.out.println("18$");
                    break;
                case "Weekend":
                    System.out.println("20$");
                    break;
                case "Holiday":
                    System.out.println("12$");
                    break;

            }


        } else if (64 < age && age <= 122) {
            switch (typeDay){
                case "Weekday":
                    System.out.println("12$");
                    break;
                case "Weekend":
                    System.out.println("15$");
                    break;
                case "Holiday":
                    System.out.println("10$");
                    break;

            }



        }
    }
}
