package itmostady.Fitness2;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness extends AbonementFull implements InputGroup, InputGym, InputPool{
    LocalTime open = LocalTime.of(8, 0);
    LocalTime close = LocalTime.of(22, 0);
    LocalTime currentTime = LocalTime.now();
    LocalDate checkReg = LocalDate.now();


    public Fitness(String name, String surname, int year, LocalDate regTime, LocalDate endRegTime) {
        super(name, surname, year, regTime, endRegTime);
    }

    public boolean isOpen(){
        return  (currentTime.isAfter(open) || currentTime.isBefore(close));
    }

    Fitness[] fit = new Fitness[20];
    public void input(Fitness fitness){
        while (!isOpen()){
            for (int i = 0; i < fit.length; i++) {
                fit[i] = null;
            }
        }
        System.out.println("Closed");
        if (isOpen() || getEndRegTime().isAfter(checkReg)){
            System.out.println("Абонемент просрочен");
        }else if (isOpen() || getEndRegTime().isBefore(checkReg) && getEndRegTime().isEqual(checkReg)){
            for (int i = 0; i < fit.length; i++) {
                if (fit[i] == null)
                    fit[i] = fitness;
            }
        }
    }
    public void getFitnessInfo(String info){
        System.out.println(Arrays.toString(fit));
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "fit=" + Arrays.toString(fit) +
                "} " + super.toString();
    }
}
