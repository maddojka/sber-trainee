import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String FILE_PATH =
            "C:\\Users\\yuriy\\IdeaProjects\\sber-firsttask\\src\\Задача ВС Java Сбер.csv";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        parseFile(file);
    }

    public static void parseFile(File file) {
        try (Scanner scan = new Scanner(file);) {
            while (scan.hasNext()) {
                String nextLine = scan.nextLine();
                List<City> cities = new ArrayList<>();
                String[] data = nextLine.split(";");
                if (data.length == 6) {
                    cities.add(new City(data[1], data[2], data[3],
                            Long.parseLong(data[4]), data[5]));
                } else {
                    cities.add(new City(data[1], data[2], data[3],
                            Long.parseLong(data[4]), "неизвестно"));
                }
                for (City city : cities) {
                    System.out.println(city);
                }
            }
        } catch (IOException e) {
            System.out.println("При чтении файла возникла ошибка");
        }
    }
}
