package Tema1;//Calculate the sum of the first 100 numbers higher than 0. Name the class (and java file) Tema1.SumOfNumbers.

public class SumOfNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
