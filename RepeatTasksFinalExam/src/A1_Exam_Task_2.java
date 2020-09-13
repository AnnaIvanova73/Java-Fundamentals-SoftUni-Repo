import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1_Exam_Task_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^@(#+)([A-Z][a-zA-Z0-9]{4,}[A-Z])@(#+)$";
        Pattern pattern = Pattern.compile(regex);

        int countOfInputs = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < countOfInputs ; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if(!matcher.find()){
                System.out.println("Invalid barcode");
                continue;
            }

            String barcode = matcher.group(2);
            barcode = getBarcode(barcode);
            System.out.println("Product group: " + barcode);
        }
    }

    private static String getBarcode(String barcode) {
        StringBuilder result = new StringBuilder();
        boolean hasNum = false;
        for (int i = 0; i <barcode.length() ; i++) {
            char ch = barcode.charAt(i);
            if(Character.isDigit(ch)){
                result.append(ch);
                hasNum = true;
            }
        }

        if(hasNum){
            return result.toString();
        }else{
            return "00";
        }
    }
}
