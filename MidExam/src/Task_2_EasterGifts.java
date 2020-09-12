import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_EasterGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> planGifts = readMyPlan(scan);


        String input = scan.nextLine();
        while(!"No Money".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String currentGift = tokens[1];

            switch (command){
                case"OutOfStock":
                    while(planGifts.contains(currentGift)){
                            int index = planGifts.indexOf(currentGift);
                            planGifts.set(index,"None");
                    }
                    break;
                case"Required":
                    int index=Integer.parseInt(tokens[2]);
                    if(index< 0 || index>=planGifts.size()){
                        break;
                    }
                    planGifts.set(index,currentGift);
                    break;
                case"JustInCase":
                    planGifts.set(planGifts.size()-1,currentGift);
                    break;
            }
            input=scan.nextLine();
        }

        for (String elements : planGifts) {
            String currentGift = elements;
            if(!currentGift.equals("None")){
                System.out.print(currentGift + " ");
            }
        }

    }

    private static List<String> readMyPlan(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");

        List<String> list = new ArrayList<>();

        for (String element : input) {
            list.add(element);
        }
        return list;
    }
}
