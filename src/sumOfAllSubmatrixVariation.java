import java.util.Scanner;

public class sumOfAllSubmatrixVariation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions of the matrix
        int m = sc.nextInt();
        int n = sc.nextInt();

        // Input the matrix
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Input the coordinates of the region
        int i1 = sc.nextInt();
        int j1 = sc.nextInt();
        int i2 = sc.nextInt();
        int j2 = sc.nextInt();

        // Calculate the sum of all sub-matrices within the region
        int sum = 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                // Contribution of arr[i][j] to the sum
                sum += arr[i][j] * (i - i1 + 1) * (j - j1 + 1) * (i2 - i + 1) * (j2 - j + 1);
            }
        }

        // Output the result
        System.out.println(sum);
    }
}

/*

   If the problem is modified to calculate the sum of all submatrices that lie within a specific region defined by two coordinates `(i1, j1)` and `(i2, j2)` in a larger 2D matrix, we need to adjust the approach. The key idea is to restrict the calculation to the submatrix defined by the given coordinates.

### Problem Breakdown:
1. **Input:**
   - A larger 2D matrix of size `m x n`.
   - Two coordinates `(i1, j1)` and `(i2, j2)` defining the top-left and bottom-right corners of the submatrix region.

2. **Objective:**
   - Calculate the sum of all submatrices that lie entirely within the region defined by `(i1, j1)` and `(i2, j2)`.

3. **Approach:**
   - The formula for the contribution of each element `arr[i][j]` to the sum of all submatrices remains the same:
     [{arr[i][j]} * (i - i1 + 1)* (j - j1 + 1) * (i2 - i + 1) * (j2 - j + 1)]
   - Here:
     - `(i - i1 + 1)` is the number of submatrices starting at or above row `i` within the region.
     - `(j - j1 + 1)` is the number of submatrices starting at or to the left of column `j` within the region.
     - `(i2 - i + 1)` is the number of submatrices ending at or below row `i` within the region.
     - `(j2 - j + 1)` is the number of submatrices ending at or to the right of column `j` within the region.

4. **Modification to the Code:**
   - Iterate only over the region defined by `(i1, j1)` and `(i2, j2)`.
   - Apply the formula to calculate the contribution of each element in this region.

### Explanation of the Modified Code:
1. **Input:**
   - The matrix dimensions `m` and `n`.
   - The matrix elements.
   - The coordinates `(i1, j1)` and `(i2, j2)` defining the region.

2. **Sum Calculation:**
   - The nested loops iterate only over the region `[i1, i2]` and `[j1, j2]`.
   - For each element in this region, the contribution to the sum is calculated using the formula:
     [{arr[i][j]} * (i - i1 + 1)* (j - j1 + 1) * (i2 - i + 1) * (j2 - j + 1)]

3. **Output:**
   - The total sum of all submatrices within the region is printed.

### Time Complexity:
- The time complexity is (O((i2 - i1 + 1) * (j2 - j1 + 1))), which is proportional to the size of the region.

### Space Complexity:
- The space complexity is (O(m* n)) due to the storage of the 2D array.

This approach efficiently solves the problem for any given region within the matrix.

 */