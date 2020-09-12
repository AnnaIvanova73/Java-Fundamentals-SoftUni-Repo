import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Important_1_Code_ArcheryTournament {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> list = Arrays.stream(console.nextLine().split("\\|+"))
                //четем реда от конзолата,сплитнат по една или повече прави черти
                .map(Integer::parseInt)
                //четем го като стрингове,затова го парства до int
                .collect(Collectors.toList());
        //слагаме го в списък

        int sum = 0;
        // тук ще събираме точките
        String command = console.nextLine();
        //четем командата
        while (!command.equals("Game over")){
            //проверияме дали е различна от Game over
            String[] tokens = command.split("@");
            // сплитваме командата
            switch (tokens[0]){
                case "Shoot Left": {
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    // парсваме старт индекс и дължината
                    if (getCheckStartIndexIsValid(list, index)) {
                        // правим метод защото и при shoot left ще проверяме също старт индекс,ако не е валиден пропускаме командата
                        while (length > 0) {
                            index--;
                            // почваме да намаляваме индекса
                            length--;
                            // с length броим колко пъти
                            if (index == -1) {
                                index = list.size() - 1;
                                // ако стане -1 го връщаме от дугия край на последния индекс
                            }
                        }
                        // вече имаме желания индекс и всички валидации
                        sum += getShoot(list, index);

                    }
                    break;
                    // много важно да не пропускаш break след всеки кейс, че всичко отива на кино
                }
                case "Shoot Right":{
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    // парсваме старт индекс и дължината
                    if (getCheckStartIndexIsValid(list, index)) {
                        // вече го имаме готов
                        while (length > 0) {

                            index++;
                            // почваме да увеличаваме индекса
                            length--;
                            // с length броим колко пъти
                            if (index == list.size()) {
                                index = 0;
                                // ако премине крайната граница,го връщаме на 0
                            }
                        }
                        // вече имаме желания индекс и всички валидации
                        sum += getShoot(list, index);

                    }
                    break;
                    // много важно да не пропускаш break след всеки кейс, че всичко отива на кино
                }
                case "Reverse":
                    Collections.reverse(list);
                    break;
                // пак не забравяме break
            }
            command = console.nextLine();
            // четем отново команда
        }


        for (int i = 0; i < list.size() - 1 ; i++) {
            System.out.print(list.get(i) + " - ");
            // принтираме до предпоследния елемет са да може да слегаме тиретета,ако списъка е празен няма да тръгне въобще фора
        }
        if (list.size() > 0){
            // провереваме дали е празен,да не гръмне, и принтираме последния елемент
            System.out.printf("%d\n",list.get(list.size() - 1));
            //принтираме последния и минаваме на нов ред
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
            // ако стойноста е под 5, просто взимаме всичко и сетваме нула
        }
        return value;
        // връщаме колко точки е взел
    }

    private static boolean getCheckStartIndexIsValid(List<Integer> list, int index) {
        if (index >= 0 && index < list.size()){
            return true;
        }
        return false;
    }
}