import java.util.*;
import java.util.stream.Collectors;

public class Teck_Task_2_OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> listOfStoresAndItems = new HashMap<>();

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String store = tokens[1];


            if (command.equals("Add")) {
                String items = tokens[2];

                if (items.contains(",")) {
                    List<String> collect = Arrays.stream(items.split("[, ]+")).collect(Collectors.toList());
                    if (!listOfStoresAndItems.containsKey(store)) {
                        listOfStoresAndItems.put(store,collect);
                    } else {
                        addInMap(collect, listOfStoresAndItems, store);
                    }

                } else {
                    listOfStoresAndItems.putIfAbsent(store, new ArrayList<>());
                    listOfStoresAndItems.get(store).add(items);
                }

            } else {
                listOfStoresAndItems.remove(store);
            }
            input = scan.nextLine();
        }

        System.out.println("Stores list:");
        listOfStoresAndItems.entrySet().stream()
                .sorted((a,b) ->{
                   int comp =  b.getValue().size()-a.getValue().size();
                   if(comp ==0){
                     comp =   b.getKey().compareTo(a.getKey());
                   }
                   return comp;
                }).forEach((p) ->{
            System.out.println(p.getKey());
            p.getValue().forEach(p2 -> System.out.printf("<<%s>>%n",p2));
        });


    }

    private static void addInMap(List<String> collect, Map<String, List<String>> listOfStoresAndItems, String store) {
        for (String item : collect) {
                listOfStoresAndItems.get(store).add(item);
        }
    }
}
