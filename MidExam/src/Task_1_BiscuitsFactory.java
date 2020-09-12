import java.sql.SQLOutput;
import java.util.Scanner;

public class Task_1_BiscuitsFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int productionPersonDaily = Integer.parseInt(scan.nextLine());
        int workersCount = Integer.parseInt(scan.nextLine());
        int monthlyProductionCompetitors = Integer.parseInt(scan.nextLine());
        int workingMonth = 30;

        double usualProductionPerDay =Math.floor(workersCount * 1.0 * productionPersonDaily) ;
        double lessProductionAmount =Math.floor(usualProductionPerDay * 0.75) ;

        int everyThirdDay = workingMonth / 3;
        double productionInEveryThirdDay = lessProductionAmount * everyThirdDay;

        double standardDays = workingMonth - everyThirdDay;
        double productionStandard = standardDays * usualProductionPerDay;

        double totalBiscuits = Math.ceil(productionInEveryThirdDay + productionStandard);
        System.out.println(String.format("You have produced %.0f biscuits for the past month.",totalBiscuits));

        double compareTwoFactory =  totalBiscuits - monthlyProductionCompetitors;
        boolean isItMore = false;
        if (compareTwoFactory >=0){
            isItMore=true;
        }
        double helper = Math.abs(compareTwoFactory);
        double percent = helper * 1.0 /monthlyProductionCompetitors * 100;


        if(isItMore){
            System.out.println(String.format("You produce %.2f percent more biscuits.",percent));
        }else{
            System.out.println(String.format("You produce %.2f percent less biscuits.",percent));
        }

        //-78 biscuits a day
        //-8 employees
        //-17160 biscuit production your factory (keep in mind every third day the workers produce only 75% of the usual production)
        //-17160 – 16000 = 1160 - compareTwoFactory between your and the other factory production
        //-1160/16000 * 100 = 7.25% more biscuits.
    }
}
