public class DivideAndConquerBasic {
    public static void main(String[] args) {
        int arr[] = {4,2,5,0,3};
        System.out.println(getMax(0,arr.length-1,arr));
    }

    static int getMax(int i, int j, int[] arr){
        if(i==j){
            return arr[i];
        }

        int m = (i+j)/2;
        int l = getMax(i,m,arr);
        int r = getMax(m+1,j,arr);

        return Math.max(l,r);
    }
}
