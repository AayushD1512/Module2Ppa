/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class findingGCDLCM
{
    public static long GCD(long a, long b){
        long maximum = Math.max(a,b);
        long minimum = Math.min(a,b);

        if(minimum==0) return maximum;
        while(maximum%minimum != 0){
            long temp = maximum;
            maximum = minimum;
            minimum = temp%minimum;
        }

        return minimum;
    }
    public static long LCM(long a, long b){
        return (a*b)/GCD(a,b);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();

        System.out.print(GCD(a,b)+" "+(long)LCM(a,b));

    }
}

/*
For calculating GCD & LCM in a range of numbers we can calculate for first two elements and then and then
store it in a variable then iterate over each element from 3rd to last and calculate those for eg:

    int gcd = GCD(arr[0],arr[1]);
    for(int i=2;i<n;i++){
        gcd = GCD(gcd,arr[i]);
    }

 */