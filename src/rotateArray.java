import java.util.Arrays;
import java.util.Scanner;

public class rotateArray {
    private static void reverse(int start, int end, int[] arr){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();

        }
        k%=n;

        /*\
        The logic here is pretty simple when looking closely we can see that we should achieve the required rotation
        in fairly 3 steps. --> Step 1 would be to completely reverse the whole array
                           --> Step 2 would be to reverse only the idx from i =0 to i<k
                           --> Step 3 would be to reverse from i=k to i<n
         */
        reverse(0,n-1,arr);
        reverse(0,k-1,arr);
        reverse(k,n-1,arr);

        System.out.println(Arrays.toString(arr));
    }
}


/*
The brute force logic is that --> what i need is to rotate the array by k units, so i can run a loop from
i = 0 to n-1. In which what i'll do is store the last value of the array in some temp, and then i'll overwrite
the previous values to current index so the array[1,2,4,0,2] will now look like temp having '2' the last value
and by overwriting previous values to current idx will result the array[1,1,2,4,0] and after this loop we can clearly
see the first idx needs to be changed and here will update the 0t idx with temp --> array[2,1,2,4,0] now the
array is rotated by 1 unit to rotate by 'k' units we run this look under another look that goes from i =0 to i<k

This will have O(n2):time and O(1) space, There's another approach of O(n)time and O(n) space where in we'll create
another temp array of size n & we'll run the loop from i=0 to i<n where will perform --> temp[(i+k)%n] = arr[i];
And then there's best optimised code wriiten above.
k = k%n;
        for(int i =0;i<k;i++){
            int temp = arr[n-1];
            for (int j = n-1; j >= 1; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
 */