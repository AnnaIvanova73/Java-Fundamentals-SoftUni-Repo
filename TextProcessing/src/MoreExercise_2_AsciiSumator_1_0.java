import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreExercise_2_AsciiSumator_1_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char startPoint = scan.nextLine().charAt(0);
        startPoint+=1;
        char endPoint = scan.nextLine().charAt(0);
        endPoint-=1;
        String text = scan.nextLine();

        String regex = String.format("[%c-%c]",startPoint,endPoint);
        Pattern pattern = Pattern.compile(regex);
        int sum = 0;
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String matches = matcher.group();
            sum += getSum(matches);
        }
        System.out.println(sum);
    }

    private static int getSum(String string) {
        int sum = 0;
        for (int i = 0; i < string.length() ; i++) {
            int ascii = string.charAt(i);
            sum+=ascii;
        }
        return sum;
    }


}
