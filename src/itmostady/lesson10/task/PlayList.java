package itmostady.lesson10.task;

import java.util.Arrays;

public class PlayList {
    private Song song[] = new Song[10];


    public void addSong(Song son){
        for (int i = 0; i < song.length; i++) {
            if (song[i] == null){
                song[i] = son;
            }
        }
    }

    public int getFullLength(int sum){
        for (int i = 0; i < song.length; i++) {
            if (song[i] != null){
                sum += song[i].getLength();
            }
        }return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return Arrays.equals(song, playList.song);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(song);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
