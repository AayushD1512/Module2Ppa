public class DistinctPath1 {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,0,0},{0,0,0}};

//        System.out.print(countPath(0,0,3,3));
        countPath(0,0,3,3);
        System.out.println(count);
    }

//  --> For return type int

//    static int countPath(int i, int j, int m, int n){
//        if(i==m-1 || j ==n-1){
//            return 1;
//        }
//        return countPath(i,j+1,m,n) + countPath(i+1, j,m,n);
//    }

    //Alternatively if the return type is specified as "void" then declare global variable and do the following:
    static int count =0;
    static void countPath(int i, int j, int m, int n){
        if(i==m-1 || j==n-1){
            count++;
            return;
        }
        countPath(i,j+1,m,n);
        countPath(i+1,j,m,n);
    }
}
