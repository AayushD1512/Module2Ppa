public class PowFastExponentiation {
    public static void main(String[] args) {
        System.out.println(powerOfX(4,3));
    }
    private static int powerOfX(int n, int k){
        if(k==0){
            return 1;
        }

        int x = powerOfX(n,k/2);
        if(k%2==0){
            return x*x;
        }
        return x*x*n;
    }
}


/*

 ---Condition--	             |   Why?---
    n == Integer.MIN_VALUE	 |   To avoid overflow when negating n; handle it by using Integer.MAX_VALUE and multiplying once more.
    n < 0	                 |   Because x^-n = (1/x)^n; makes the power calculation simpler with a positive exponent.


    class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }

        if(n==Integer.MIN_VALUE){
            x=1/x;
            return x*myPow(x,Integer.MAX_VALUE);
        }

        if(n<0){
            x = 1/x;
            n = -n;
        }
        double k = myPow(x,n/2);
        if(n%2==0){
            return k*k;
        }
        return k*k*x;
    }
}
 */