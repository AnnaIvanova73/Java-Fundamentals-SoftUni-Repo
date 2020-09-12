import java.util.Scanner;

public class townInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int population = Integer.parseInt(scan.nextLine());
        short squareKm = Short.parseShort(scan.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.",name,population,squareKm);
    }
}
