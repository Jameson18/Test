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

                if (abonement.inputPool()) {
                    addToPool(abonement);
                }else System.out.println("По Вашему абонементу нет доступа. Проверьте время или зону");
            }
            if (zone.equals("gym") && abonement instanceof InputGym) {
                if (abonement.inputGym()) {
                    addToGym(abonement);
                }else System.out.println("По Вашему абонементу нет доступа. Проверьте время или зону");
            }
            if (zone.equals("group") && abonement instanceof InputGroup) {
                if (abonement.inputGroup()){
                    addToGroup(abonement);
                }else System.out.println("По Вашему абонементу нет доступа. Проверьте время или зону");
            }
        }else System.out.println("Fitness Closed");
    }

    private void addToPool(Abonement abonement){
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] != null) {
                if ((abonement.client).equals(gym[i].client)) {
                    System.out.println("По одному абонементу только в одну зону");
                    return;
                }
            } else for (int j = 0; j < group.length; j++) {
                if (group[j] != null) {
                    if ((abonement.client).equals(group[j].client)) {
                        System.out.println("По одному абонементу только в одну зону");
                        return;
                    }
                } else for (int k = 0; k < group.length; k++) {
                    if (pool[i] != null && (abonement.client).equals(pool[i].client)){
                        System.out.println("Вы уже вошли");
                        return;
                    }else if (pool[i] == null){
                        pool[i] = abonement;
                        return;
                    }
                }
            }
        }
    }

    private void addToGym(Abonement abonement) {
        for (int i = 0; i < group.length; i++) {
        if (group[i] != null) {
            if ((abonement.client).equals(group[i].client)) {
                System.out.println("По одному абонементу только в одну зону");
                return;
            }
            } else for (int j = 0; j < pool.length; j++) {
                if (pool[j] != null) {
                    if ((abonement.client).equals(pool[j].client)) {
                        System.out.println("По одному абонементу только в одну зону");
                        return;
                    }
                } else for (int k = 0; k < gym.length; k++) {
                    if (gym[k] != null && (abonement.client).equals(gym[k].client)){
                        System.out.println("Вы уже вошли");
                        return;
                    }else if (gym[k] == null){
                        gym[k] = abonement;
                        return;
                    }
                }
            }
        }
    }

    private void addToGroup(Abonement abonement) {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] != null) {
                if ((abonement.client).equals(gym[i].client)) {
                    System.out.println("По одному абонементу только в одну зону");
                    return;
                }
            } else for (int j = 0; j < pool.length; j++) {
                if (pool[j] != null) {
                    if ((abonement.client).equals(pool[j].client)) {
                        System.out.println("По одному абонементу только в одну зону");
                        return;
                    }
                } else for (int k = 0; k < group.length; k++) {
                    if (group[i] != null && (abonement.client).equals(group[i].client)){
                        System.out.println("Вы уже вошли");
                        return;
                    }else if (group[i] == null){
                        group[i] = abonement;
                        return;
                    }
                }
            }
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
