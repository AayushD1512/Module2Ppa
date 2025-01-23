import java.util.Scanner;

public class sumOfAllSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= arr[i]*(i+1)*(n-i);
        }
        System.out.println(sum);

    }
}

/*
Code for modulo operator:
long mod = 1000000000+7;
        long sum = 0;

        for(int i=0;i<n;i++){

            long contribution = ((i+1)%mod * (n-i)%mod)%mod;
            sum = (sum + ((arr[i] % mod) * (contribution % mod) % mod)) % mod;


        }

        System.out.print(sum % mod);
 */


/*
    A naive and optimal approach is being mathematical about it:
    ### Intuition and Logic for Sum of All Subarrays

1. **Contribution of Each Element:**

   - Every element in the array contributes to multiple subarrays.
   - To calculate its total contribution, consider the number of subarrays it appears in.

2. **Number of Subarrays Including arr[i]:**

   - Starting Points: The element `arr[i]` can be part of subarrays starting at any index from `0` to `i`. This gives `(i + 1)` possible starting points.
   - Ending Points: Similarly, it can be part of subarrays ending at any index from `i` to `n - 1`. This gives `(n - i)` possible ending points.

3. **Total Contribution of arr[i]:**

   - Multiply the number of starting points and ending points to get the total number of subarrays including `arr[i]`.
   - Contribution = `arr[i] * (i + 1) * (n - i)`.

4. **Edge Cases to Consider:**

   - Empty array: Sum is `0`.
   - Single-element array: Sum equals the element itself.
   - Large values: Use appropriate data types (e.g., `long long` for integers, `double` for floating-point numbers).
   - Negative values and zeros are handled naturally by the formula.

    int sumOfSubarrays(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        // Contribution of arr[i]
        sum += arr[i] * (i + 1) * (n - i);
    }
    return sum;
}


 */