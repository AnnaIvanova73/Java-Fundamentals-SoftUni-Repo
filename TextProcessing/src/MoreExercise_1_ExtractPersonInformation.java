import java.util.Scanner;

public class MoreExercise_1_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countLines = Integer.parseInt(scan.nextLine());

        while(countLines > 0){
            String input = scan.nextLine();

            int indexNameStart = input.indexOf("@");
            int indexNameEnd = input.indexOf("|");
            String name = input.substring(indexNameStart + 1,indexNameEnd);

            int startAgeIndex = input.indexOf("#");
            int endAgeIndex = input.indexOf("*");
            String age = input.substring(startAgeIndex+1,endAgeIndex);

            System.out.println(name + " is " + age + " years old.");

            countLines--;
        }
    }
}
