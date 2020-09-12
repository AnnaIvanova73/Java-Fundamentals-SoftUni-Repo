import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_3_WizardPoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> wizardCards = getCards(scan);
        List<String> changedDeck = new ArrayList<>();

        String deckInChanging = scan.nextLine();
        while (!"Ready".equals(deckInChanging)){
            String[] tokens = deckInChanging.split("\\s+");
            String command = tokens[0];
            String cardName = tokens[1];
            switch (command){
                case"Add":
                    if(wizardCards.contains(cardName)){
                        changedDeck.add(cardName);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case"Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if ((index >= 0 && index < changedDeck.size()) && wizardCards.contains(cardName)){
                            changedDeck.add(index,cardName);
                    }else{
                        System.out.println("Error!");
                    }
                    break;
                case"Remove":
                    if (changedDeck.contains(cardName)){
                        changedDeck.remove(cardName);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case"Swap":
                    String secondCard = tokens[2];
                    String temp = cardName;
                    int indexOfFirstCard = changedDeck.indexOf(cardName);
                    int indexSecond = changedDeck.indexOf(secondCard);
                    changedDeck.set(indexOfFirstCard,secondCard);
                    changedDeck.set(indexSecond,temp);
                    break;
                case "Shuffle":
                    Collections.reverse(changedDeck);
                    break;

            }
            deckInChanging=scan.nextLine();
        }

        for (String currElement : changedDeck) {
            System.out.print(currElement + " ");
        }
    }

    private static List<String> getCards(Scanner scan) {
        String[] input = scan.nextLine().split(":+");
        List<String> arrayList = new ArrayList<>();
        for (String currElement : input) {
            arrayList.add(currElement);
        }
        return arrayList;
    }
}
