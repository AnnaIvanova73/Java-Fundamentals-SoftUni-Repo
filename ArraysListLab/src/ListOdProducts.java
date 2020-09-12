import org.w3c.dom.DOMStringList;

import java.util.*;

public class ListOdProducts {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int countOfProducts = Integer.parseInt(scan.nextLine());


        List<String> products = new ArrayList<>();

        for (int i = 0; i < countOfProducts; i++) {
            String currProduct = scan.nextLine();
            products.add(currProduct);
        }
        Collections.sort(products);

        int counter = 0;
        for (String currentProduct : products) {
            counter+=1;
            System.out.printf("%d.%s\n",counter,currentProduct);
        }

    }


}
