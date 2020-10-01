package Lesson2;

import java.util.Scanner;

public class Lesson2 {
    public static class IfElseSwitch{

        public static void main(String[] args) {
            int state = 0;
            if (state == 0) {
                System.out.println("Закрытие приложения");
            } else if (state == 1) {
                System.out.println("Запуск приложения");
            } else System.out.println("Ошибка статуса");
            /* логические операторы:
            && и
            || или
            ! не
            ^ исключающее или
             */
            //boolean isClosed = false;
            //!isClosed = true;
            int count = 11;
            if (count < 0 || count > 100) {
                System.out.println("Ошибка ввода");
            } else if (count >= 90 && count <= 100) {
                System.out.println("Оценка 5");
            } else if (count >= 60 && count <= 89) {
                System.out.println("Оценка 4");
            } else if (count >= 40 && count <= 59) {
                System.out.println("Оценка 3");
            } else {
                System.out.println("Оценка 2");

            }
            /*
        switch (переменная/выражение) {
        case значение1/выражение1:
        инструкции;
        break;
        case значение2/выражение2:
        case значение3/выражение3:
        инструкции;
        break;
        case значение4/выражение4:
        инструкции;
        break;
        default:
        инструкции;
        break;
                   как найдет совпадение в одрном из кейсов, будет выполнять инструкции до break!!!!!!
        }
        выражение/переменная могут быть: byte, short, char, int, String enum(перечисления)
         */
            int some = 10000;
            int code = 5698;
            //4653 скидка 30%
            //5698, 5111 скидка 20%
            //6922, 6113, 6099 скидка 10%
            //в остальных случаях скидки нету

            switch (code){
                case 4653:
                    System.out.println(some- some * 0.3);
                    break;
                case 5698:
                case 5111:
                    System.out.println(some-some * 0.2);
                    break;
                case 6922:
                case 6113:
                case 6099:
                    System.out.println(some-some * 0.1);
                    break;
                default:
                        System.out.println("скидки нету");
            }

            int a = 2;
            int res = a++ - ++a + a++ + a++ + a;
            System.out.println(res);

            int i = 55;
            while (i < 79) {
                System.out.println(i);
                i++;
            }

            Scanner s = new Scanner(System.in);
             int sum;







            

            do {
                System.out.println("Введите число. 0 для завершения");
                sum = s.nextInt();
                if (sum != 0)System.out.println(sum+2);
            } while (sum!=0);

            for (int j = 0; j < 9; j++) {
                if (j % 2 == 0) System.out.println(j);

            }
            //двоичный поиск разобрать



        }
    }
}
