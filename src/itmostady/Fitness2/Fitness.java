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
            if (zone.equals("pool")) {
                if (abonement instanceof InputPool){
                    if (abonement.inputPool()) {
                    addToPool(abonement);
                }
                } else System.out.println("По Вашему абонементу нет доступа. Проверьте время или зону");
            }
            if (zone.equals("gym")) {
                if (abonement instanceof InputGym){
                if (abonement.inputGym()) {
                    addToGym(abonement);
                }
                }else System.out.println("По Вашему абонементу нет доступа. Проверьте время или зону");
            }
            if (zone.equals("group")) {
                if (abonement instanceof InputGroup){
                if (abonement.inputGroup()) {
                    addToGroup(abonement);
                }
                }else System.out.println("По Вашему абонементу нет доступа. Проверьте время или зону");
            }
        }else System.out.println("Fitness Closed");
    }

    private void addToPool(Abonement abonement){
        if (access(abonement)){
            for (int i = 0; i < pool.length; i++) {
                if (pool[i] == null) {
                    pool[i] = abonement;
                    return;
                }
            }
        }else System.out.println("По одному абонементу только в одну зону");
    }

    private void addToGym(Abonement abonement) {
        if (access(abonement)){
            for (int i = 0; i < gym.length; i++) {
                if (gym[i] == null) {
                    gym[i] = abonement;
                    return;
                }
            }
        }else System.out.println("По одному абонементу только в одну зону");
    }

    private void addToGroup(Abonement abonement) {
        if (access(abonement)){
            for (int i = 0; i < group.length; i++) {
                if (group[i] == null) {
                    group[i] = abonement;
                    return;
                }
            }
        }else System.out.println("По одному абонементу только в одну зону");
    }
    public boolean access(Abonement abonement){
        boolean access = true;
         for (int i = 0; i < gym.length; i++) {
             if (gym[i] != null) {
                 if ((abonement.client).equals(gym[i].client)) {
                     access = false;
                 }
             }
         }for (int j = 0; j < pool.length; j++) {
            if (pool[j] != null) {
                if ((abonement.client).equals(pool[j].client)) {
                    access = false;
                }
            }
        }for (int k = 0; k < group.length; k++) {
            if (group[k] != null) {
                if ((abonement.client).equals(group[k].client)) {
                    access = false;
                }
            }
        }return access;
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
