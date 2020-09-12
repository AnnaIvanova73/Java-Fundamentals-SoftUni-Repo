package Lab_4_Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scan.nextLine());

        List<Song> playList = new ArrayList<>();


        String input;
        for (int i = 0; i < numberOfSongs; i++) {
            String[] tokens = scan.nextLine().split("_+");
            String typeList = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song(typeList, name, time);

            playList.add(song);
        }

        input = scan.nextLine();

        if("all".equals(input)){
            for (Song song : playList) {
                System.out.println(song.getName());
            }
        }else{
            for (Song song : playList) {
                if(song.getTypeList().equals(input)){
                    System.out.println(song.getName());
                }
            }
        }

    }
}
