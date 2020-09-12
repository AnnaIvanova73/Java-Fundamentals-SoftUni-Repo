import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_3_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> legendary = new TreeMap<>() {{
            put("fragments", 0);
            put("shards", 0);
            put("motes", 0);
        }};
        Map<String, Integer> junk = new TreeMap<>();

        boolean isObtained = false;

        while (!isObtained) {
            String[] tokens = scan.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if (legendary.containsKey(material)) {
                    addItem(legendary, material, quantity);
                    isObtained = hasLegendary(legendary, material);
                    if (isObtained) {
                        break;
                    }
                } else {
                    addItem(junk, material, quantity);
                }
            }

        }

        legendary
                .entrySet()
                .stream()
                .sorted((l1, l2) -> Integer.compare(l2.getValue(), l1.getValue()))
                .forEach(l -> System.out.println(String.format("%s: %d", l.getKey(), l.getValue())));

        junk
                .forEach((k, v) -> {
                    System.out.println(String.format("%s: %d", k, v));
                });
    }

    private static boolean hasLegendary(Map<String, Integer> map, String material) {
        int count = map.get(material);
        if (count >= 250) {
            map.put(material, count - 250);
            switch (material) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    return true;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    return true;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    return true;
            }
        }
        return false;
    }

    private static void addItem(Map<String, Integer> map, String key, int value) {
        map.putIfAbsent(key, 0);
        int count = map.get(key);
        map.put(key, count + value);
    }
}
