import java.util.Arrays;
import java.util.Scanner;

public class suffixSumBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int r = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();

        }

        for (int i = n-2; i >= 0; i--) {
            arr[i]+= arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
        if (r==n-1){
            System.out.println(arr[l]);
        }else {
            System.out.println(arr[l] - arr[r+1]);
        }

    }
}
