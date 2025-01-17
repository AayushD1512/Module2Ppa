import java.util.*;

public class prefixMaxBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
//        int l = sc.nextInt();
        int r = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();

        }

        int maxm = arr[0];
        for(int i =1;i<n;i++){
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
