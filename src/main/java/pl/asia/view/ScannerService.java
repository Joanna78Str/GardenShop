package pl.asia.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class ScannerService {

    static int readInt() {
        return new Scanner(System.in).nextInt();
    }

    static String readString() {
        return new Scanner(System.in).nextLine();
    }

    static long readLong() {
        return new Scanner(System.in).nextLong();
    }

    static LocalDate readDate() {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }
}