import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputsCount = Integer.parseInt(scan.nextLine());
        //asbsd
        //ABSDF
        //123456
        Pattern patternValidPass = Pattern.compile
                ("^" +//от началото на линията
                        "(.+)" + // мачтни ми всички символи и ги запази в група едно
                        ">" +// разделител за цялата група начален
                        "(?<nums>\\d{3})" +//само числа ограничени до три
                        "\\|" +//разделител вътрешни групи
                        "(?<low>[a-z]{3})" + // мачни само първите три малки букви
                        "\\|" +
                        "(?<upper>[A-Z]{3})" +// първите три UpperCase
                        "\\|" +
                        "(?<symbols>[^<>]{3})" +//трета група може да съдържа всики символи, до три на брой слагам само това,коети
                        // не искам да съдържа като знаци м/д скобите
                        "<" +// разделител за цялата група краен
                        "\\1" + // мачва същите символи, които групата му е намерил, в случая пурва група има символи,
                        // ще търси същите символи накрая това е backref \1 matches the same text as most recently matched by the 1st capturing group
                        "$")// поставя позиция на края на линията, и обозначава края и
                ;


        StringBuilder validPass = new StringBuilder();
        for (int i = 0; i <inputsCount ; i++) {
            String password = scan.nextLine();
            Matcher match  = patternValidPass.matcher(password);

            if(match.find()){
                validPass.append(match.group("nums"));
                validPass.append(match.group("low"));
                validPass.append(match.group("upper"));
                validPass.append(match.group("symbols"));
                System.out.println("Password: "+validPass);
                validPass.setLength(0);

            }else{
                System.out.println("Try another password!");
            }
        }
    }
}
