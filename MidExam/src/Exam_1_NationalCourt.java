import java.util.Scanner;

public class Exam_1_NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstEmp = Integer.parseInt(scan.nextLine());
        int secondEmp = Integer.parseInt(scan.nextLine());
        int thirdEmp = Integer.parseInt(scan.nextLine());
           int peopleCount = Integer.parseInt(scan.nextLine());
        int answeredPerHour = firstEmp + secondEmp + thirdEmp;

        int hours = 0;
        int counter = 0;
        int answered = 0;
        while( peopleCount > answered){
            counter++;
            if( counter % 4 != 0){
                answered+=answeredPerHour;
                hours++;
            }
        }

        System.out.printf("Time needed: %dh.", counter);

    }
}
