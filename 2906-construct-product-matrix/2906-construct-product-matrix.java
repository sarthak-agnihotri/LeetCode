class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 12345;

        int size = m * n;
        int[] arr = new int[size];

        // Step 1: flatten grid
        int k = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr[k++] = val % mod;
            }
        }

        // Step 2: prefix
        int[] prefix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
        }

        // Step 3: suffix
        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % mod;
        }

        // Step 4: build answer
        int[][] result = new int[m][n];
        k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (prefix[k] * suffix[k]) % mod;
                k++;
            }
        }

        return result;
    }
}