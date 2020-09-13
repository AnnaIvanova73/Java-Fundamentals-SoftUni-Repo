import javafx.css.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task_3_TheIsleofManTTRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String coordinates = "";
        while (coordinates.equals("")){
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("^([#$%*&])(?<name>[a-zA-z]+)(\\1)=(?<length>\\d+)!!(?<hashcode>.+)$");
            Matcher match = pattern.matcher(input);

            if(match.find()){
                String name = match.group("name");
                int length = Integer.parseInt(match.group("length"));
                String hashCode = match.group("hashcode");

                if(length == hashCode.length()){
                    coordinates =name + " -> " + encrypt(hashCode,length);
                    break;
                }

            }
            System.out.println("Nothing found!");
        }
        System.out.println("Coordinates found! "+coordinates);
    }

    private static String encrypt(String hashCode, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <hashCode.length() ; i++) {
            char ch = hashCode.charAt(i);
            ch = (char)(ch + length);
            builder.append(ch);
        }
        return  builder.toString();
    }
}
