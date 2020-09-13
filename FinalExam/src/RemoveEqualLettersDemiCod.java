import java.util.Scanner;

public class RemoveEqualLettersDemiCod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruits = "banana, apple, kiwi, banana";
        System.out.println(fruits.lastIndexOf("banana")); // 21, реално Б е на 22
        System.out.println(fruits.lastIndexOf("orange"));// -1
        System.out.println(fruits.indexOf("apple"));// 8 започва от девети
        System.out.println(fruits.lastIndexOf("apple"));//8 търси последното появяване на стринга и дава индекса преди началния
        String asd = scan.nextLine();

        if(fruits.contains(asd)){
            System.out.println(asd);
        }




//        String messagesEncrypted = scan.nextLine().toUpperCase();
//
//        StringBuilder decrypted = new StringBuilder();
//
//        for (int i = 0; i < messagesEncrypted.length(); i++) {
//
//            char symbol = messagesEncrypted.charAt(i);
//
//            if (Character.isAlphabetic(symbol)) {
//                String symbolAppend = String.valueOf(messagesEncrypted.charAt(i));
//                decrypted.append(symbolAppend);
//
//                while (messagesEncrypted.contains(symbolAppend)) {
//                    messagesEncrypted = messagesEncrypted.replaceAll(symbolAppend, "");
//                }
//
//                i -= 1;
//            } else {
//                decrypted.append(messagesEncrypted.charAt(i));
//            }
//        }
//        System.out.println(decrypted);

    }
}
