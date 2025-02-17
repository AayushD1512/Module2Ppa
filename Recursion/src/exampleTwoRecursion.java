public class exampleTwoRecursion {
    public static void main(String[] args) {
        int x = 0;
        func(x);
    }
    static void func(int x){
        System.out.print(x);
        if(x>=3) return;
        x++;
        func(x);
        x++;
        func(x);
    }
}
