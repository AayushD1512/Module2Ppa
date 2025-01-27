import java.util.Arrays;
import java.util.Scanner;

public class primeInaRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n<2) System.out.println(0);
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;

        for(int i=2;i*i<=n;i++){

            if(arr[i]){
                for(int j =i*i; j<=n; j+=i){
                    arr[j]=false;
                }
            }

        }

        for (int i =2;i<=n;i++){
            if(arr[i]) System.out.print(i+" ");
        }
    }
}

/*
    A naive approach is to run the loop from 2 to n and inside each value run the loop that checks if that
    number is prime or not but the time complexity for this is N*(root(N)); very large so not optimal at all
    so we'll use sieve of eratoshthens to precompute as well as get to know all prime in a range and its time
    complexity is far better at O(N*log(log(N)));

    Drawback:
    If we have to find the prime numbers in the range - 10^9 to 10^10. Then this approach may not be helpful
    because the space required by the boolean array will not fit in the memory of the program. For such cases,
    the brute force approach of O(N√N) will be a better choice.
 */