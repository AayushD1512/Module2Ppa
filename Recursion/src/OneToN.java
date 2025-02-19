import java.util.Arrays;

public class OneToN {
    public static void main(String[] args) {
        int n = 4;
        int x = 1;
        print(x,n); // 1 to N natural no.s printing.
        print2(4);

    }
    //for printing 1 to N
    static void print(int x, int n){
        if(x>n) return;
        System.out.print(x+" ");
        x++;
        print(x,n);
    }

    //for printing N to 1
    static void print2(int n){
        if(n<1){
            return;
        }
        System.out.print(n+" ");
        n--;
        print2(n);

    }
}
