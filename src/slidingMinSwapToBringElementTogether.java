import java.util.Scanner;

public class slidingMinSwapToBringElementTogether {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        int window = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]<=k) window++;
        }

        int lessThanKCount = 0;
        for (int i = 0; i < window; i++) {
            if(arr[i]<=k){
                lessThanKCount++;
            }
        }

        int minm = window - lessThanKCount;
        for (int i = k; i < n; i++) {
            if(arr[i-k]<=k){
                lessThanKCount--;
            }
            if(arr[i]<=k){
                lessThanKCount++;
            }
            minm = Math.min(minm,window-lessThanKCount);
        }
        System.out.println(minm);

    }
}
/*
    Question: Given an array[n] and 'k' we have to find the minimum number of swaps to bring all elements <=k
    together. (Note: 'k' is the element and not the size of window)

    Example: arr[2,1,5,6,3]  k=3 , ans = 1; (only 1 swap is needed of 5 and 3 to bring all elements <=3 together)

    Logic and Intuition:
    We can solve this with either two pointer and/or Sliding Window technique the above soln is of sliding window

    We will first find the size of the window to operate, that we will calculate by finding all the count
    elements in the array that are <=k (window)==> and this will be our working window.

    now from i =0 to i<k we'll calculate the count of elements(lessThanKCount) that are <=k in first window,
    and we will store the swap for this window in "minm" = window - lessThanKCount. (This is done bcz lets
    consider the above example 2,1,5,6,3 --> here the first window of 2,1,5 contains 2 elements <=k(3) so we
    know that by only swapping 5 our job will be done and that count of swap will be window-lessThanKCount)

    The next step will be to run loop from i=k to i<n and at each i we will check broadly two things:
        1. if(arr[i-k]<=k) lessThanKCount--; --> if when we leave the previous elements and if it does contain
                                                 element<=k we will subtract from the count &
        2. if(arr[i]<=k) lessThanKCount++; --> if when we consider new element in the window if it does contain
                                               the element<=k we will increment the count by 1.

    & then at after these two above steps we will update the count of minm by checking if the minm stored is
    already minimum or the in the new window count is lower (window - lessThanKCount).

 */