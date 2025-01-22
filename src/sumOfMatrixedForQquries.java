import java.util.Arrays;
import java.util.Scanner;

public class sumOfMatrixedForQquries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int i1 = sc.nextInt();
        int j1 = sc.nextInt();
        int i2 = sc.nextInt();
        int j2 = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Code to calculate and store Prefix sum in 2D array
        int[][] prefixSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i][j] = arr[i][j];

                if (i>0){
                    prefixSum[i][j]+= prefixSum[i-1][j];
                }
                if (j>0){
                    prefixSum[i][j]+= prefixSum[i][j-1];
                }
                if(i>0 && j>0){
                    prefixSum[i][j]-= prefixSum[i-1][j-1];
                }
            }
        }

        //Code to evaluate sum of matrices between i1,j1 & i2,j2;
        int sum = 0;
        sum+= prefixSum[i2][j2];
        if(i1>0){
            sum-=prefixSum[i1-1][j2]; //subtracts rows above the matrix
        }if (j1>0){
            sum-=prefixSum[i2][j1-1]; //subtracts column left to the matrix
        }if(i1>0&&j1>0){
            sum+=prefixSum[i1-1][j1-1]; // adds the overlapping matrix one time cause subtracted twice from above calculation
        }

        System.out.println(sum);
    }
}
