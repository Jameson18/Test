package Lesson2;

import java.util.Scanner;
// Пользователь загадывает число от 1 до 100, а компьютер угадывает.

public class Binary {
    public static void main(String[] args) {
        int left = 1;
        int right = 100;
        int mid;
        Scanner num = new Scanner(System.in);

        mid = (left + right) / 2;
        System.out.println("Загадайте число от 1 до 100.");
        System.out.println("1 - ДА" + "\n" + "0 - НЕТ");
        System.out.println("Ваше число " + right + "?");
        int x = num.nextInt();
        if (x == 1) {
            System.out.println("Слишком просто");
        } else if (x == 0) {
            while (true) {
                System.out.println("Ваше число " + mid + "?");
                x = num.nextInt();
                if (x == 1) {
                    System.out.println("Ваше число " + mid + " разгадано!" + "\n" + "Game Over.");
                    break;
                } else System.out.println("Ваше число больше " + mid + "?");
                x = num.nextInt();
                if (x == 1) {
                    left = mid;
                    mid = (left + right) / 2;
                } else if (x == 0){
                    right = mid;
                    mid = (left + right) / 2;
                }


            }


        }




    }
}