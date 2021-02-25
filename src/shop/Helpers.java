package shop;

import java.util.Scanner;

public class Helpers {
    private static Scanner scanner = new Scanner(System.in);

    public Helpers() {
    }

    public static int selectNumber(int min, int max) {
        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Вы ввели не целое число. Повторите попытку:");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();

            if (number >= min && number <= max) {
                return number;
            } else {
                System.out.println("Введите число от " + min + " до " + max + ". Повторите попытку:");
            }
        }
    }

    public static String selectString() {
        return scanner.next().trim();
    }
}