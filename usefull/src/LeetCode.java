import java.util.Scanner;

public class LeetCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stonesGiven = Integer.parseInt(scan.nextLine());

        boolean findTheWinner = true;
        int stoneRemoved = 1;

        while (stonesGiven != 0) {

            int removeStone = Integer.parseInt(scan.nextLine());



            if (stoneRemoved % 2 != 0) {
                stonesGiven -= removeStone;
                findTheWinner = true;
            } else {
                stonesGiven -= removeStone;
                findTheWinner = false;
            }

            stoneRemoved++;
        }
        if (!findTheWinner) {
            System.out.println(findTheWinner);
        } else {
            System.out.println(findTheWinner);
        }
    }
}