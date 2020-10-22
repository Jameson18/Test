package itmostady.lesson11.Enum.Task1;

import java.util.Arrays;

public class Storage {
    User[] stuff;


    public Storage() {
        stuff = new User[10];

    }

    public void addDirector(User dir) {
        if (dir.position.equals(Position.DIRECTOR)) {
            for (int i = 0; i < stuff.length; i++) {
                if (stuff[i] == null)
                    stuff[i] = dir;
                return;
            }
        }
    }

    public void addCleaner(User clean) {
        if (clean.position.equals(Position.CLEANER)) {
            for (int i = 0; i < stuff.length; i++) {
                if (stuff[i] == null)
                    stuff[i] = clean;
                return;
            }
        }
    }

    public void addAccountant(User acc) {
        if (acc.position.equals(Position.ACCOUNTANT)) {
            for (int i = 0; i < stuff.length; i++) {
                if (stuff[i] == null)
                    stuff[i] = acc;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Storage{" +
                "stuff=" + Arrays.toString(stuff) +
                '}';
    }

}





