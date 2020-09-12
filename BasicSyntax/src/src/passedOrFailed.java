import java.util.Scanner;

public class passedOrFailed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double grade = Double.parseDouble(scan.nextLine());

        if (grade<3){
            System.out.println("Failed!");
        }else {
            System.out.println("Passed!");
        }
    }
}
