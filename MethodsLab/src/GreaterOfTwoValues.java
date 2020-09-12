import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeCompare = scan.nextLine();



        switch (typeCompare){
            case"int":
                int firstNum = Integer.parseInt(scan.nextLine());
                int secondNum = Integer.parseInt(scan.nextLine());
                System.out.println(getMax(firstNum,secondNum));
                break;
            case"char":
                char firstSymbol = scan.nextLine().charAt(0);
                char secondSymbol =scan.nextLine().charAt(0);
                System.out.println(getMax(firstSymbol,secondSymbol));
                break;
            case "string":
                String firstString = scan.nextLine();
                String secondString = scan.nextLine();
                System.out.println(getMax(firstString,secondString));
                break;
        }
    }

    public static int getMax (int num1,int num2){
        int max = 0;
           if(num1>num2){
               max=num1;
           }else{
               max=num2;
           }
           return max;
    }
    public static char getMax (char symbol1, char symbol2){
        if(symbol1>symbol2){
            return symbol1;

        }
        return symbol2;
    }

    public static String getMax (String first, String second){
        String max = " ";
        if (first.compareTo(second) >= 0){
            max=first;
        }else{
            max=second;
        }
        return max;
    }

}
