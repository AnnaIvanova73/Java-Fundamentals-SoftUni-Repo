package MoreExercise_4_TeamworkProjects;

import java.util.ArrayList;
import java.util.List;

public class Team {


    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public Team(String leader, String team) {
        this.leader = leader;
        this.team = team;

    }

    private String leader;
    private String team ;

}
