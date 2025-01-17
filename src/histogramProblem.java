import java.util.*;

public class histogramProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = arr[0];
        suffixMax[n-1] = arr[n-1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1],arr[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1],arr[i]);
        }


        int ans = 0;
        for(int i=1;i<=n-2;i++){
            int deciderHeight = Math.min(prefixMax[i-1],suffixMax[i+1]);

            if(deciderHeight>arr[i]){
                ans+= deciderHeight - arr[i];
            }
        }
        System.out.println(ans);
    }
}

                                        // Using two Pointer approach

/*    int leftMax = 0, rightMax = 0;
    int ans = 0;
    int i = 0, j = n - 1;

    while (i <= j) {
        if (leftMax <= rightMax) {
            // Process the left pointer
            leftMax = Math.max(leftMax, arr[i]);
            ans += Math.max(0, leftMax - arr[i]);
            i++;
        } else {
            // Process the right pointer
            rightMax = Math.max(rightMax, arr[j]);
            ans += Math.max(0, rightMax - arr[j]);
            j--;
        }
    }
    System.out.println(ans);
*/

/*
### Trapping Rainwater Problem - Notes for Future Reference

---

        #### **Problem Statement**
Given an array `arr` representing the heights of bars in a histogram, calculate the total amount of water that can be trapped between the bars after it rains.

---

        ### **Intuition and Approach**

        1. **Visualizing the Problem**:
        - Each bar in the histogram can trap water on top of it if and only if there are taller bars both to its left and right.
        - The amount of water a bar can trap depends on the height of the smallest taller bar on its left and right.
        - The trapped water for a bar at position `i` is given by:
        \[
        \text{trapped water} = \max(0, \min(\text{leftMax}, \text{rightMax}) - \text{height}[i])
        \]
        - Where:
        - `leftMax` is the tallest bar to the left of `i`
        - `rightMax` is the tallest bar to the right of `i`

        2. **Key Observations**:
        - The bars at the edges (first and last) cannot trap water since they lack one of the boundaries (either left or right).
        - Precomputing the `leftMax` and `rightMax` values for all bars allows efficient calculation of trapped water for each bar.

        3. **Steps to Solve**:
        - Compute an array `prefixMax[]` where `prefixMax[i]` stores the maximum height of the bars from the start up to `i`.
        - Compute an array `suffixMax[]` where `suffixMax[i]` stores the maximum height of the bars from `i` to the end.
   - For each bar `i` (excluding the first and last), calculate:
        \[
        \text{trapped water at } i = \max(0, \min(\text{prefixMax}[i-1], \text{suffixMax}[i+1]) - \text{height}[i])
        \]
        - Accumulate the trapped water for all such bars to get the total.

4. **Why Precompute `prefixMax` and `suffixMax`?**
        - Calculating `leftMax` and `rightMax` for each bar in a naive manner would involve nested loops, leading to an \(O(n^2)\) time complexity.
        - Precomputing these arrays allows us to reduce the time complexity to \(O(n)\) by making the calculation for each bar a constant-time operation.

        5. **Time Complexity**:
        - Constructing `prefixMax` and `suffixMax`: \(O(n)\)
        - Calculating trapped water: \(O(n)\)
        - Overall: \(O(n)\)

        6. **Space Complexity**:
        - `prefixMax` and `suffixMax` require \(O(n)\) additional space.
        - Can be optimized to \(O(1)\) by using two pointers (optimized approach discussed later).

        ---

        ### **Algorithm**
        1. **Input**: Array `arr` of size `n`.
        2. Compute `prefixMax[]`:
        - `prefixMax[0] = arr[0]`
        - For `i = 1` to `n-1`: `prefixMax[i] = max(prefixMax[i-1], arr[i])`
        3. Compute `suffixMax[]`:
        - `suffixMax[n-1] = arr[n-1]`
        - For `i = n-2` to `0`: `suffixMax[i] = max(suffixMax[i+1], arr[i])`
        4. Calculate trapped water:
        - Initialize `ans = 0`
        - For `i = 1` to `n-2`:
        - Compute `deciderHeight = min(prefixMax[i-1], suffixMax[i+1])`
        - If `deciderHeight > arr[i]`: Add `deciderHeight - arr[i]` to `ans`
        5. Output `ans`.

        ---

        ### **Edge Cases**
        - Array with size less than 3: No water can be trapped.
  - Example: `arr = [2, 1]` → Output: `0`
        - Flat terrain (all heights are the same): No water trapped.
  - Example: `arr = [1, 1, 1]` → Output: `0`
        - All bars increasing or decreasing:
        - Example: `arr = [1, 2, 3, 4]` → Output: `0`

        ---

        ### **Dry Run**
For `arr = [3, 0, 0, 2, 0, 4]`:

        1. **prefixMax**: `[3, 3, 3, 3, 3, 4]`
        2. **suffixMax**: `[4, 4, 4, 4, 4, 4]`
        3. Calculating trapped water:
        - `i = 1`: `deciderHeight = min(3, 4) = 3`, water = `3 - 0 = 3`
        - `i = 2`: `deciderHeight = min(3, 4) = 3`, water = `3 - 0 = 3`
        - `i = 3`: `deciderHeight = min(3, 4) = 3`, water = `3 - 2 = 1`
        - `i = 4`: `deciderHeight = min(3, 4) = 3`, water = `3 - 0 = 3`
        - Total = `3 + 3 + 1 + 3 = 10`

        ---

        ### **Optimized Approach**
Using two pointers to avoid extra space:
        - Use a `left` pointer starting at the beginning and a `right` pointer at the end.
        - Keep track of `leftMax` and `rightMax` as you move the pointers inward.
        - Calculate trapped water based on the minimum of `leftMax` and `rightMax` at each step.

---

        ### **Takeaways**
        - This is a classic problem demonstrating the importance of precomputation for optimization.
- The `two-pointer` technique is a space-efficient alternative for many array-based problems.
        - Always visualize the problem with a diagram or test cases to understand the flow better.

Keep revisiting these notes to strengthen your understanding and tackle similar problems with ease!

 */