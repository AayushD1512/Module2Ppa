import java.util.Arrays;
import java.util.Scanner;

public class suffixMaxBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
//        int l = sc.nextInt();
        int r = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();

        }

        int maxm = arr[n-1];
        for(int i =n-2;i>=0;i--){
            if(arr[i]>=maxm){
                maxm = arr[i];
            }else {
                arr[i] = maxm;
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[r]);
    }
}
