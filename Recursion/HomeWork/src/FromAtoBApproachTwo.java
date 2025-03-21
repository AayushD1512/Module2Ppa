import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FromAtoBApproachTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> path = new ArrayList<>();
        path.add(b);

        while(b>a){
            if(b%2==0){
                b/=2;
                path.add(b);
            } else if (b%10 ==1) {
                b = (b-1)/10;
                path.add(b);
            }else {
                break;
            }
        }

        if(a==b){
            System.out.println("True");
            System.out.println(path.size());
            for (int i = path.size()-1; i>=0; i--){
                System.out.print(path.get(i)+" ");
            }
        }else {
            System.out.println("No");
        }
    }
}
