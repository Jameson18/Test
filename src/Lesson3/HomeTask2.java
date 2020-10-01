package Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeTask2 {
    public static void main(String[] args) {
        //Задача 1. (максимальное, минимальное и среднее значения массива)
        int[] mass ={6, -89, 2, 167, 44};
        Arrays.sort(mass);
        System.out.println(Arrays.toString(mass));
        int max = mass[0];
        int min = mass[0];
        int mid = 0;
        for (int i = 0;i < mass.length; i++) {
            max = Math.max(max, mass[i]);
            min = Math.min(min, mass[i]);
            mid += mass[i];
            mid /= mass.length;
            }System.out.println(max + " " + mid + " " + min);

        //Задача 2. (Создать массив из четных чисел и вывести в консоль в обратном порядке)
        int[] mass2 = new int[10];
        for (int i = 0, j = 2; i < 10; i++, j += 2) {
            mass2[i] = j;
        }
        for (int i = 9; i > -1; i--) {
            System.out.println(mass2[i]);
        }

        //Задача 3. (Создать массив из 11 чисел отрезка [-1;1]).
        int[] mass3 = new int[11];
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < mass3.length; i++) {
            mass3[i] = (int)(Math.random() * 3) - 1;
            System.out.println("mass3[" + i + "] = " + mass3[i]);
            if (mass3[i] == -1) a++;
            if (mass3[i] == 0) b++;
            if (mass3[i] == 1) c++;
        }if (a > b && a > c){
            System.out.println("Элемент -1 встречается чаще всего");
        }else if (b > a && b > c){
            System.out.println("Элемент 0 встречается чаще всего");
        }else if (c > a && c > b){
            System.out.println("Элемент 1 встречается чаще всего");
        }

    }

    public static class HomeTask1 {
        public static void main(String[] args) {
            System.out.println("Задание 1");
            //Вывести на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
            int a = 2;
            int count = 0;
            while (count < 20){
                System.out.println(a);
                count++;
                a = a * 2;
            }
            System.out.println(" ");
            System.out.println("Задание 2");
            //Вывести на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….

            int b = 90;
            while (b >= 0){
                System.out.println(b);
                b = b - 5;
            }
            System.out.println(" ");
            System.out.println("Задание 3");
            //Веди номер билета и получи приз

            Scanner s = new Scanner(System.in);
            System.out.println("Введите номер билета");
            int num = s.nextInt();
            switch (num) {
                case 111, 222, 333 -> System.out.println("Вы получите книгу!");
                case 444, 555 -> System.out.println("Вы получите телефон!");
                case 777 -> System.out.println("Вы получите ноутбук!");
                default -> System.out.println("Приза нет:(");
            }
            System.out.println(" ");
            System.out.println("Задание 4");
            //Проверить, попадает ли случайно сгенерированное целое число
            //из отрезка [10;500] в интервал (25;200) и вывести результат в консоль.
            int c = (int)(Math.random()*500 + 10);
            if (c >= 25 && c <= 200){
                System.out.println("Число "+ c + " содержится в интервале (25;200)");
            }else System.out.println("Число "+ c + " не содержится в интервале (25;200)");


            System.out.println(" ");
            System.out.println("Задание 5");
            // угадай число от 1 до 9
            int unknownNum, userNum;
            unknownNum = (int)(Math.random()* 10);
            Scanner u = new Scanner(System.in);
            System.out.println("Угадай число от 1 до 9");
            System.out.println("Нажми 0 для завершения");
            do {
                System.out.println("Введите ваше число");
                userNum = u.nextInt();
                if (userNum == 0) System.out.println("Chicken");
                else if (userNum < unknownNum) System.out.println("загаданное число больше");
                else if (userNum == unknownNum) System.out.println("Вы угадали");
                else System.out.println("загаданное число меньше");
            }while (userNum != 0 && unknownNum != userNum);
            System.out.println("Выход из программы");

            }


        }
}
