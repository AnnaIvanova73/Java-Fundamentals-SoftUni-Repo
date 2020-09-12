import java.util.Random;
import java.util.Scanner;

public class Lab_1_RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] words = scan.nextLine().split("\\s+");

        Random random = new Random();

        for (int i = 0; i <words.length ; i++) {
            int swapIndex = random.nextInt(words.length);
            String swap = words[i];
            words[i] = words[swapIndex];
            words[swapIndex] = swap;
        }
        for (int i = 0; i <words.length ; i++) {
            System.out.println(words[i]);
        }
    }
}
