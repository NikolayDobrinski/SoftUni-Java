package softuni.fundamentals.objectsandclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        String typeList;
        String name;
        String time;

        Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Song> allSongs = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] currentSong = scan.nextLine().split("_");
            Song song = new Song(currentSong[0], currentSong[1], currentSong[2]);

            allSongs.add(song);

        }

        String type = scan.nextLine();

        if (type.equals("all")) {
            for (Song song : allSongs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : allSongs) {
                if (song.getTypeList().equals(type)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
