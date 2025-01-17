import java.util.Arrays;
import java.util.Scanner;

public class prefixSumBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();

        }

        for (int i = 1; i < n; i++) {
            arr[i]+= arr[i-1];
        }
        System.out.println(Arrays.toString(arr));
        if (l==0){
            System.out.println(arr[r]);
        }else {
            System.out.println(arr[r] - arr[l-1]);
        }

    }
}
