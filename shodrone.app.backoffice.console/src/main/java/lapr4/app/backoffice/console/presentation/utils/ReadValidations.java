package lapr4.app.backoffice.console.presentation.utils;

import eapli.framework.io.util.Console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class ReadValidations {

    private ReadValidations() {
    }

    public static String readValidDateString(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();

        while (true) {
            String input = Console.readLine(message);
            try {
                LocalDate date = LocalDate.parse(input, formatter);

                if (date.isAfter(today)) {
                    return input;
                } else {
                    System.out.println("Error: The date must be in the future.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date or format. Please use yyyy-MM-dd and enter a valid date.");
            }
        }
    }

    public static String readValidTimeString(String message) {
        while (true) {
            String input = Console.readLine(message);
            String[] parts = input.split(":");

            if (parts.length != 2) {
                System.out.println("Error: Invalid format. Please use HH:MM.");
                continue;
            }

            try {
                int hour = Integer.parseInt(parts[0]);
                int minute = Integer.parseInt(parts[1]);

                if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                    System.out.println("Error: Invalid time values. Hour must be 0-23 and minute must be 0-59.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Hour and minute must be numbers.");
            }
        }
    }

    public static int readValidInteger(String message, int minValue) {
        while (true) {
            try {
                final int value = Console.readInteger(message);
                if (value >= minValue) {
                    return value;
                }
                System.out.printf("Error: The number must be equal or greater than %d.%n", minValue);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static double readValidDouble(String message, double min, double max) {
        while (true) {
            try {
                final double value = Console.readDouble(message);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Error: The value must be between %.1f and %.1f.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
            }
        }
    }

    public static String readValidString(String s) {
        while (true) {
            String input = Console.readLine(s);
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Error: Input cannot be empty. Please enter a valid string.");
        }
    }
}