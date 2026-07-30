class Solution {

    // Recursive + Memoization function
    public int solve(int[] nums, int i, int end, int[] dp) {

        // Agar index end se aage chala gaya to lootne ke liye koi house nahi bacha
        if (i > end) return 0;

        // Agar is index ka answer pehle se calculate hai to wahi return kar do
        if (dp[i] != -1) return dp[i];

        // Current house loot karo aur next adjacent house skip karke aage badho
        int steal = nums[i] + solve(nums, i + 2, end, dp);

        // Current house ko skip karo aur next house se start karo
        int skip = solve(nums, i + 1, end, dp);

        // Dono options me se maximum profit store karke return karo
        return dp[i] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {

        // Total houses ki count
        int n = nums.length;

        // Agar sirf ek hi house hai to usi ko loot lo
        if (n == 1) return nums[0];

        // Pehle case ke liye DP array (last house exclude hoga)
        int[] dp1 = new int[n];

        // Dusre case ke liye DP array (first house exclude hoga)
        int[] dp2 = new int[n];

        // DP arrays ko -1 se initialize karo (matlab abhi answer calculate nahi hua)
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Case 1: Last house ko exclude karke answer nikalo
        int ans1 = solve(nums, 0, n - 2, dp1);

        // Case 2: First house ko exclude karke answer nikalo
        int ans2 = solve(nums, 1, n - 1, dp2);

        // Dono cases me jo maximum profit hai wahi final answer hoga
        return Math.max(ans1, ans2);
    }
}