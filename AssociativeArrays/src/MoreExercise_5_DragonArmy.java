import java.util.*;

public class MoreExercise_5_DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dragonsCount = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<Integer>>> dragonsRecords = new LinkedHashMap<>();

        for (int i = 0; i < dragonsCount; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = getDamage(tokens[2]);
            int health = getHealth(tokens[3]);
            int armor = getArmor(tokens[4]);

            if (!dragonsRecords.containsKey(type)) {
                dragonsRecords.put(type, new TreeMap<>());

            }

            if (dragonsRecords.containsKey(type) && dragonsRecords.get(type).containsKey(name)) {
                dragonsRecords.get(type).get(name).set(0, damage);
                dragonsRecords.get(type).get(name).set(1, health);
                dragonsRecords.get(type).get(name).set(2, armor);
            } else {
                dragonsRecords.get(type).put(name, new ArrayList<>());
                dragonsRecords.get(type).get(name).add(0, damage);
                dragonsRecords.get(type).get(name).add(1, health);
                dragonsRecords.get(type).get(name).add(2, armor);
            }


        }

        dragonsRecords
                .forEach((key, value) -> {
                    System.out.print(key + "::");
                    double damage = 0;
                    double health = 0;
                    double armor = 0;
                    int size = value.keySet().size();
                    for (Map.Entry<String, List<Integer>> values : value.entrySet()) {
                        damage += values.getValue().get(0);
                        health += values.getValue().get(1);
                        armor += values.getValue().get(2);
                    }
                    System.out.printf("(%.2f/%.2f/%.2f)%n", damage / size, health / size, armor / size); //average stats

                    value.forEach((key1, value1) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                            , key1, value1.get(0), value1.get(1), value1.get(2)));

                });
    }

    private static int getArmor(String token) {
        int defaultStat = 10;
        if (token.equals("null")) {
            return defaultStat;
        }

        return defaultStat = Integer.parseInt(token);
    }

    private static int getHealth(String token) {
        int defaultStat = 250;
        if (token.equals("null")) {
            return defaultStat;
        }

        return defaultStat = Integer.parseInt(token);
    }

    private static int getDamage(String token) {
        int defaultStat = 45;
        if (token.equals("null")) {
            return defaultStat;
        }

        return defaultStat = Integer.parseInt(token);
    }
}
