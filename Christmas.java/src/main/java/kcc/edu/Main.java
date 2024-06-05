package kcc.edu;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        LocalDate christmas = LocalDate.of(today.getYear(), Month.DECEMBER, 25);

        long daysUntilChristmas = ChronoUnit.DAYS.between(today, christmas);

        System.out.println(daysUntilChristmas);
    }
}
