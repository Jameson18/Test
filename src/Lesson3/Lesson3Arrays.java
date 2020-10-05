package Lesson3;

import java.util.Arrays;

public class Lesson3Arrays {
    public static void main(String[] args) {
        /*
        массивы - хранение элементов одного типа данных в контейнере.
        длина массива задается при его создании и ее нельзя изменить.
        массивы это объект, ссылочный тип данных.
        элементы хранятся под индексами начиная с ноля.
        Объявление переменной массива: тип_данных[] имя_переменной
         */
        int[] ints1;
        //int ints1[]; верно, но не желательно!!!
        /*
        Создание массива:
        new int[длина_массива];
         */
        ints1 = new int[5];//создан массив на 5 элементов, значения по умолчанию.
        /*
        по умолчанию:
        целые числа: 0
        с плавающей точкой: 0.0
        boolean: false
        char: '\u0000' ()
        ссылочные типы: null
         */
        int[] ints2 = {45, 90, 12, -88, 54, 8, -221};
        //ints2 = {45, 90, 12, -88, 54, 8, -221};no
        ints2 = new int[]{45, 12, 8, -221};
        // доступ к элементам массива осуществляется по индексу:
        // имя_массива[индекс_элемента]
        int ints2Elements = ints2[3];
        ints2[1] = 4147;
        //ints2[1] = 4147; обращение к несуществующему элементу массива обвалит всю программу(Exception)
        // длина массива
        System.out.println(ints2.length);// 4 int
        // вывод в консоль
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

        // перебор элементов массива
        ints2 = new int[]{60, -80, 0, 200, 44};
        //iter + enter
        for (int elem : ints2) {
            System.out.println("elem = " + elem);
            //elem *= 2; в данном цикле изменить элементы массива не можем
            for (int i = 0; i < ints2.length; i++) {
                System.out.println("ints2[i] = " + ints2[i]);
                ints2[i] = 90;

            }
            System.out.println(Arrays.toString(ints2));

            //сравнение массивов
            ints1 = new int[]{45, 90, 12, -88, 54, 8, -221};
            ints2 = new int[]{45, 90, 12, -88, 54, 8, -221};
            System.out.println(Arrays.equals(ints1, ints2));
            //compare, compareUnsigned,   РАЗОБРАТЬ - ПРОЧИТАТЬ!!!!

            // сортировка массива
            Arrays.sort(ints1); // Arrays.sort(ints1, [from, to)) от меньшего к большему
            Arrays.parallelSort(ints2); // до 10000 примерно

            // поиск в отсортированном массиве
            ints1 = new int[]{-45, 0, 12, 88, 540, 800, 2210};
            System.out.println(Arrays.binarySearch(ints1, 12)); // 1
            System.out.println(Arrays.binarySearch(ints1, 55)); // -3

            /*
            mismatch(Вызывается, Scanner чтобы указать, что полученный токен не соответствует
            шаблону для ожидаемого типа или что токен находится вне диапазона для ожидаемого типа.)
             */

        }

    }
}
