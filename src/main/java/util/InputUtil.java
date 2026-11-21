package util;

import java.util.Scanner;

public class InputUtil {
    public static Scanner sc = new Scanner(System.in);

    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter valid marks.");
            }
        }
    }

    public static String readString(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }
}