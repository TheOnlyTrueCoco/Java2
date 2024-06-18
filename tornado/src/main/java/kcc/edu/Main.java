package kcc.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Coty\\Java2\\tornado data\\us_tornado_dataset_1950_2021_mod.csv";

        Map<DayOfWeek, Integer> tornadoCount = new HashMap<>();
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line; 
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                try {

                    LocalDate date = LocalDate.parse(data[0], customFormatter);
                    int magnitude = Integer.parseInt(data[2]);
                    int injuries = Integer.parseInt(data[3]);

                    DayOfWeek dayOfWeek = date.getDayOfWeek();
                    tornadoCount.merge(dayOfWeek, 1, Integer::sum);

                } catch (DateTimeParseException | NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
            }

            int maxTornados = 0;
            DayOfWeek maxDay = null;
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                int count = tornadoCount.getOrDefault(dayOfWeek, 0);
                if (count > maxTornados) {
                    maxTornados = count;
                    maxDay = dayOfWeek;
                }
            }

                System.out.println("Day of the Week\tTornado Count");
                for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                    System.out.println(dayOfWeek + "\t\t\t" + tornadoCount.getOrDefault(dayOfWeek, 0));
                }
            System.out.println("The day with the most tornados:" + maxDay + "(" + maxTornados + "tornados)");
            } catch (IOException e) {

        }
    }
}