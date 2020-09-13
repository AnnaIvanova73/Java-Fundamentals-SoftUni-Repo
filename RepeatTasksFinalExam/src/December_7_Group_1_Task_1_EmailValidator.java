import java.util.Scanner;

public class December_7_Group_1_Task_1_EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userEmail = scan.nextLine();

        String input = scan.nextLine();
        while(!"Complete".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){

                case"Make":
                    String additional = tokens[1];
                    if(additional.equals("Upper")){
                        userEmail = userEmail.toUpperCase();
                        System.out.println(userEmail);
                    }else{
                        userEmail = userEmail.toLowerCase();
                        System.out.println(userEmail);
                    }
                    break;
                case"GetDomain":
                    int lastSymbols = Integer.parseInt(tokens[1]);
                    System.out.println(userEmail.substring(userEmail.length()-lastSymbols));
                    break;
                case"GetUsername":
                    if(!userEmail.contains("@")){
                        System.out.println("The email " + userEmail + " doesn't contain the @ symbol.");
                        break;
                    }
                    int indexUser = userEmail.lastIndexOf("@");
                    System.out.println(userEmail.substring(0,indexUser));
                    break;
                case"Replace":
                    String currentChar = tokens[1];
                    userEmail = userEmail.replace(currentChar,"-");
                    System.out.println(userEmail);
                    break;
                case"Encrypt":
                    String ascii = getAcsiiValue(userEmail);
                    System.out.println(ascii.trim());
                    break;
            }
            input=scan.nextLine();
        }
    }
    private static String getAcsiiValue(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <string.length() ; i++) {
            int ascii = string.charAt(i);
            builder.append(ascii).append(" ");
        }
        return builder.toString();
    }
}
