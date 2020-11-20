package itmostady.streamAPI.Pupil;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        // обращение к enum Gender через имя класса - Pupil.Gender
        // Используя Stream API:

        Pupil pupil1 = new Pupil(12, "Tom", Pupil.Gender.MALE,
                LocalDate.of(1999, 10, 11));
        Pupil pupil2 = new Pupil(13, "Max", Pupil.Gender.MALE,
                LocalDate.of(1999, 7, 20));
        Pupil pupil3 = new Pupil(14, "Dina", Pupil.Gender.FEMALE,
                LocalDate.of(1998, 1, 8));
        Pupil pupil4 = new Pupil(11, "Tom", Pupil.Gender.MALE,
                LocalDate.of(2000, 12, 20));
        Pupil pupil5 = new Pupil(16, "Toma", Pupil.Gender.FEMALE,
                LocalDate.of(1994, 10, 1));
        Pupil pupil6 = new Pupil(15, "Karina", Pupil.Gender.FEMALE,
                LocalDate.of(1991, 11, 30));
        Pupil pupil7 = new Pupil(17, "Aid", Pupil.Gender.MALE,
                LocalDate.of(2001, 2, 6));
        Pupil pupil8 = new Pupil(18, "Mall", Pupil.Gender.FEMALE,
                LocalDate.of(1995, 8, 26));
        Pupil pupil9 = new Pupil(19, "Bart", Pupil.Gender.MALE,
                LocalDate.of(1997, 4, 13));
        Pupil pupil10 = new Pupil(20, "Lisa", Pupil.Gender.FEMALE,
                LocalDate.of(2002, 7, 6));
        ArrayList<Pupil> pupilList = new ArrayList<>();
        pupilList.add(pupil1);
        pupilList.add(pupil2);
        pupilList.add(pupil3);
        pupilList.add(pupil4);
        pupilList.add(pupil5);
        pupilList.add(pupil6);
        pupilList.add(pupil7);
        pupilList.add(pupil8);
        pupilList.add(pupil9);
        pupilList.add(pupil10);
        System.out.println(pupilList);
        System.out.println("-----GenderList-----");
        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, List<Pupil>> genderArrayListMap = pupilList.stream().collect(Collectors
                .groupingBy(Pupil::getGender));
        System.out.println(genderArrayListMap);
        // 2. Найти средний возраст учеников
        System.out.println("-----MiddleAge-----");
        Double midAge = pupilList.stream().mapToLong(Pupil::getAge).average().getAsDouble();
        System.out.println(midAge);
        // 3. Найти самого младшего ученика
        System.out.println("-----YoungestPupil-----");
        Pupil young = pupilList.stream().max(Comparator.comparing(Pupil::getBirth)).orElse(pupil1);
        System.out.println(young);
        // 4. Найти самого старшего ученика
        System.out.println("-----OldestPupil-----");
        Pupil old = pupilList.stream().min(Comparator.comparing(Pupil::getBirth)).orElse(pupil1);
        System.out.println(old);
        // 5. Собрать учеников в группы по году рождения
        System.out.println("-----GroupByBirth-----");
        Map<Integer, List<Pupil>> groupBirth = pupilList.stream().collect(Collectors.groupingBy(Pupil::getYear));
        System.out.println(groupBirth);
        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        System.out.println("-----SameNameRemove-----");
        Map<String, LocalDate> notSame = pupilList.stream().collect
                (Collectors.toMap(Pupil::getName, Pupil::getBirth, LocalDate::with));
        System.out.println(notSame);
        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке),
        // собрать в список (List)
        System.out.println("-----SortedList-----");
        List<Pupil> sortedList = pupilList.stream().sorted(Comparator.comparing(Pupil::getGender)
                .thenComparing(Pupil::getBirth).thenComparing(Pupil::getName).reversed()).collect(Collectors.toList());
        System.out.println(sortedList);
        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        System.out.println("-----AgePeriod-----");
        List<Pupil> agePeriod = pupilList.stream().filter(x -> x.getAge() > 18).filter(x -> x.getAge() < 22)
                .collect(Collectors.toList());
        System.out.println(agePeriod);
        // 9. Собрать в список всех учеников с именем=someName
        System.out.println("-----SomeName-----");
        String name = "Tom";
        List<Pupil> someName = pupilList.stream().filter(x -> name.equalsIgnoreCase(x.getName()))
                .collect(Collectors.toList());
        System.out.println(someName);
        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников
        // данного пола
        System.out.println("-----GenderAge-----");
        Map<Pupil.Gender, Integer> genderAge = pupilList.stream().collect(Collectors.groupingBy(Pupil::getGender,
                Collectors.summingInt(Pupil::getAge)));
        System.out.println(genderAge);


    }
}
