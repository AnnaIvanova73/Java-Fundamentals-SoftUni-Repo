import java.util.*;

public class Task_3_HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> heroes = new HashMap<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.printf("%s is already enrolled.\n", heroName);
                        break;
                    }

                    heroes.putIfAbsent(heroName, new ArrayList<>());
                    break;
                case "Learn": {
                    String spellName = tokens[2];

                    if (!heroes.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.\n", heroName);
                        break;
                    }
                    if (heroes.containsKey(heroName)) {

                        if (!heroes.get(heroName).contains(spellName)) {
                            heroes.get(heroName).add(spellName);
                        } else {
                            System.out.printf("%s has already learnt %s.\n", heroName, spellName);
                        }

                    }
                }
                break;
                case "Unlearn": {
                    String spellName = tokens[2];

                    if (!heroes.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.\n", heroName);
                        break;
                    }
                    if (heroes.containsKey(heroName)) {

                        if (!heroes.get(heroName).contains(spellName)) {
                            System.out.printf("%s doesn't know %s.\n", heroName, spellName);
                            break;
                        } else {
                            heroes.get(heroName).remove(spellName);
                        }

                    }
                }
                break;

            }
            input = scan.nextLine();
        }

        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    //  .sorted(Comparator.comparingInt((Map.Entry<String, List<String>> a) -> a.getKey().length()).thenComparing(Map.Entry::getKey))
                    int sumA = a.getValue().size();
                    int sumB = b.getValue().size();
                    int compare = Integer.compare(sumB, sumA);
                    if (compare == 0) {
                        compare = a.getKey().compareTo(b.getKey());
                    }
                    return compare;
                })
                .forEach((a) -> {
                    System.out.printf("== %s: ", a.getKey());
                    System.out.println(String.join(", ", a.getValue()));
                });
    }
}
