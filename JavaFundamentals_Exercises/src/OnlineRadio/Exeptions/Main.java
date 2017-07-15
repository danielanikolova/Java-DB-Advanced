package OnlineRadio.Exeptions;

import OnlineRadio.Playlist;
import OnlineRadio.Song;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Playlist playlist = new Playlist();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <count ; i++) {
            String [] info = scanner.nextLine().split(";");
            String artist = info[0];
            String songName = info[1];
            String[] time = info[2].split(":");
            String minutes = time[0];
            String seconds = time[1];

            try {
                Song song = new Song(artist, songName, minutes, seconds);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("Songs added: %d\n", playlist.getSongsCount());
        System.out.println(playlist.getTotalPlaylistLength());

    }
}
