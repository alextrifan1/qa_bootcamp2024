
/*
Display the number of days in month February from a year between 1900-2016 that is read from keyboard

HINT

A year is a leap year if:
        -Is divisible by 4 but not by 100
        -Is divisible by 100 but not by 400     --> aici cred ca e gresit, trebui sa se imparta si la 400
                                                    EX: 2000 e  leap year

*/

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("An: ");
        int year = Integer.valueOf(scanner.nextLine());
        try {
            if (!(year >= 1900 && year <= 2016))
                throw new Exception("Anul trebuie sa fie [1900,2016]");

            if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
                System.out.println(29);
            } else {
                System.out.println(28);
            }
        } catch (Exception e) {
            System.out.println("Erroare: " + e);
        }
    }
}