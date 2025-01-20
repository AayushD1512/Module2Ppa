import java.util.Scanner;

public class maxChunks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        /*
        What's happening int the following logic is:: for that we need to first understand that ques is asking
        to obtain max number of chunks that an array can be split into so that when those chunks are concatenated
        we get a resultant sorted array. So for that we need to understand we can only concluded those numbers in
        a chunk such that the value of index i --> j are contained as numbers in those arr[i] --> arr[j].

        It's also given that we'll get a size n of numbers and those numbers are from 0 to n-1 and no duplicate
        (A tip whenever there is a case where index are present in form of numbers in the array try to form a
        logic taking index into consideration)

        We can solve this ques by maintaining a max value at each iteration from the left, whenever a number
        equals to the index we can increment the counter of ans variable --> Because that means that we have
        seen all numbers <= to that index and can be considered in a chunk which can be sorted independently.
         */
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max = Math.max(max,arr[i]);
            if (max==i){
                ans++;
            }
        }
        System.out.println(ans);
    }

}



/*
Logic for O(n2) approach:

### Intuition:
Split the array into chunks such that each chunk can be sorted independently to form the final sorted array.

### Logic:
- A chunk `[i, j]` is valid if all elements in the range `[i, j]` lie between `i` and `j`.
- Use nested loops:
  - Outer loop (`i`): Marks the start of the chunk.
  - Inner loop (`j`): Expands the chunk until it becomes valid (`canBeChunked()`).
- Once a valid chunk is found, increment the chunk count and move `i` to the next position (`j + 1`).

### Key Idea:
Check each possible chunk iteratively, count it if valid, and skip ahead to maximize the number of chunks.

public static boolean canBeChunked(int i, int j, int[] arr) {
        int count = 0;
        for (int k = i; k <= j; k++) {
            if (arr[k] >= i && arr[k] <= j) {
                count++;
            }
        }
        return count == (j - i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        int i = 0;

        while (i < n) {
            for (int j = i; j < n; j++) {
                // Check if the subarray [i, j] can be a valid chunk
                if (canBeChunked(i, j, arr)) {
                    i = j + 1; // Move to the next position after the current chunk
                    break;
                }
            }
            ans++;
        }

        System.out.println(ans);
 */