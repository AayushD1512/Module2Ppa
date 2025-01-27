import java.util.Scanner;

public class CountingDivisors {

    public static void countingDivisors(long n) {
        int[] primes = new int[(int) (n + 1)];
        int[] smallestPrimeFactors = new int[(int) (n + 1)];
        int count = 0, ans = 1;

        // Initialize primes and smallestPrimeFactors
        for (int i = 0; i <= n; i++) {
            primes[i] = 1; // Assume all numbers are prime initially
            smallestPrimeFactors[i] = -1;
        }

        // Mark 0 and 1 as not prime
        primes[0] = 0;
        primes[1] = 0;

        // Sieve of Eratosthenes to populate smallest prime factors
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 1) {
                for (int j = i; i * j <= n; j++) {
                    primes[i * j] = 0; // Mark as non-prime
                    smallestPrimeFactors[i * j] = i; // Record smallest prime factor
                }
            }
        }

        int initial = smallestPrimeFactors[(int) n];
        while (smallestPrimeFactors[(int) n] != -1) {
            if (initial == smallestPrimeFactors[(int) n]) {
                count++;
                ans *= (count + 1);
            } else {
                count = 1;
                initial = smallestPrimeFactors[(int) n];
            }
            n /= smallestPrimeFactors[(int) n];
            System.out.print(count + " ");
        }

        if (n != 1) {
            count = 1;
            System.out.print(count + " ");
            ans *= (count + 1);
        }
        ans *= (count + 1);
        System.out.println("ans: " + ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of queries
        int queries = sc.nextInt();
        while (queries-- > 0) {
            long n = sc.nextLong();
            countingDivisors(n);
        }

        sc.close();
    }
}


/*

    import java.util.*;

public class UniquePrimeFactors {

    // Precompute smallest prime factors (SPF) for numbers up to MAX
    private static final int MAX = 1000000;
    private static int[] spf = new int[MAX + 1]; // Smallest Prime Factor array

    // Function to compute the SPF array using a sieve-like approach
    private static void computeSPF() {
        for (int i = 1; i <= MAX; i++) {
            spf[i] = i; // Initialize each number to itself
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) { // If `i` is a prime number
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i; // Update SPF for multiples of `i`
                    }
                }
            }
        }
    }

    // Function to count the number of unique prime factors of a number
    private static int countUniquePrimeFactors(int num) {
        int uniqueCount = 0;
        int lastFactor = -1;

        while (num != 1) {
            int currentFactor = spf[num];
            if (currentFactor != lastFactor) {
                uniqueCount++; // Count a new unique prime factor
                lastFactor = currentFactor;
            }
            num /= currentFactor; // Reduce the number
        }

        return uniqueCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Precompute SPF array
        computeSPF();

        int T = sc.nextInt(); // Number of test cases
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            int N = sc.nextInt(); // Number of elements in the array
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                result.append(countUniquePrimeFactors(A[i])).append(" ");
            }
            result.append("\n");
        }

        System.out.print(result.toString());
        sc.close();
    }
}


 */