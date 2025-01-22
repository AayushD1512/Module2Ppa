import javax.swing.*;
import java.util.Scanner;

public class specialSearchingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        /*
        Since rows and columns both are sorted we can start from topRight element and traverse by following condition:
            1. If key is found print idx
            2. If key < arr[i][j] then j-- (because element can not be then in same column cuz sorted).
            3. If key > arr[i][j] then i++ (because element can not be then in same row cus sorted).
         */
        int i=0,j=n-1;
        while(i<m && j>=0){
            if(arr[i][j] == key){
                System.out.println(i+" "+j);
                break;
            } else if (arr[i][j]>key) {
                j--;
            }else {
                i++;
            }
        }


    }
}
