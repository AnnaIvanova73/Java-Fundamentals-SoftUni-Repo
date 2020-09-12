import java.util.*;
import java.util.stream.Collectors;

public class abc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teamsNum = Integer.parseInt(sc.nextLine());
        List<Team> teamList = new ArrayList<>();

        for (int i = 0; i < teamsNum; i++) {

            String[] teamInfo = sc.nextLine().split("-");
            boolean newTeam = true;

            for (Team team : teamList) {

                if (team.name.equals(teamInfo[1])) {

                    newTeam = false;
                    System.out.println(String.format("Team %s was already created!", teamInfo[1]));
                    break;
                }
            }

            for (Team team : teamList) {

                if (team.members.get(0).equals(teamInfo[0])) {

                    newTeam = false;
                    System.out.println(String.format("%s cannot create another team!", teamInfo[0]));
                    break;
                }
            }


            if (newTeam) {
                List<String> members = new ArrayList<>();
                members.add(teamInfo[0]);

                Team team = new Team(teamInfo[1], members);

                System.out.println(String.format("Team %s has been created by %s!", teamInfo[1], teamInfo[0]));

                teamList.add(team);
            }
        }

        String[] assignment = sc.nextLine().split("->");
        while (!assignment[0].equals("end of assignment")) {

            boolean existingTeam = false;
            boolean canJoin = true;
            int teamIndex = 0;

            for (int i = 0; i < teamList.size(); i++) {

                if (assignment[1].equals(teamList.get(i).name)) {

                    existingTeam = true;
                    teamIndex = i;
                }
            }

            if (!existingTeam) {

                System.out.println(String.format("Team %s does not exist!", assignment[1]));

            } else {

                for (Team team : teamList) {

                    if (!canJoin) {
                        break;
                    }

                    for (String member : team.members) {

                        if (assignment[0].equals(member)) {

                            System.out.println(String.format("Member %s cannot join team %s!", assignment[0], assignment[1]));
                            canJoin = false;
                            break;
                        }
                    }
                }

                if (canJoin) {

                    teamList.get(teamIndex).members.add(assignment[0]);
                }
            }

            assignment = sc.nextLine().split("->");
        }

        List<String> teamsToDisband = new ArrayList<>();

        teamList = teamList
                .stream()
                .sorted(Comparator.comparingInt(Team::membersCount).reversed())
                .collect(Collectors.toList());

        for (Team team : teamList) {

            if (team.members.size() > 1) {

                System.out.println(team.name);
                System.out.println("- " + team.members.get(0));
                team.members.remove(0);

                team.members = team.members
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());

                for (int i = 0; i < team.members.size(); i++) {

                    System.out.println("-- " + team.getMember(i));
                }
            } else {

                teamsToDisband.add(team.name);
            }
        }

        System.out.println("Teams to disband:");

        if (teamsToDisband.size() > 0) {

            teamsToDisband
                    .stream()
                    .sorted()
                    .forEach(System.out::println);
        }
    }
}


class Team {

    String name;
    List<String> members;

    int membersCount() {
        return members.size();
    }

    Team(String name, List<String> members) {
        this.name = name;
        this.members = members;
    }

    String getMember(int i) {
        return members.get(i);
    }
}