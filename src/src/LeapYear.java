
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
        int year;
        System.out.println("1: Foloseste anul din string[] args\n" + "2: citeste un an de la tastatura: 2");
        String mode = scanner.nextLine();

        switch (mode) {
            case "1":
                if (args.length != 1) {
                    System.out.println("Trebuie sa existe un singur argument in args");
                    break;
                }
                year = Integer.parseInt(args[0]);
                System.out.println("Anul este " + year);

                try {
                    if (!(year >= 1900 && year <= 2016))
                        throw new Exception("Anul trebuie sa fie din intervalul 1900 - 2016");

                    if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
                        System.out.println("29 de zile");
                    } else {
                        System.out.println("28 de zile");
                    }

                } catch (Exception e) {
                    System.out.println("Eroare: " + e);
                }
                break;
            case "2":
                System.out.println("Alege un an: ");
                year = Integer.parseInt(scanner.nextLine());
                try {
                    if (!(year >= 1900 && year <= 2016))
                        throw new Exception("Anul trebuie sa fie din intervalul 1900 - 2016");

                    if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
                        System.out.println("29 de zile");
                    } else {
                        System.out.println("28 de zile");
                    }

                } catch (Exception e) {
                    System.out.println("Eroare: " + e);
                }
                break;
            default:
                System.out.println("Trebuie sa alegi 1 sau 2");

        }

    }
}