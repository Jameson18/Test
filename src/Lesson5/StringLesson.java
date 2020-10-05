package Lesson5;

import java.util.Arrays;
import java.util.Objects;

public class StringLesson {
    public static void main(String[] args) {
        /*
        char - Unicode символ 16 бит
        от 0 до 65536 и от '\u0000' to '\uffff'
         */
        char char1 = 'J'; // сам символ в одинарных ковычках
        char char2 = 74;// номер символа
        char char3 = '\u0044';//шестнадцатиричное представление
        System.out.println(char1);
        System.out.println(char2);
        System.out.println(char3);

        System.out.println("\nСтроки");
        //Строка - упорядоченная последовательность символов
        //Строки - объекты (ссылочные), создаются на основе классов String
        //Строки задаются:
        // в " ", используя new String() - на крайний случай
        //Строки нельзя изменить, только создать новую на основе существующей
        //Все строковые литералы,
        //например, System.out.println("\nСтроки"); реализованы
        //как экземпляры String

        char[] jjdChars = {'\u004A', '\u004A', '\u0044',};
        String jjdString = new String(jjdChars);
        jjdString = "\u004A\u004A\u0044";
        System.out.println(jjdString);//JJD
        System.out.println(jjdString.length());//3
        System.out.println(jjdString.codePoints().count());//3

        char[] frogChars = {'\uD83D', '\uDC38'};
        String frogString = new String(frogChars);
        frogString = "\uD83D\uDC38";
        System.out.println(frogString);//🐸
        System.out.println(frogString.length());//2
        System.out.println(frogString.codePoints().count());//1

        //хранение строк до JAVA 9: массив char[] в кодировке UTF-16
        //прри этом каждый char был представлен 2 байтами
        //начиная с JAVA 9(компактные строки): массив byte[] + кодировка UTF-16 или LATIN1

        System.out.println("Пул строк");
        // пул строк (находится в памяти heap) хранит только одну
        // копию каждого строкового литерала
        String string1 = "Строка";
        String string2 = "Строка";
        String string3 = new String("Строка");
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
        // помещение строки в пул строк - интернирование!

        System.out.println("Метод intern()");
        String internStr = string3.intern();// сохранение строки в пуле строк/возвращение
        //ссылки на существующий объект
        System.out.println(string1 == internStr);//true
        System.out.println(string2 == internStr);//true
        System.out.println(string3 == internStr);//false

        System.out.println("строка".equalsIgnoreCase(string1));//true
        System.out.println("строка".equals(string1));//false


        String nullString = null;
        System.out.println(nullString == null);
        System.out.println(null == null);
        System.out.println(Objects.nonNull(nullString));//false
        System.out.println(Objects.isNull(nullString));//true

        String[] animals = {"кот", "пес", "гусь"};
        String[] animal = new String[animals.length * 2];
        for (int i = 0; i < animal.length; i++) {
            animal[i] = animals[(int) (Math.random() * animals.length)];
        }
        System.out.println(Arrays.toString(animal));
        //String.join(delimetr"^^^^", string1, string2, stringN);


        //Буферизованные строки
        String concatStr = "";
        for (int i = 0; i < 10; i++) {
            concatStr += i + " ";
        }
        System.out.println(concatStr);
        //StringBuilder - работает быстрее, но не является потокобезопасным
        //StringBuffer - работает медленее, но потокобезопасен
        StringBuilder sb = new StringBuilder(string1);
        sb.append(" :: ").append(string2);
        System.out.println(sb.toString());

        concatStr = "";
        sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }concatStr = sb.toString();
        System.out.println(concatStr);

        //сравнение строк
        string1 = "Строка";
        string2 = "Строка";
        System.out.println();
        System.out.println(string1.compareTo(string2));
        System.out.println("строка".equalsIgnoreCase("Строка"));
        System.out.println("строка".compareTo("Строка"));
        System.out.println("строка".compareTo("строка"));
        System.out.println("Строка".compareTo("строка"));
        System.out.println("строка".compareToIgnoreCase("Строка"));
        string1 = "JJD";
        System.out.println(string1.startsWith("JJ"));//true
        System.out.println(string1.endsWith("D"));//true
        System.out.println(string1.startsWith("D",2));//true
        //приведение к регистру
        string1 = string1.toLowerCase();
        System.out.println(string1);
        string1 = string1.toUpperCase();
        System.out.println(string1);
        //замена
        string1 = string1.replace("D","!");
        System.out.println(string1);
        string1 = string1.replaceAll("J","!");//можно передать регулярные выражения
        System.out.println(string1);
        string1 = string1.replaceFirst("!", "J");
        System.out.println(string1);
        string1 = "JJD";
        System.out.println(string1.contains("D"));
        string1 = "JAVA PYTHON P HP";
        String[] strings = string1.split(" ");
        System.out.println(Arrays.toString(strings));

        //убрать пробелы trim/strip/stripLeading/stripTrailing
        //trim убирает пробелы меньше или равно \u0020
        //strip убирает пробелы вообще
        //stripLeading с начала строки убирает
        //stripTrailing  с конца убирает
        string1 = "О J K";
        System.out.println(string1.strip());
    }
}
