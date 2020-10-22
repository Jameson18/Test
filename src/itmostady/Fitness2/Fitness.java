package itmostady.Fitness2;

import java.time.LocalTime;
import java.util.Arrays;

public class Fitness{
    private final LocalTime open = LocalTime.of(8, 0);
    private final LocalTime close = LocalTime.of(22, 0);
    LocalTime currentTime = LocalTime.now();
    Abonement[] pool = new Abonement[20];
    Abonement[] gym = new Abonement[20];
    Abonement[] group = new Abonement[20];


    public boolean isOpen(){
        return  (currentTime.isAfter(open) && currentTime.isBefore(close));
    }

    

    public void addAbonement(String zone, Abonement abonement){
        if (isOpen()){
            if (zone.equals("pool") && abonement instanceof InputPool) {
                addToPool(abonement);
            }
            if (zone.equals("gym") && abonement instanceof InputGym) {
                addToGym(abonement);
            }
            if (zone.equals("group") && abonement instanceof InputGroup) {
                addToGroup(abonement);
            }
        }else System.out.println("Fitness Closed");
    }

    private void addToPool(Abonement abonement){
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] == null) {
                pool[i] = abonement;
                return;
            }


        }
    }

    private void addToGym(Abonement abonement){
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] == null)
                gym[i] = abonement;
            return;
        }
    }

    private void addToGroup(Abonement abonement){
        for (int i = 0; i < group.length; i++) {
            if (group[i] == null)
                group[i] = abonement;
            return;
        }
    }


    @Override
    public String toString() {
        return "Fitness{" +
                "gym=" + Arrays.toString(gym) + "\n" +
                "pool=" + Arrays.toString(pool) + "\n" +
                "group=" + Arrays.toString(group) + "\n" +
                '}';
    }
}
