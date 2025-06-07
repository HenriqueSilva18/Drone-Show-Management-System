package lapr4.app.backoffice.console.presentation.utils;

import eapli.framework.io.util.Console;

public final class ReadValidations {

    private ReadValidations() {
    }

    public static String readValidDateString(String message) {
        while (true) {
            String input = Console.readLine(message);
            String[] parts = input.split("-");

            if (parts.length != 3) {
                System.out.println("Error: Invalid format. Please use YYYY-MM-DD.");
                continue;
            }

            try {
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);

                if (parts[0].length() != 4 || month < 1 || month > 12 || day < 1 || day > 31) {
                    System.out.println("Error: Invalid date values. Ensure year has 4 digits, month is 1-12, and day is 1-31.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Year, month, and day must be numbers.");
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
}