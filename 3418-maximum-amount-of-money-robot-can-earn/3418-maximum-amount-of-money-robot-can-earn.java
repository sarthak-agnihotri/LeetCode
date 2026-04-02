class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        // dp[i][j][k]: max coins at (i,j) with k skips used
        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Starting cell
        if (coins[0][0] >= 0) {
            dp[0][0][0] = coins[0][0];
        } else {
            dp[0][0][0] = coins[0][0]; // take it
            dp[0][0][1] = 0;           // skip it
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // Move right
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];

                        // Take value
                        dp[i][j + 1][k] = Math.max(
                            dp[i][j + 1][k],
                            dp[i][j][k] + val
                        );

                        // Skip if negative
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(
                                dp[i][j + 1][k + 1],
                                dp[i][j][k]
                            );
                        }
                    }

                    // Move down
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];

                        // Take value
                        dp[i + 1][j][k] = Math.max(
                            dp[i + 1][j][k],
                            dp[i][j][k] + val
                        );

                        // Skip if negative
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(
                                dp[i + 1][j][k + 1],
                                dp[i][j][k]
                            );
                        }
                    }
                }
            }
        }

        // Result = max of all skip states at bottom-right
        int res = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            res = Math.max(res, dp[m - 1][n - 1][k]);
        }

        return res;
    }
}