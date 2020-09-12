import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amountPeople = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();

        double singlePersonPrice = 0;

        switch (day) {
            case "Friday":

                switch (groupType) {
                    case "Students":
                        singlePersonPrice = 8.45;
                        break;
                    case "Business":
                        singlePersonPrice = 10.90;
                        break;
                    case "Regular":
                        singlePersonPrice = 15;
                        break;
                }

                break;

            case "Saturday":

                switch (groupType) {
                    case "Students":
                        singlePersonPrice = 9.80;
                        break;
                    case "Business":
                        singlePersonPrice = 15.60;
                        break;
                    case "Regular":
                        singlePersonPrice = 20;
                        break;
                }

                break;

            case "Sunday":

                switch (groupType) {
                    case "Students":
                        singlePersonPrice = 10.46;
                        break;
                    case "Business":
                        singlePersonPrice = 16;
                        break;
                    case "Regular":
                        singlePersonPrice = 22.50;
                        break;
                }

                break;
        }

        double totalPrice = singlePersonPrice * (amountPeople * 1.0 );

        if ("Students".equals(groupType) && amountPeople >= 30){
            totalPrice *= 0.85;
        }
         else if ("Business".equals(groupType) && amountPeople >= 100){

            totalPrice= singlePersonPrice * (amountPeople - 10);
        }
        else if ("Regular".equals(groupType) && (amountPeople >= 10) && (amountPeople <= 20)){
            totalPrice *= 0.95;
        }

        System.out.printf("Total price: %.2f",totalPrice);
    }
}
