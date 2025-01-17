import java.util.Scanner;

public class maximiseTheExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        // Pre Computation
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = p*arr[0];
        suffixMax[n-1] = r*arr[n-1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1],p*arr[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1],r*arr[i]);
        }

        /* We would've wanted to get the max available values with respective p,q,r queries and
        so for that we computed prefix max and suffix max and created two arrays now the condition is
        i<j<k so we'll keep the middle element j fixed and compute the expression and update the
        ans variable in each iteration whatever the max is, so understand this as you have some
        elements "1,3,1,5,3,5,6,2" so if at a point of time you're j is at 3rd index (5) so calculate q*5
        and add that with whatever is the max at its left and at its right as well so to know what max val
        is at left and right of that number we created those two max arrays so we know when we are at q*i
        we need to add that with prefix(i-1) and suffix(i+1) which all are already precomputed with respective
        p and r queries. For the above condition the loop will run from i=1 to n-2 because i<j<k so first and
        last element cannot be considered in any case.

        ---> this is for the condition where i<j<k, if i<=j<=k then no need to add with i-1 and i+1 then we
        need to add values at every i and the loop will also run in this case from i=0 to i<n
         */
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n-1; i++) {
            ans = Math.max(prefixMax[i-1] + q*arr[i] + suffixMax[i+1],ans);
        }

        System.out.println(ans);
    }
}
