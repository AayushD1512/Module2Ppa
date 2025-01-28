import java.util.*;
import java.lang.*;
import java.io.*;
//This was done because the Ques requires us to print the output in ascending order otherwise it can be done
//in simpler way as well using hashmap or even variable use below those approach logic are given

public class primeFactorizationMultipleQueries
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int MAX = 1000000;
        int[] spf = new int[MAX + 1]; // Smallest Prime Factor (SPF)

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

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // Number to factorize

            // Use a List to store factors and their counts
            List<int[]> factors = new ArrayList<>();

            // Prime Factorization Using SPF
            while (n > 1) {
                int prime = spf[n]; // Current smallest prime factor
                int count = 0;

                // Count the power of the current prime factor
                while (n % prime == 0) {
                    count++;
                    n /= prime;
                }

                // Add the prime and its count to the list
                factors.add(new int[]{prime, count});
            }

            // Sort factors by prime number (ensures ascending order)
            Collections.sort(factors, Comparator.comparingInt(a -> a[0]));

            // Print the factors
            for (int[] factor : factors) {
                System.out.println(factor[0] + " " + factor[1]);
            }
        }
    }
}

/*
    Explanation of the Changes
Why Sorting Is Necessary?

In edge cases, the spf[n] logic might not always traverse the prime factors in ascending order.
To fix this, we store the prime factors and their counts in a list (factors) and explicitly sort it by the prime values before printing.
How the Code Works?

For each 𝑛, we compute the prime factors and their counts using spf. Store each prime and its count in a list.
Sort the list by the prime numbers to ensure ascending order.Print the sorted list.

Sorting Logic:
Collections.sort(factors, Comparator.comparingInt(a -> a[0]));
it's used to sort a list of integer arrays based on the first element (a[0]) of each array in ascending order.


Breaking It Down
    Collections.sort:
    This method is used to sort a list. Here, the list factors contains arrays of integers (List<int[]>).
It takes two arguments: the list to be sorted and a Comparator that defines how the elements should be compared.

    Comparator.comparingInt(a -> a[0]):
    This creates a comparator (a function that specifies the sorting rule).

    a -> a[0] is a lambda expression:
    It means: "For each element a (an int[]), use the value of a[0] (the first element of the array) as the
    key for comparison."
In this case, a[0] represents the prime factor.
comparingInt ensures that the comparison is done on integers.

    How It Works in This Context:
    factors is a list of arrays where each array is of the form [prime, count].
This comparator sorts the list based on the first element (prime) of each array in ascending order.

 */

/*

    HashMap Logic:
    for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // Number to factorize

            // Prime Factorization Using SPF
            Map<Integer, Integer> factors = new LinkedHashMap<>();
            while (n > 1) {
                int prime = spf[n];
                factors.put(prime, factors.getOrDefault(prime, 0) + 1);
                n /= prime;
            }

            // Print Factors in Ascending Order
            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

 */

/*

    Normal Variable Logic:
    while (n > 1) {
                int prime = spf[n]; // Current smallest prime factor
                int count = 0;

                // Count the power of the current prime factor
                while (n % prime == 0) {
                    count++;
                    n /= prime;
                }

                // Print the prime factor and its count
                System.out.println(prime + " " + count);
            }

 */