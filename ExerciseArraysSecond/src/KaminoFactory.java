import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int lengthDna = Integer.parseInt(scan.nextLine());
        int[] searchSequence = new int[lengthDna];

        int currentSampleDNA = 0;
        int maxSum = 0;
        int bestSample = 0;
        int maxSubsequence = 0;

        int minIndex = Integer.MAX_VALUE;

        String input = scan.nextLine();
        while (!"Clone them!".equals(input)) {

            String[] splitInput = input.split("\\D");
            int[] receivedDna = new int[splitInput.length];

            int currentSum = 0;
                currentSampleDNA++;

            for (int i = 0; i < receivedDna.length; i++) {
                receivedDna[i] = Integer.parseInt(splitInput[i]);
                currentSum += receivedDna[i];
            }


            int subsequenceCurrent = 1;
            boolean hasValidDNA = false;
            int currentIndex=0;

            for (int i = 0; i < receivedDna.length ;i++) {
                int firstBadge = receivedDna[i];
                int secondBadge = receivedDna[i + 1];

                if (secondBadge == firstBadge && firstBadge == 1) {
                    subsequenceCurrent++;
                    hasValidDNA = true;
                    currentIndex = i;
                }

            }

            if (maxSubsequence < subsequenceCurrent && hasValidDNA) {
                maxSubsequence = subsequenceCurrent;
                bestSample = currentSampleDNA;
                maxSum = currentSum;
                minIndex = currentIndex;
                searchSequence = receivedDna;
            } else if (maxSubsequence == subsequenceCurrent && (minIndex < currentIndex || currentSum > maxSum)) {
                bestSample = currentSampleDNA;
                maxSum = currentSum;
                minIndex = currentIndex;
                searchSequence = receivedDna;
            }

            input = scan.nextLine();
        }
        int sum = 0;
        for (int item : searchSequence) {
            sum += item;
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSample, sum);
        for (int value : searchSequence) {
            System.out.print(value + " ");
        }

    }
}

