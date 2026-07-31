class Solution {

    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        // dp[i][1] -> next picked element '+' hoga
        // dp[i][0] -> next picked element '-' hoga
        long[][] dp = new long[n + 1][2];

        // Base Case:
        // Array ke end ke baad answer 0 hai.
        dp[n][0] = 0;
        dp[n][1] = 0;

        // Last index se first index tak fill karenge.
        for (int i = n - 1; i >= 0; i--) {

            // -------- Flag = 1 (Next sign '+') --------

            // Current element skip karo.
            long skipPlus = dp[i + 1][1];

            // Current element pick karo '+' sign ke saath.
            long takePlus = nums[i] + dp[i + 1][0];

            dp[i][1] = Math.max(skipPlus, takePlus);


            // -------- Flag = 0 (Next sign '-') --------

            // Current element skip karo.
            long skipMinus = dp[i + 1][0];

            // Current element pick karo '-' sign ke saath.
            long takeMinus = -nums[i] + dp[i + 1][1];

            dp[i][0] = Math.max(skipMinus, takeMinus);
        }

        // Initially first picked element '+' hota hai.
        return dp[0][1];
    }
}