
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite_Rumen {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        String command;
        while (!((command = console.nextLine()).equals("Once upon a time"))) {
            String[] tokens = command.split(" <:> ");
            String name = tokens[0];
            String colour = tokens[1];
            int points = Integer.parseInt(tokens[2]);
            map.putIfAbsent(colour, new LinkedHashMap<>());
            if (map.get(colour).containsKey(name)) {
                int currentPoints = map.get(colour).get(name);
                if (currentPoints < points) {
                    map.get(colour).put(name, points);
                }
            } else {
                map.get(colour).put(name, points);
            }
        }
        Map<String, Integer> map2 = new LinkedHashMap<>();
        for (String colour : map.keySet()) {
            for (String name : map.get(colour).keySet()) {
                map2.put(name + " " + colour + " " + map.get(colour).size(), map.get(colour).get(name));
            }
        }
        map2.entrySet().stream().sorted((a1, a2) -> {
            int sort = a2.getValue() - a1.getValue();
            if (sort == 0) {
                String[] tokens1 = a1.getKey().split(" ");
                String[] tokens2 = a2.getKey().split(" ");
                if (sort == 0) {
                    int a1Count = Integer.parseInt(tokens1[2]);
                    int a2Count = Integer.parseInt(tokens2[2]);
                    sort = a2Count - a1Count;
                }
            }
            return sort;
        })
                .forEach(b -> {
                    String[] tokens = b.getKey().split(" ");
                    System.out.println(String.format("(%s) %s <-> %d", tokens[1], tokens[0], b.getValue()));
                });
        int r = 0;
    }
}