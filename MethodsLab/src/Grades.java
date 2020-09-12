import java.util.Scanner;

public class Grades {

    public static void printBestGrade(double grade){

      if(grade <= 6 &&grade > 5.49) {
          System.out.println("Excellent");

      }else if(grade >4.49){
          System.out.println("Very good");

      }else if (grade>3.49){
          System.out.println("Good");

      }else if (grade > 2.99){
          System.out.println("Poor");

      }else if (grade>1.99){
          System.out.println("Fail");
      }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double grade = Double.parseDouble(scan.nextLine());

        printBestGrade(grade);
    }
}
