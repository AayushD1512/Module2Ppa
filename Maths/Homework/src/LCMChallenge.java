
import java.util.*;
public class LCMChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        if(n==1) ans = 1;
        else if (n==2) {
            ans = 2;
        } else if (n==3) {
            ans = 6;
        }
        else if(n%2==0){
            if(n%3==0){
                ans = (n-1)*(n-2)*(n-3);

            }else {
                ans = n*(n-1)*(n-3);
            }
        }
        else {
            ans = n*(n-1)*(n-2);
        }
        System.out.println(ans);
    }
}
