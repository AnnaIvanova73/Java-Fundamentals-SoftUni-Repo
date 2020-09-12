import java.util.Scanner;

public class ArrStringArrInt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String arraysAsSpaceSeparatedValues = scan.nextLine(); //вход

        String[] numbersStrings = arraysAsSpaceSeparatedValues.split(" "); // масив стриннгове
        // използвам функцията split на String, разделям по интервала, зада взема само числата

        int[] containMyNumbers = new int[numbersStrings.length];// правим го в масив от интове,
        // двата са с еднаква големина, тя се определя от входа

        for (int i = 0; i < containMyNumbers.length; i++) {//Пълнене на масив
            // използвам масива, с който работя
            containMyNumbers[i] = Integer.parseInt(numbersStrings[i]);
        }

        for (int i = 0; i < containMyNumbers.length; i++) {
            System.out.println(containMyNumbers[i]);
        }
    }
}
