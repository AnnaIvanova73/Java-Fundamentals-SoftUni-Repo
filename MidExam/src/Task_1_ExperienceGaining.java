import java.util.Scanner;

public class Task_1_ExperienceGaining {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double experienceGoal = Double.parseDouble(scan.nextLine());
        int battlesCount = Integer.parseInt(scan.nextLine());

        boolean hasExperience = false;

        double earnedExperience = 0;
        int countBattles = 0;

        while (countBattles < battlesCount){
            countBattles++;
            double experiencePerGame = Double.parseDouble(scan.nextLine());

            if(countBattles % 3 == 0){
                earnedExperience+=experiencePerGame * 1.15;
            }else if(countBattles % 5 == 0){
                earnedExperience+=experiencePerGame * 0.90;
            }else{
                earnedExperience+=experiencePerGame;
            }

            if(earnedExperience >= experienceGoal){
                hasExperience = true;
                break ;
            }


        }

        if(hasExperience){
            System.out.printf("Player successfully collected his needed experience for %d battles.",countBattles);
        }else {
            double experienceNeeded = experienceGoal - earnedExperience;
            System.out.printf("Player was not able to collect the needed experience, " +
                    "%.2f more needed.",experienceNeeded);
        }
    }
}
