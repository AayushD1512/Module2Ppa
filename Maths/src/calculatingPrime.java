import java.util.Scanner;

public class calculatingPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Edge case: numbers less than or equal to 1 are not prime
        if (n <= 1) {
            System.out.println("no it ain't");
            return;
        }

        boolean isPrime = true;

        // Check divisors from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false; // Found a divisor, not prime
                break; // No need to continue checking
            }
        }

        // Output result
        if (isPrime) {
            System.out.println("yes its prime");
        } else {
            System.out.println("no it ain't");
        }
    }
}
