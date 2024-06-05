package kcc.edu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter birth the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter birth the month: (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter birth the day: ");
        int day = scanner.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);

        int age = calculateAge(birthDate);

        System.out.println("Your age is " + age + " years old.");

        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();
        System.out.println("Your birthday of week is " + dayOfWeek);
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        return today.getYear() - birthDate.getYear();
    }

}