public class exampleOneRecursion {
    public static void main(String[] args) {
        func(0);
    }
    static void func(int n){
        System.out.print(n);
        if(n>=3) return;
        func(n+1);
        func(n+2);
    }
}
