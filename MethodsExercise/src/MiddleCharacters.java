import java.util.Scanner;

public class MiddleCharacters {

    public static String middleCharacterInString (String str){
        int position = 0;
        int length = 0;

        if(str.length() % 2 == 0){

            position = (str.length()/2)-1;
            length = 2;

        }else{

            position=(str.length()/2);
            length=1;
        }
        return str.substring(position,position+length);
    }
    public static void returnMiddle (String str){

        int indexBegin=0;
        int indexEnd = 0;

        if(str.length() % 2 == 0){

            indexBegin = str.length()/2 -1;
            indexEnd = indexBegin + 2;
        }else {
            indexBegin=str.length()/2;
            indexEnd=indexBegin+1;
        }

        for (int i = indexBegin; i <indexEnd; i++) {
              char symbol = str.charAt(i);
              System.out.print(symbol);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

         returnMiddle(input);

    }
}
