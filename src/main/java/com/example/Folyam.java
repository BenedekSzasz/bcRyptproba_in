package com.example;
// import java.util.stream.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;

public class Folyam {
    public static void main(String [] args) {
        List<Integer> list = List.of(25, 31, 27, 42, 53, 18);
        

       List<Integer> filteredList = list.stream().filter( num -> num > 30).toList();

       filteredList.forEach(num -> System.out.print(num + " "));
       System.out.println();
       System.out.println(filteredList);

       List<Employee> empList = List.of(
               new Employee(1, "Erős István", "Szeged", 395),
               new Employee(2, "Por Ferenc", "Pécs", 481),
               new Employee(3, "Vad Áron", "Szeged", 395),
               new Employee(4, "Lőcs Árpád", "Pécs", 395),
               new Employee(5, "Lap Irén", "Szeged", 401));

       List<Employee> filtEmps = empList.stream()
        .filter(emp -> emp.getCity().equals("Pécs") && emp.getSalary() > 400)
        .toList();

        System.out.println(filtEmps);

        //Aggregáció (Összeg)
        int sum =list.stream().mapToInt(num -> num).sum();
        System.out.println("Összeg: " + sum);

        List<Double> doublelist = List.of( 1.2, 3.7, 2.4, 1.8, 4.8);
        double sum2 = doublelist.stream().mapToDouble(num -> num).sum();
        System.out.println("Összeg: " + sum2);

        int sumSalary = empList     //Deklaratív programozás
            .stream()
            .mapToInt(emp -> emp.getSalary())
            .sum();
        System.out.println("Fizetések Összege: " + sumSalary);

        int sumSalary2 = 0;         //Strukturális programozás
        for (int i = 0; i < empList.size(); i++) {
            sumSalary2 += empList.get(i).getSalary();
        }
        System.out.println("Fizetések újra: " + sumSalary2);


        int sum3 = list.stream().reduce(0, Integer::sum);
        System.out.println("Összeg: " + sum3);

        double average = list.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);
        System.out.println("Átlag: " + average);

        double doubleAverage = doublelist.stream()
            .mapToDouble(x -> x)
            .average()
            .orElse(0.0);
        System.out.println("Átlag: " + doubleAverage);

        int max =list.stream().mapToInt(x -> x).max().orElse(0);
        System.out.println("Max: " + max);

        OptionalInt maxOpt = list.stream().mapToInt(x -> x).max();
        System.out.println("Max: " + maxOpt.getAsInt());

        long count = list.stream().mapToInt(x -> x).count();
        System.out.println("Darab: " + count);

        // IntSummaryStatistics all = list.stream().mapToInt(x -> x).summaryStatistics();
        // System.out.println(all.getAverage());

        //Szegediek számolása
        long szegedCount = empList.stream().filter(emp -> emp.getCity().equals("Szeged")).count();
        System.out.println("Szegediek száma: " + szegedCount);
    }
}
