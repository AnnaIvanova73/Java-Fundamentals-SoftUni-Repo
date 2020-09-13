import java.util.*;
public class August_3_Group_2_Task_3_BattleManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> players = new HashMap<>();
        String input;
        while (!(input = scan.nextLine()).equals("Results")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add":
                    int health = Integer.parseInt(tokens[2].trim());

                    if (players.containsKey(username)) {
                        int currentHealth = players.get(username).get(0);
                        players.get(username).set(0, currentHealth + health);
                        break;
                    }
                    int energy = Integer.parseInt(tokens[3].trim());
                    players.put(username, new ArrayList<>());
                    players.get(username).add(0, health);
                    players.get(username).add(1, energy);
                    break;
                case "Attack":
                    String defender = tokens[2].trim();
                    int damage = Integer.parseInt(tokens[3].trim());

                    if (!players.containsKey(username) || !players.containsKey(defender)) {
                        break;
                    }

                    int currentHealth = players.get(defender).get(0);
                    currentHealth -= damage;
                    checkAndPrintStats(players, defender, currentHealth, 0);

                    int currentEnergy = players.get(username).get(1);
                    currentEnergy -= 1;
                    checkAndPrintStats(players, username, currentEnergy, 1);

                    break;
                case "Delete":
                    if (username.equals("All")) {
                        players.clear();
                        break;
                    }
                    players.remove(username);
                    break;
            }
        }

        System.out.println("People count: " + players.keySet().size());
        players.entrySet().stream().sorted((a, b) -> {
            int comp = Integer.compare(b.getValue().get(0), a.getValue().get(0));
            if (comp == 0) {
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((p) -> {
            System.out.print(p.getKey() + " - " + p.getValue().get(0) + " - " + p.getValue().get(1) + "\n");
        });
    }
    private static void checkAndPrintStats(Map<String, List<Integer>> players, String string, int number, int index) {
        if (number <= 0) {
            players.remove(string);
            System.out.println(string + " was disqualified!");
        } else {
            players.get(string).set(index, number);
        }
    }
}
