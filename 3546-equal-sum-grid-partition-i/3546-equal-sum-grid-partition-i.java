class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Compute total sum
        long totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }

        // If total is odd, cannot split equally
        if (totalSum % 2 != 0) return false;
        long half = totalSum / 2;

        // 2. Check horizontal cuts
        long prefix = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                prefix += grid[i][j];
            }
            if (prefix == half) {
                return true;
            }
        }

        // 3. Check vertical cuts
        prefix = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                prefix += grid[i][j];
            }
            if (prefix == half) {
                return true;
            }
        }

        // 4. No valid cut
        return false;
    }
}