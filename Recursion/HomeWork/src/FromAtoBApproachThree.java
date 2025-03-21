import java.util.Scanner;

public class FromAtoBApproachThree {
    static boolean found = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        convertAtoB(a,b);
        if(found){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void convertAtoB(int a, int b){
        int ans = a;
        if(ans==b){
            found = true;
            return;

        } else if (ans>b) {
            return;

        }

        ans = a*2;
        convertAtoB(ans,b);
        ans/=2;

        ans= (ans*10)+1;
        convertAtoB(ans,b);
        ans = (ans-1)/10;

    }
}