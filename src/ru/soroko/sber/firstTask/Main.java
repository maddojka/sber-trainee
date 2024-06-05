package ru.soroko.sber.firstTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String FILE_PATH =
            "C:\\Users\\yuriy\\IdeaProjects\\sber-firsttask\\src\\Задача ВС Java Сбер.csv";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        System.out.println("Задание 1:");
        System.out.println();
        List<City> cities = parseFile(file);
        System.out.println("Задание 2:");
        System.out.println();
        sortByName(cities);
        System.out.println();
        sortByNameAnd(cities);

    }

    public static List<City> parseFile(File file) {
        List<City> cities = new ArrayList<>();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String nextLine = scan.nextLine();
                String[] data = nextLine.split(";");
                if (data.length == 6) {
                    cities.add(new City(data[1], data[2], data[3],
                            Long.parseLong(data[4]), data[5]));
                } else {
                    cities.add(new City(data[1], data[2], data[3],
                            Long.parseLong(data[4]), "неизвестно"));
                }
               /* for (City city : cities) {
                    System.out.println(city);
                }*/
            }
        } catch (IOException e) {
            System.out.println("При чтении файла возникла ошибка");
        }
        return cities;
    }

    public static void sortByName(List<City> cities) {
        List<City> sortedByNameCities = cities.stream()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).toList();
        for (City city : sortedByNameCities) {
            System.out.println(city);
        }
    }

    public static void sortByNameAnd(List<City> cities) {
        List<City> sortedByNameCities = cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getDistrict))
                .toList();
        for (City city : sortedByNameCities) {
            System.out.println(city);
        }
    }
}
