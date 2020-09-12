import java.util.*;

public class MoreExercise_3_MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersAndPositions = new TreeMap<>();

        String input;
        while (!"Season end".equals(input = scan.nextLine())) {
            String[] tokens;
            if (input.contains("->")) {
                tokens = input.split(" -> ");
                String namePlayer = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                if (!playersAndPositions.containsKey(namePlayer)) {
                    playersAndPositions.put(namePlayer, new HashMap<>());
                    playersAndPositions.get(namePlayer).put(position, skill);
                    continue;
                }

                if (!playersAndPositions.get(namePlayer).containsKey(position)) {
                    playersAndPositions.get(namePlayer).put(position, skill);
                    continue;
                }

                int previousSkill = playersAndPositions.get(namePlayer).get(position);
                if (skill > previousSkill) {
                    playersAndPositions.get(namePlayer).put(position, skill);
                }

            } else {
                tokens = input.split("vs");
                String playerOne = tokens[0].trim();
                String playerTwo = tokens[1].trim();
                if (playersAndPositions.containsKey(playerOne) && playersAndPositions.containsKey(playerTwo)) {
                    battle(playerOne, playerTwo, playersAndPositions);
                }
            }
        }

        System.out.println();
        playersAndPositions.entrySet().stream().sorted((a, b) -> {
            int sum1 = sum(a.getValue());
            int sum2 = sum(b.getValue());
            return sum2 - sum1;
        }).forEach(a -> {
            System.out.println(a.getKey() + ": " + sum(a.getValue()) + " skill");
            a.getValue().entrySet().stream().sorted((k, v) -> {
                int comp = v.getValue() - k.getValue();
                if (comp == 0) {
                    comp = k.getKey().compareTo(v.getKey());
                }
                return comp;
            }).forEach(current -> System.out.println("- " + current.getKey() + " <::> " + current.getValue()));

        });


    }

    private static int sum(Map<String, Integer> value) {
        int sum = 0;
        for (Integer integer : value.values()) {
            int currentValue = integer;
            sum += currentValue;
        }
        return sum;
    }

    private static void battle(String playerOne, String playerTwo, Map<String, Map<String, Integer>> playersAndPositions) {
        Map<String, Integer> firstPlayer = playersAndPositions.get(playerOne);
        Map<String, Integer> secondPlayer = playersAndPositions.get(playerTwo);

        for (Map.Entry<String, Integer> entryOne : firstPlayer.entrySet()) {
            String positionFirst = entryOne.getKey();
            for (Map.Entry<String, Integer> entryTwo : secondPlayer.entrySet()) {
                String positionSecond = entryTwo.getKey();
                if (positionFirst.equals(positionSecond)) {
                    int skillFirst = entryOne.getValue();
                    int skillSecond = entryTwo.getValue();
                    if (skillFirst > skillSecond) {
                        playersAndPositions.remove(playerTwo);
                        return;
                    }
                    if (skillSecond > skillFirst) {
                        playersAndPositions.remove(playerOne);
                        return;
                    }
                }
            }
        }
    }
}


