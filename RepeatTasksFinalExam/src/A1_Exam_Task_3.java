import java.util.*;

public class A1_Exam_Task_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countHero = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> records = new HashMap<>();
        for (int i = 0; i < countHero; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int hitPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);
            if (!records.containsKey(name)) {
                records.put(name, new ArrayList<>());
                records.get(name).add(0, hitPoints);// zero index hit points
                records.get(name).add(1, manaPoints);//first index mana points
            }
        }


        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    int currentHeroMana = records.get(heroName).get(1);
                    int manaAfterSpell = currentHeroMana - manaNeeded;
                    if (manaAfterSpell >= 0) { //todo граничен!
                        records.get(heroName).set(1, manaAfterSpell);
                        System.out.println(heroName + " has successfully cast " +
                                spellName + " and now has " + manaAfterSpell + " MP!");

                    } else {
                        System.out.println(heroName + " does not have enough MP to cast " + spellName + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    int currentHitPower = records.get(heroName).get(0);
                    int afterAttack = currentHitPower - damage;

                    if (afterAttack <= 0) {
                        records.remove(heroName);
                        System.out.println(heroName + " has been killed by " + attacker + "!");
                    } else {
                        records.get(heroName).set(0, afterAttack);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damage, attacker, afterAttack);
                    }

                    break;
                case "Recharge":
                    int amountMP = Integer.parseInt(tokens[2]);
                    int heroMana = records.get(heroName).get(1);
                    int heroAfterreCharge = heroMana + amountMP;
                    if (heroAfterreCharge > 200) {
                        int incWith = 200 - heroMana;
                        records.get(heroName).set(1, 200);
                        System.out.printf("%s recharged for %d MP!%n", heroName, incWith);
                        break;
                    }
                    records.get(heroName).set(1, heroAfterreCharge);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountMP);
                    break;
                case "Heal":
                    int healing = Integer.parseInt(tokens[2]);
                    int heroHit = records.get(heroName).get(0);
                    int heroAfterHill = heroHit + healing;
                    if (heroAfterHill > 100) {
                        int higherWith = 100 - heroHit;
                        records.get(heroName).set(0, 100);
                        System.out.printf("%s healed for %d HP!%n", heroName, higherWith);
                        break;
                    }
                    records.get(heroName).set(0, heroAfterHill);
                    System.out.printf("%s healed for %d HP!%n", heroName, healing);
                    break;
            }
            input = scan.nextLine();
        }

        records.entrySet().stream()
                .sorted((a, b) -> {
                    int comp = b.getValue().get(0) - a.getValue().get(0);
                    if (comp == 0) {
                        comp = a.getKey().compareTo(b.getKey());
                    }
                    return comp;
                }).forEach((h) -> {
            System.out.println(h.getKey());
            System.out.println("  HP: " + h.getValue().get(0));
            System.out.println("  MP: "+ h.getValue().get(1));

        });

    }
}
