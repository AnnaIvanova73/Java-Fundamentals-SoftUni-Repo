import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        while (!"end".equalsIgnoreCase(input)) {

            boolean isFloatingPoint = false;
            boolean isInteger = false;
            boolean isItString= true;

            for (int i = 0; i < input.length(); i++) {

                if ((input.charAt(i) >= '0' && input.charAt(i) <= '9') || input.charAt(i) == '-'
                        && input.charAt(i) =='.') {
                       isInteger=true;
                       isItString=false;
                    if (input.charAt(i) == '.') {
                        isFloatingPoint = true;
                        isInteger=false;
                        isItString=false;
                        break;
                    }


                } else if (input.length() == 1) {
                    isItString=false;
                    isFloatingPoint=false;
                    isInteger=false;
                    System.out.printf("%s is character type\n", input);

                }

            }
            if (input.length() == 1 && input.charAt(0)== '-'){
                isItString=false;
                isFloatingPoint=false;
                isInteger=false;
                System.out.printf("%s is character type\n", input);
                scan.nextLine();
                continue;
            }
            if ("true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input)) {
                isItString=false;
                System.out.printf("%s is boolean type\n", input);
            }
            if(isFloatingPoint){
                System.out.printf("%s is floating point type\n", input);
            }
            if(isInteger){
                System.out.printf("%s is integer type\n", input);
            }
            if(isItString){
                System.out.printf("%s is string type\n", input);
            }
            input = scan.nextLine();
        }
    }
}
