import java.util.Scanner;

public class padawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int amountOfStudents = Integer.parseInt(scan.nextLine());

        double lightsabersPrisePair = Double.parseDouble(scan.nextLine());
        double robesSinglePrice = Double.parseDouble(scan.nextLine());
        double beltsSinglePrice = Double.parseDouble(scan.nextLine());

        int beltsFree = amountOfStudents / 6;


        double spends = Math.ceil(amountOfStudents * 1.1) * lightsabersPrisePair
                + robesSinglePrice * amountOfStudents
                + beltsSinglePrice * (amountOfStudents - beltsFree);

        if (budget >= spends) {
            System.out.printf("The money is enough - it would cost %.2flv.", spends);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", spends - budget);
        }
    }
}
