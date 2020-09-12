import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstDeck = getLineAsNumbers(scan);
        List<Integer> secondDeck = getLineAsNumbers(scan);


        int countTakes = 0;
        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
            int firstCard = firstDeck.get(countTakes);
            int secondCard = secondDeck.get(countTakes);

            if (firstCard > secondCard) {

                addCardsDeckOne(firstDeck, firstCard, secondCard, countTakes);
                secondDeck.remove(Integer.valueOf(secondCard));

            } else if (secondCard > firstCard) {

                addCardDeckTwo(secondDeck, firstCard, secondCard, countTakes);
                firstDeck.remove(Integer.valueOf(firstCard));

            } else  {

                firstDeck.remove(countTakes);
                secondDeck.remove(countTakes);

            }
        }
        int sum = 0;
       if (firstDeck.size() > secondDeck.size()){
          sum =  getSum(firstDeck,sum);
           System.out.printf("First player wins! Sum: %d",sum);
       } else {
           sum = getSum(secondDeck,sum);
           System.out.printf("Second player wins! Sum: %d",sum);
       }

    }

    private static int getSum (List<Integer> listOfCards, int sum) {

        for (Integer card : listOfCards) {
            sum+=card;
        }
        return sum;
    }

    private static void addCardDeckTwo(List<Integer> secondDeck, int firstCard, int secondCard, int countTakes) {
        secondDeck.add(secondCard);
        secondDeck.remove(Integer.valueOf(secondCard));
        secondDeck.add(firstCard);
    }

    private static void addCardsDeckOne(List<Integer> firstDeck, int bigNumber, int smallerNumber, int countTakes) {
        firstDeck.add(bigNumber);
        firstDeck.remove(countTakes);
        firstDeck.add(smallerNumber);

    }

    private static List<Integer> getLineAsNumbers(Scanner scan) {
        List<Integer> myNumbers = new ArrayList<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            int number = Integer.parseInt(input[i]);
            myNumbers.add(number);
        }
        return myNumbers;
    }
}
