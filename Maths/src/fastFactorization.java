import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class fastFactorization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n<2) System.out.println(0);

        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        int[] spf = new int[n+1];
        Arrays.fill(spf,-1);

        primes[0] = primes[1] = false;

        for (int i = 2; i*i <=n; i++) {
            if(primes[i]){
                spf[i] = i;  // --> for prime no. because they are their own smallest prime factor;

                for(int j = i*i; j<=n; j+=i){
                    primes[j] = false;
                    spf[j] = i;
                }
            }
        }

        int num = 16;
        while(spf[num] != -1){
            System.out.println(spf[num]+" ");
            num/= spf[num];
        }

        if(num > 1){
            System.out.println(num);
        }

    }
}

/*

    The given question is to find the prime factors for a lot of different numbers --> given as queries <--
    So we used the most optimal approach by preprocessing using of Sieve and also finding the smallest factor
    of every number and storing it in another array "spf". Time Complexity: O(N*loglog(N)) + Q*O(log(N));

    We used Sieve approach to store all prime numbers present from 1 to N. Now we need to print for each
    query of a number their prime factors for that we created a special array called "spf" which consists
    of smallest prime factor for all the respective numbers we needed to lower our time iterating over an array
    we can go from 2 to root(n) but a lot of unused prime no. and lot of unnecessary composite number would be still
    be there unused so for that when we observe lets say a number n = 6060
                                                        6060/2 --> 3030
                                                        3030/2 --> 1512
                                                        1515/3 --> 505
                                                        505/5  --> 101
                                                        101/101--> 1.
    From above we observe that we just need the smallest prime factor that will be used rest else will be unused
    so to know these 2,2,3,5 etc we need to create an array spf. for this we will mark all as -1 and then as
    we iterate within sieve part whenever a prime number is that will be marked as that --> if prime[i]==true
    then spf[i]==i;
    Then for rest within the loop where we cross out other numbers we will mark their spf as i itself.
    for(j=i*i; j<=n; j+=i) spf[j] = i;

    then run while loop
    while(spf[num] != -1){
        print(spf[num]);
        num/=spf[num]
    }
    if(num>1) print(num);

    --> this above logic replicates this here           6060/2 --> 3030
                                                        3030/2 --> 1512
                                                        1515/3 --> 505
                                                        505/5  --> 101
        and after each div and all prints 2,2,3,5 like this and since here 101 will be left we need to print
        that as well we've added another line above to print that as well.
 */
