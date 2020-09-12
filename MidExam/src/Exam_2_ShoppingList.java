import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam_2_ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> groceries = getMyGroceries(scan);

        String input = scan.nextLine();
        while (!"Go Shopping!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String product;
            switch (command) {
                case "Urgent":
                    product=tokens[1];
                    if(groceries.contains(product)){
                        break;
                    }
                    groceries.add(0,product);
                    break;
                case "Unnecessary":
                    product=tokens[1];
                    if(!groceries.contains(product)){
                        break;
                    }
                    groceries.remove(product);
                    break;
                case"Correct":
                    product=tokens[1];
                    String newItem = tokens[2];
                    if(groceries.contains(product)){
                        int index = groceries.indexOf(product);
                        groceries.set(index,newItem);
                        break;
                    }
                    break;
                case"Rearrange":
                    product=tokens[1];
                    if(groceries.contains(product)){
                        String myProduct = product;
                        groceries.remove(product);
                        groceries.add(myProduct);
                    }
                    break;

            }


            input = scan.nextLine();
        }

        System.out.println(String.join(", ",groceries));
    }

    private static List<String> getMyGroceries(Scanner scan) {
        String[] input = scan.nextLine().split("!");
        List<String> myList = new ArrayList<>();
        for (String element : input) {
            myList.add(element);
        }
        return myList;
    }
}
