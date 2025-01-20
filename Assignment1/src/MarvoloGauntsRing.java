import java.util.Scanner;

public class MarvoloGauntsRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long p = sc.nextInt();
        long q = sc.nextInt();
        long r = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long[] preFix = new long[n];
        preFix[0] = arr[0]*p;
        for (int i = 1; i < n; i++) {
            preFix[i]=Math.max(preFix[i-1], arr[i]*p);
        }

        long[] sufFix = new long[n];
        sufFix[n-1] = arr[n-1]*r;
        for (int i =n-2 ; i >= 0; i--) {
            sufFix[i]=Math.max(sufFix[i+1], arr[i]*r);
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,(preFix[i]+arr[i]*q+sufFix[i]));
        }
        System.out.println(ans);
    }
}
