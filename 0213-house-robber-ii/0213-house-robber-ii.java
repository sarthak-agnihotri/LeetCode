class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Agar sirf ek house hai
        if (n == 1)return nums[0];

        int[] dp = new int[n + 1];

        int result1 = 0;
        int result2 = 0;

        // Case 1: First house include ho sakta hai, isliye last house exclude
        dp[0] = 0;

        for (int i = 1; i <= n - 1; i++) {
            int skip=dp[i-1];
            int steal=nums[i-1]+(i - 2 >= 0 ? dp[i - 2] : 0);
            dp[i] = Math.max(skip,steal);
        }

        result1 = dp[n - 1];

        // DP array ko reset karo
        dp = new int[n + 1];

        // Case 2: First house exclude, isliye last house include ho sakta hai
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int skip=dp[i-1];
            int steal=nums[i-1]+(i - 2 >= 0 ? dp[i - 2] : 0);
            dp[i] = Math.max(skip,steal);
        }

        result2 = dp[n];

        // Dono cases me se maximum answer return karo
        return Math.max(result1, result2);
    }
}