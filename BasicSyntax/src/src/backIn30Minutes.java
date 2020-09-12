import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class backIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours =Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int timeInMinutes = minutes + (hours * 60);

        int timeAfter = timeInMinutes + 30;

        hours = timeAfter/60;
        minutes=timeAfter%60;

        if (hours > 23){
            hours-=24;
        }

        String output = String.format("%d:%02d",hours,minutes);
        System.out.println(output);
    }
}
