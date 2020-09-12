import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Important_WithForLoop_ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> field = getTargets(scan);

        int iskrenPoints = 0;
        String cmdArg = scan.nextLine();
        while (!"Game over".equals(cmdArg)) {
            String[] tokens = cmdArg.split("@+");
            String command = tokens[0];

            int index;
            int length;
            switch (command) {
                case "Shoot Left":
                    index = Integer.parseInt(tokens[1]);
                    length = Integer.parseInt(tokens[2]);
                    if(index < 0 || index >= field.size()){
                        break;
                    }
                    int num = 0;
                    for (int i = 0; i < length; i++) {
                        num = index % field.size();
                        if (num == 0) {
                            index = field.size();
                        }
                        index--;
                    }
                    iskrenPoints+= getPoints(field,index);
                    break;
                case "Shoot Right":
                    index = Integer.parseInt(tokens[1]);
                    length = Integer.parseInt(tokens[2]);
                    if(index < 0 || index >= field.size()){
                        break;
                    }
                    for (int i = 0 ; i < length; i++) {

                        if (index == field.size()) {
                            index = 0;
                        }
                        index++;
                    }

                    iskrenPoints+=getPoints(field,index);
                    break;
                case"Reverse":
                    Collections.reverse(field);
                    break;
            }

            cmdArg = scan.nextLine();
        }
        for (int i = 0; i < field.size()-1 ; i++) {
            int element = field.get(i);
            System.out.print(element + " - ");
        }
        if(field.size() > 0){
            System.out.println(field.get(field.size()-1));
        }
        System.out.printf("Iskren finished the archery tournament with %d points!",iskrenPoints);
    }

    private static int getPoints(List<Integer> list, int index) {
        int value  = list.get(index);
        if (value >= 5){
            list.set(index,value - 5);
            return 5;
        }else{
            list.set(index,0);
        }
        return value;
    }
    private static List<Integer> getTargets(Scanner scan) {
        String[] input = scan.nextLine().split("\\|+");
        List<Integer> list = new ArrayList<>();
        for (String elements : input) {
            int currentElement = Integer.parseInt(elements);
            list.add(currentElement);
        }
        return list;
    }
}

