import java.util.*;
import java.util.stream.Collectors;

public class Api_Demo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, String> products = new HashMap<>(){{
            put(1,"c");
            put(2,"b");
            put(3,"a");

        }};

        products.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    System.out.println(res);
                    if (res == 0)
                        res = e1.getKey().compareTo(e2.getKey());
                    return res; })
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));


        System.out.println();
        System.out.println();

        Map<String, ArrayList<Integer>> arr = new HashMap<>(){{
            String a = "a";
            String b = "a";
            putIfAbsent(a,new ArrayList<>());
            putIfAbsent(b,new ArrayList<>());
            get(a).add(55);
            get(a).add(67);
            get(b).add(9);
        }};
        arr.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getKey().compareTo(b.getKey()) == 0) {
                        int sumFirst = a.getValue().stream().mapToInt(x -> x).sum();
                        int sumSecond = b.getValue().stream().mapToInt(x -> x).sum();
                        System.out.println("asd");
                        System.out.println("asd");
                        return sumFirst - sumSecond;

                    }

                    return b.getKey().compareTo(a.getKey());
                })
                .forEach(pair -> {
            System.out.println("Key: " + pair.getKey());
            System.out.print("Value: ");
            pair.getValue().sort((a, b) -> a.compareTo(b));
            for (int num : pair.getValue()) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        });

        System.out.println();

        List<Integer> numberss = Arrays
                .stream(scan.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .collect(Collectors.toList());
        for (int num : numberss) {
            System.out.print(num + " ");
        }





    }
}
