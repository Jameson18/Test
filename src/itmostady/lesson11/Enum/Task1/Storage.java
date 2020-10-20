package itmostady.lesson11.Enum.Task1;

import itmostady.lesson6alp.Alpinist;

import java.util.Arrays;

public class Storage {
    User[] stuff;


    public Storage() {
        stuff = new User[10];

    }

    public void addDirector(User dir) {
        if (dir.position.equals(Position.ДИРЕКТОР)) {
            for (int i = 0; i < stuff.length; i++) {
                if (stuff[i] == null)
                    stuff[i] = dir;
                return;
            }
        }
    }

    public void addCleaner(User clean) {
        if (clean.position.equals(Position.УБОРЩИК)) {
            for (int i = 0; i < stuff.length; i++) {
                if (stuff[i] == null)
                    stuff[i] = clean;
                return;
            }
        }
    }

    public void addAccountant(User acc) {
        if (acc.position.equals(Position.БУХГАЛТЕР)) {
            for (int i = 0; i < stuff.length; i++) {
                if (stuff[i] == null)
                    stuff[i] = acc;
                return;
            }
        }
    }

    public String getInform() {
        StringBuilder sb = new StringBuilder();
        for (User dir : stuff) {
            if (dir != null)
                sb.append(dir.getName())
                        .append(" ")
                        .append(dir.getSalary())
                        .append(" ")
                        .append(dir.getPosition())
                        .append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Storage{" +
                "stuff=" + Arrays.toString(stuff) +
                '}';
    }

}





