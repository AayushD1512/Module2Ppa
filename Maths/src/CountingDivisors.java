import java.util.*;
import java.lang.*;
import java.io.*;

public class CountingDivisors
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int MAX = 1000000;
        int[] spf = new int[MAX + 1]; // Smallest Prime Factor (SPF)

        // --> Following is also a way where you can calculate SPF without doing it side by side of Sieve calculation
        // Initialize SPF using Sieve of Eratosthenes
        for (int i = 1; i <= MAX; i++) {
            spf[i] = i; // Initialize with self
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) spf[j] = i; // Set the smallest prime factor
                }
            }
        }

        // Input Processing
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = sc.nextInt(); // Number of elements in the array
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int num : A) {
                int count = 0;
                int lastPrime = -1; // To track unique primes
                while (num > 1) {
                    int prime = spf[num]; // Current smallest prime factor
                    if (prime != lastPrime) { // Count only unique primes
                        count++;
                        lastPrime = prime;
                    }
                    num /= prime;
                }
                System.out.print(count + " "); // Print the count for this number
            }
            System.out.println(); // Move to the next line after each test case
        }
    }
}