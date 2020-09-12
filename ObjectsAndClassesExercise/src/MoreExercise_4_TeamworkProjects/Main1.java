package MoreExercise_4_TeamworkProjects;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Team>> members = new LinkedHashMap<>();



        Map<String,List<String>> teams = new LinkedHashMap<>();

        int countIfTeams = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countIfTeams; i++) {
            String[] input = scan.nextLine().split("-");
            String leader = input[0].trim();
            String team = input[1].trim();



            String current = teams.get(team).get(0);
            if(current.equals(leader) && teams != null){
                System.out.printf("%s cannot create another team!",leader);
            }
            if(teams.containsKey(team)){
                System.out.printf("Team %s was already created!",team);
            }
            teams.putIfAbsent(team,new ArrayList<>());
            teams.get(team).add(leader);

        }
    }
}
