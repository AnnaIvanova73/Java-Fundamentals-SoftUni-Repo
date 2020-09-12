import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2_ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list =
                Arrays.stream(scan.nextLine().
                        split("\\|+")).map(Integer::parseInt).
                        collect(Collectors.toList());

        int sum = 0 ;

        String input = scan.nextLine();
        while(!"Game over".equals(input)){
            String[] tokens = input.split("@+");
            String cmdArgs = tokens[0];
            switch (cmdArgs){

                case"Shoot Left": {
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    boolean isValid = checkExistenceOfIndex(index, list);
                    if (isValid) {
                        while (length > 0) {
                            index--;
                            length--;
                            if (index == -1) {
                                index = list.size() - 1;
                            }
                        }
                        sum += getShoot(list, index);
                    }
                    break;
                }

                case"Shoot Right": {
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    boolean isValid = checkExistenceOfIndex(index, list);
                    if (isValid) {
                        while (length > 0){
                            index ++;
                            length--;
                            if (index == list.size()) {
                                index = 0;
                            }
                        }
                        sum += getShoot(list, index);
                    }
                    break;
                }
                case"Reverse":
                    Collections.reverse(list);
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < list.size() - 1 ; i++) {
            System.out.print(list.get(i) + " - ");
        }
        if (list.size() > 0){
            System.out.printf("%d\n",list.get(list.size() - 1));
        }
        System.out.println(String.format("Iskren finished the archery tournament with %d points!", sum));
    }

    private static int getShoot(List<Integer> list, int index) {
        int value  = list.get(index);
        int points = 0;
        // взимаме стойноста на този индекс
        if (value >= 5){
            list.set(index,value - 5);
            return 5;
            // ако стойноста е по-голяма от 5 вадим 5 и излизаме от метода и връщаме взетите точки
        }else if (value < 5){
            list.set(index,0);
        }
        return value;

    }

    private static boolean checkExistenceOfIndex(int index, List<Integer> list) {
        if(index >=0 && index <list.size()){
            return true;
        }
        return false;
    }
}
