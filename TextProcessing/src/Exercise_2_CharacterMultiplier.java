import java.util.Scanner;

public class Exercise_2_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strings = scan.nextLine().split("\\s+");

        String first = strings[0];
        String second = strings[1];

        int min = Math.min(strings[0].length(), strings[1].length());
        int max = Math.max(strings[0].length(), strings[1].length());

        int sum = 0;

        for (int i = 0; i < max; i++) {

            if (i < min) {
                sum += first.charAt(i) * second.charAt(i);
            } else if (first.length() == max) {
                sum += first.charAt(i);
            } else {
                sum += second.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
