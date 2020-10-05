package Lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class HomeTaskStrings {
    public static void main(String[] args) {
        //Задача 1
        System.out.println("Задача 1");
        System.out.println("Для пропуска нажмите Enter");
        System.out.println("Для выхода наберите exit");
        String[] words = new String[5];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            System.out.println("Добавьте слово в массив под индекс " + i);
            words[i] = s.nextLine();
            if ("exit".equals(words[i])) {
                words[i] = null;
                break;
            }
            for (String itr: words) {
                itr = words[i].intern();
            if (words[i] != itr.intern()){
                    i--;
                    System.out.println("Это слово уже было");
                }
            }
            if ("".equals(words[i])) {
                words[i] = null;
            }
        }
        System.out.println(Arrays.toString(words));
        System.out.println("");

        //Задача 2
        System.out.println("Задача 2");
        String a = "элемент, электричество, элегантный, дуэле, ковэлеро";
        String b = "эле";
        int z = a.split(b, -1).length-1;
        System.out.println("Количество вхождений " + z);
        System.out.println("");

        //Задача 3
        System.out.println("Задача 3");
        String q = "202";
        if (q.equalsIgnoreCase(new StringBuilder(q).reverse().toString())){
            System.out.println("Строка " + q + " полиндром");
        }else System.out.println("Строка " + q + " не полиндром");
        System.out.println("");

        //Задача 4
        System.out.println("Задача 4");
        String str = "gOOdByE";
        System.out.println(str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase());
        System.out.println("");

        //Задача 5
        System.out.println("Задача 5");
        String sent = "Я хочу вырваться на свободу";
        String[] sent1 = sent.split(" ");
        String longestWord = sent1[0];
        for (String find : sent1) {
            if (find.length() > longestWord.length()){
                longestWord = find;
            }
        }
        System.out.println("Самое длинное слово: " + longestWord);
    }

}
