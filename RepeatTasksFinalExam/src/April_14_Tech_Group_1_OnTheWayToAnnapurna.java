import java.util.*;
import java.util.stream.Collectors;

public class April_14_Tech_Group_1_OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> list = new HashMap<>();
        String input;
        while (!"END".equals(input = scan.nextLine())) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String store = tokens[1];
            switch (command) {
                case "Add":
                    List<String> items = Arrays.stream(tokens[2].split(",")).collect(Collectors.toList());
                    if(!list.containsKey(store)){
                        list.put(store, items);
                        break;
                    }
                    getItemsInList(list,items,store);
                    break;
                case "Remove":
                    list.remove(store);
                    break;
            }
        }
        System.out.println("Stores list:");
        list.entrySet().stream().sorted((a,b) ->{
            int comp = b.getValue().size()-a.getValue().size();
            if(comp == 0){
                comp = b.getKey().compareTo(a.getKey());
            }
            return comp;

        }).forEach(s ->{
            System.out.println(s.getKey());
            s.getValue().forEach(g-> System.out.println("<<" + g + ">>"));
        });
    }
    private static void getItemsInList(Map<String, List<String>> list, List<String> items, String string) {
        for (String item : items) {
            list.get(string).add(item);
        }
    }
}
