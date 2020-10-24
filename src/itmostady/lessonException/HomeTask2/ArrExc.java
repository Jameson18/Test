package itmostady.lessonException.HomeTask2;

import java.util.Arrays;
import java.util.List;

public class ArrExc extends Exception {
    public static void main(String[] args) {
        String[] arrExcs = new String[9];
        try {
            int[] arr = new int[3];
            arr[5] = 12;
        }catch (RuntimeException e) {
            arrExcs[0] = e.toString();
        }
        try {
            int a = 2;
            int b = 0;
            int c = a / b;
        }catch (RuntimeException e) {
            arrExcs[1] = e.toString();
        }
        Object type = 789;
        try {
            type = (String) type;
        }catch (RuntimeException e) {
            arrExcs[2] = e.toString();
        }
        String c = null;
        try {
            c.equals(type);
        }catch (RuntimeException e) {
            arrExcs[3] = e.toString();
        }
        c = "udh";
        try {
            Integer.parseInt(c);
        }catch (RuntimeException e) {
            arrExcs[4] = e.toString();
        }
        try {
            int[] i = new int[-5];
        }catch (RuntimeException e) {
            arrExcs[5] = e.toString();
        }
        try {
            char ch = c.charAt(6);
        }catch (RuntimeException e) {
            arrExcs[6] = e.toString();
        }
        try {
            LoggerExc koz = new LoggerExc("1");
        }catch (RuntimeException e) {
            arrExcs[7] = e.toString();
        }
        try{
            String[]flowers = { "Ageratum", "Allium", "Poppy", "Catmint" };
            List<String> flowerList = Arrays.asList(flowers);
            flowerList.add("Celosia");
        }catch (RuntimeException e) {
            arrExcs[8] = e.toString();
        }

        for (int i = 0; i < arrExcs.length; i++) {
            System.out.println("Исключение " + (i + 1) + ": " + arrExcs[i]);
        }
    }
}
class LoggerExc{
    private String txt;

    public LoggerExc(String txt) {
        setTxt(txt);
    }

    public void setTxt(String txt) {
        if (txt.length() < 3)
            throw new IllegalArgumentException("txt.length() < 3");
        this.txt = txt;
    }
}
