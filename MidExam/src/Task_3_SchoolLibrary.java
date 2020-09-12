import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_SchoolLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shelf = getBooks(scan);

        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\|+");
            String commands = tokens[0].trim();
            String bookName = "";
           switch (commands) {
               case "Add Book":
                   bookName = tokens[1].trim();
                   if(!shelf.contains(bookName)){
                       shelf.add(0,bookName);
                   }
                   break;
               case "Take Book":
                   bookName = tokens[1].trim();
                   shelf.remove(bookName);
                   break;
               case "Swap Books":
                   bookName = tokens[1].trim();
                   String bookSecond = tokens[2].trim();
                   swapBooks(shelf, bookName, bookSecond);
                   break;
               case"Insert Book":
                   bookName=tokens[1].trim();
                   shelf.add(bookName);
                   break;
               case"Check Book":
                   String hateSpaces = tokens[1].trim();
                   int bookPlace = Integer.parseInt(hateSpaces);
                   if (bookPlace < shelf.size() && bookPlace >=0){
                       System.out.println(shelf.get(bookPlace));
                   }
                   break;
           }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ",shelf));
    }

    private static void swapBooks(List<String> shelf, String bookName, String bookSecond) {
        if(shelf.contains(bookName) && shelf.contains(bookSecond)){
            int placeFirstBook = shelf.indexOf(bookName);
            int placeSecondBook = shelf.indexOf(bookSecond);
            String swap = bookName;
            shelf.set(placeFirstBook,bookSecond);
            shelf.set(placeSecondBook,swap);
        }
    }

    private static List<String> getBooks(Scanner scan) {
        String[] input = scan.nextLine().split("&+");
        List<String> myList = new ArrayList();
        for (String element : input) {
            myList.add(element);
        }
        return myList;
    }
}
