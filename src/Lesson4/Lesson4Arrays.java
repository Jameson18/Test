package Lesson4;

import java.util.Arrays;

public class Lesson4Arrays {
    public static void main(String[] args) {
        //копирование массивов
        //int[] newInts = ints1; это копирование ссылки
        int val[] = new int[]{0, 8, 3, -5, 9};
        int[] cloneVal = val.clone();
        int[] newVal = new int[15];
        /*
        Из какого массива
        с какой позиции
        в какой массив
        с какой позиции
        длина
         */
        System.arraycopy(val,2, newVal, 4, 3);
        System.out.println(Arrays.toString(newVal));

        int val1[] = new int[]{0, 8, 3, -5, 9};
        int[] copyVal1 = Arrays.copyOf(val1, 3);
        System.out.println(Arrays.toString(copyVal1));

        //Многомерные массивы
        int [][] val3 = new int[3][4];
        System.out.println(Arrays.deepToString(val3));
        int[][] val4 = new int[3][];
        System.out.println(Arrays.deepToString(val4));

        int[][] val5 = {
                {2, 3, 45},
                {5, 6, 7, 81},
                {16, -7, 444, 228}
        };
        for (int i = 0; i < val5.length; i++) {
            for (int j = 0; j < val5[i].length; j++) {
                val5[i][j] *= val5[i][j];

            }


        }System.out.println(Arrays.deepToString(val5));


    }
}
