import java.util.*;

public class December_13_Task_3_HeroRecruitment_1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> collectionOfHeroes = new HashMap<>();

        String commands = scan.nextLine();
        while (!"End".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];

            String spellName;
            switch (command) {
                case "Enroll":
                    if (collectionOfHeroes.containsKey(heroName)) {
                        System.out.println(heroName + " is already enrolled.");
                        break;
                    }
                    collectionOfHeroes.put(heroName, new ArrayList<>());
                    break;
                case "Learn":
                    spellName = tokens[2];
                    learnSpells(collectionOfHeroes, heroName, spellName);
                    break;
                case "Unlearn":
                    unlearnSpells(collectionOfHeroes, tokens, heroName);
                break;
            }
            commands = scan.nextLine();
        }
        System.out.println("Heroes:");
        collectionOfHeroes.entrySet().stream().sorted((a, b) -> {
            int comp = b.getValue().size() - a.getValue().size();
            if (comp == 0) {
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((a) -> {
            System.out.printf("== %s: ", a.getKey());
            System.out.println(String.join(", ", a.getValue()));
        });
    }

    private static void unlearnSpells(Map<String, List<String>> collectionOfHeroes, String[] tokens, String heroName) {
        String spellName;
        spellName = tokens[2];
        if (!collectionOfHeroes.containsKey(heroName)) {
            System.out.printf("%s doesn't exist.\n", heroName);
            return;
        }
        if (!collectionOfHeroes.get(heroName).contains(spellName)) {
            System.out.printf("%s doesn't know %s.\n", heroName, spellName);
            return;
        }
        collectionOfHeroes.get(heroName).remove(spellName);
    }

    private static void learnSpells(Map<String, List<String>> collectionOfHeroes, String heroName, String spellName) {
        if (!collectionOfHeroes.containsKey(heroName)) {
            System.out.printf("%s doesn't exist.\n", heroName);
            return;
        }
        if (collectionOfHeroes.get(heroName).contains(spellName)) {
            System.out.printf("%s has already learnt %s.\n", heroName, spellName);
            return;
        }
        collectionOfHeroes.get(heroName).add(spellName);
    }
}
