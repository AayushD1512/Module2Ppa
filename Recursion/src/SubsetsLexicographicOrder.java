import java.util.ArrayList;
import java.util.*;

public class SubsetsLexicographicOrder {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        genSubInOrder(arr, 0, n, curr, subset);

        for (List<Integer> ch : subset) {
            System.out.println(ch);
        }
    }

    public static void genSubInOrder(int[] arr, int i, int n, List<Integer> curr, List<List<Integer>> subset) {
        subset.add(new ArrayList<>(curr));
        if (i == n) {
            return;
        }

        for (int j = i; j < n; j++) {
            curr.add(arr[j]);
            genSubInOrder(arr, j + 1, n, curr, subset);  // ✅ key fix here!
            curr.remove(curr.size() - 1);
        }
    }
}

/*


## ✅ **Short Note on `i` and `j` in Subset Generation (Lexicographic Order)**

1. **Role of `i`:**
   - The variable `i` represents the starting index for the current recursion level.
   - It’s passed in the recursive call as `genSubInOrder(arr, j+1, n, curr, subset)`.
   - At each recursive call, `i` is fixed — it just marks *from where* to start picking new elements in that stage.

2. **Role of `j`:**
   - Inside each recursive call, we use a `for` loop starting from `j = i` and going up to `n - 1`.
   - `j` moves forward and decides which element to pick at this level.
   - For every `j`, we:
     - Add `arr[j]` to `curr`.
     - Recurse from `j+1` (not `i+1`! The `i` argument in recursive call becomes `j+1`).
     - Backtrack by removing the last element.

3. **Difference between `i` and `j`:**
   - `i` is fixed at the start of that recursion frame — it’s like saying:
     *"I will try all elements starting from index `i`."*
   - `j` iterates from `i` forward — picking elements one by one.
   - After each pick (`curr.add(arr[j])`), the recursion goes deeper with `i = j + 1`.

4. **Why do `i` and `j` differ at different stages?**
   - Because at each recursive depth, you “commit” to an element at index `j`, and then search further from the next index (`j+1`).
   - Meanwhile, at the parent call, you’re still looping on `j`, picking other elements from that parent’s `i`.

5. **Example snapshot:**
   - At `i=0, j=0`: you pick `1`, recurse from `i=1`.
   - At `i=1, j=1`: you pick `2`, recurse from `i=2`.
   - At `i=2, j=2`: you pick `3`, recurse from `i=3`.
   - When recursion returns, you backtrack, and now at `i=1, j=2`, you pick `3` (a different path).

---

### ✅ In short:
- **`i`**: Start index of current decision stage.
- **`j`**: Element you’re currently choosing to branch on.
- Each recursive call: fix `i`, loop with `j`, pick, recurse with `i = j + 1`, backtrack.
- This systematic picking and branching ensures lexicographic subsets without sorting at the end.

---

If you’d like, I can help you write this in your own handwriting style / tone so you can easily revise from it. Want me to do that too? 😄

 */
