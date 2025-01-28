/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class countingPrimeInARange
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        boolean isPrime[] = new boolean[1000000+1];
        Arrays.fill(isPrime,true);

        isPrime[0]=isPrime[1]=false;

        for(int i =2;i*i<=1000000;i++){
            if(isPrime[i]){
                for(int j =i*i; j<=1000000; j+=i){
                    isPrime[j] = false;
                }
            }

        }
        /* Since this alone gave TLE so we need to compute You can precompute the prefix sum of prime counts
            up to, allowing you to answer each test case in 𝑂(1). Here's how:
             -->  Precompute Prime Count: Create an array primeCount[] where primeCount[i] stores the
                  number of primes less than or equal to 𝑖
             -->  Once precomputed, you can answer each query by directly accessing primeCount[n].*/

        int preComputedPrimeCount[] = new int[1000000+1];
        for(int i=2;i<=1000000;i++){
            preComputedPrimeCount[i] += preComputedPrimeCount[i-1]+(isPrime[i] ? 1 : 0);
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t= 0; t<T;t++){
            int n = sc.nextInt();
            System.out.println(preComputedPrimeCount[n]);
        }
    }
}