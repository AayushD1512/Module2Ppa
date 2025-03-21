import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FromAtoB {
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(convertAtoB(a,b)){
            System.out.println("YES");
            System.out.println(path.size());
            for (int i = path.size()-1; i>=0 ; i--) {
                System.out.print(path.get(i)+" ");
            }
        }else {
            System.out.println("NO");
        }

    }

    public static boolean convertAtoB(int a, int b){
        if(a>b) return false;
        if(a==b){
            path.add(a);
            return true;
        }

        if(convertAtoB(a*2,b)){
            path.add(a);
            return true;
        }
        if(convertAtoB(a*10+1,b)){
            path.add(a);
            return true;
        }

        return false;
    }



}
