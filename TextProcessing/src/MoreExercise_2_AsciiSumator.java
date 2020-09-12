import java.util.Scanner;

public class MoreExercise_2_AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char startPoint = scan.nextLine().charAt(0);
        char endPoint = scan.nextLine().charAt(0);
        String text = scan.nextLine();

        int sum = 0;
        for (int i = 0; i <text.length() ; i++) {
            int ascii = text.charAt(i);
            if(isBetween(startPoint,endPoint,ascii)){
             sum+=ascii;
            }
        }
        System.out.println(sum);
    }

    private static boolean isBetween(char startPoint, char endPoint, int ascii) {
        return startPoint < ascii && ascii < endPoint;
    }
}
