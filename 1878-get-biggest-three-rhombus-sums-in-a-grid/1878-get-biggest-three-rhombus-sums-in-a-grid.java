import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // single cell rhombus
                set.add(grid[r][c]);

                for (int k = 1; r + 2*k < m && c - k >= 0 && c + k < n; k++) {

                    int sum = 0;

                    int x = r, y = c;

                    // top -> right
                    for (int i = 0; i < k; i++)
                        sum += grid[x+i][y+i];

                    // right -> bottom
                    for (int i = 0; i < k; i++)
                        sum += grid[x+k+i][y+k-i];

                    // bottom -> left
                    for (int i = 0; i < k; i++)
                        sum += grid[x+2*k-i][y-i];

                    // left -> top
                    for (int i = 0; i < k; i++)
                        sum += grid[x+k-i][y-k+i];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for (int val : set) {
            if (i == size) break;
            ans[i++] = val;
        }

        return ans;
    }
}