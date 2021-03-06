package pl.coderstrust.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciChecker {

    private static Map<Long, Boolean> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner;
        long number = 0;
        try {
            while (number >= 0) {
                scanner = new Scanner(System.in);
                System.out.print("Provide number (negative will exit program): ");
                number = scanner.nextLong();
                System.out.println("Is " + number + " a fibonacci number?: " + isFibonacciNumber(number));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Given number must be positive");
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        long formula1 = 5 * (number * number) + 4;
        long formula2 = 5 * (number * number) - 4;
        boolean isFibonacciNumber = isPerfectSquare(formula1) || isPerfectSquare(formula2);
        cache.put(number, isFibonacciNumber);
        return isFibonacciNumber;
    }

    private static boolean isPerfectSquare(long number) {
        long sqrt = (long) Math.sqrt(number);
        return (sqrt * sqrt == number);
    }
}
