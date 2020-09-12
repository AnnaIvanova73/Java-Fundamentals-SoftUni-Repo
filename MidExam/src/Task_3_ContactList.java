import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_3_ContactList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> contactBook = getMyContacts(scan);

        String standard = "Print Normal";
        String reverse = "Print Reversed";

        String input = scan.nextLine();
        while (!standard.equals(input) && !reverse.equals(input)) {
            String[] tokens = input.split("\\s+");
            String cmdArg = tokens[0];
            int index;
            boolean isValid;
            switch (cmdArg) {
                case "Add":
                    String contact = tokens[1];
                    index = Integer.parseInt(tokens[2]);
                    isValid = checkExistence(index, contactBook);
                    if (contactBook.contains(contact)) {
                        if (isValid) {
                            contactBook.add(index, contact);
                        }
                    } else {
                        contactBook.add(contact);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    isValid = checkExistence(index, contactBook);
                    if (isValid) {
                        contactBook.remove(index);
                    }
                    break;
                case "Export":
                    index = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    printWithParameters(index, count, contactBook);
                    break;
            }

            input = scan.nextLine();
        }

        if (standard.equals(input)) {
            printContactBook(contactBook);
        } else {
            Collections.reverse(contactBook);
            printContactBook(contactBook);
        }
    }

    private static void printContactBook(List<String> contactBook) {
        System.out.print("Contacts: ");
        for (String s : contactBook) {
            System.out.print(s + " ");
        }
    }

    private static void printWithParameters(int index, int count, List<String> contactBook) {
        int counter = 0;
        for (int i = index; i < contactBook.size(); i++) {
            String currElement = contactBook.get(i);
            System.out.print(currElement + " ");
            counter++;
            if (counter == count) {
                break;
            }
        }
        System.out.println();
    }

    private static boolean checkExistence(int contactOrIndex, List<String> list) {
        if (contactOrIndex >= 0 && contactOrIndex < list.size()) {
            return true;
        }
        return false;
    }

    private static List<String> getMyContacts(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        List<String> list = new ArrayList<>();
        for (String currentElement : input) {
            list.add(currentElement);
        }
        return list;
    }
}
