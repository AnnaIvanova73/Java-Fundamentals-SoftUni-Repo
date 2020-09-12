import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreExercise_Task_4_SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int key = Integer.parseInt(scan.nextLine());
        String regex = "@(?<name>[a-zA-Z]+)([^@\\-!:>]+)!(?<behavior>[GN])!";
        Pattern pattern = Pattern.compile(regex);

        String messages = scan.nextLine();
        while(!"end".equals(messages)){
            messages  = getDecrypt(key,messages);
            Matcher matcher = pattern.matcher(messages);
            if(matcher.find()){
                String name = matcher.group("name");
                String type = matcher.group("behavior");
                if(type.equals("G")){
                    System.out.println(name);
                }
            }

            messages=scan.nextLine();
        }
    }

    private static String getDecrypt(int key, String messages) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <messages.length(); i++) {
            int ascii = messages.charAt(i);
            builder.append((char)(ascii-key));
        }
        return  builder.toString();
    }
}
