package MoreExercise_4_TeamworkProjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfTeams = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> teams = new TreeMap<>();
        List<String> members = new ArrayList<>();
        boolean hasCreator = false;
        for (int i = 0; i < numberOfTeams; i++) {

            String[] tokens = scan.nextLine().split("-");
            String creator = tokens[0];
            String team = tokens[1];

            if (teams.containsKey(team)) {
                System.out.println(String.format("Team %s was already created!", team));
                continue;
            }

            for (List<String> value : teams.values()) {
                String currValue = value.get(0);
                if (currValue.equals(creator)) {
                    System.out.println(String.format("%s cannot create another team!", creator));
                    hasCreator = true;
                }
            }
            if (!hasCreator) {
                teams.putIfAbsent(team, new ArrayList<>());
                teams.get(team).add(creator);
                members.add(creator);
                System.out.println(String.format("Team %s has been created by %s!", team, creator));
            }
        }

        boolean hasMember = false;
        String input = scan.nextLine();
        while (!"end of assignment".equals(input)) {
            String[] tokens = input.split("->");
            String userPerJoin = tokens[0];
            String teamPerJoin = tokens[1];

            if (!teams.containsKey(teamPerJoin)) {
                System.out.printf("Team %s does not exist!%n", teamPerJoin);
                input = scan.nextLine();
                continue;
            }


            for (String member : members) {
                if (member.equals(userPerJoin)) {
                    hasMember = true;
                    System.out.printf("Member %s cannot join team %s!%n", userPerJoin, teamPerJoin);
                    break;
                }
            }

            if (!hasMember) {
                teams.get(teamPerJoin).add(userPerJoin);
                members.add(userPerJoin);
            }
            input = scan.nextLine();
        }
        teams.
                entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .sorted((a, b) -> {

                    int first = a.getValue().size();
                    int second = b.getValue().size();
                    return second - first;

                })
                .forEach(a -> {
                    System.out.println(a.getKey());
                    System.out.println("- " + a.getValue().get(0));
                    String name = a.getValue().get(0);
                    a.getValue().remove(name);
                    a.getValue().sort(Comparator.naturalOrder());
                    for (String s : a.getValue()) {
                        System.out.printf("-- %s%n", s);
                    }
                    a.getValue().add(0, name);
                });

        System.out.println("Teams to disband:");
        System.out.println();

        for (Map.Entry<String, List<String>> stringListEntry : teams.entrySet()) {
            String key = stringListEntry.getKey();
            int size = stringListEntry.getValue().size();
            if (size == 1) {
                System.out.println(key);
                break;
            }
        }
    }
}
