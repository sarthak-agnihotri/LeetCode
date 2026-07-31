class Solution {

    public int solve(int[] nums, int start, int prev, int[][] dp) {

        // Base Case:
        // Agar saare elements process ho gaye,
        // to aur koi element pick nahi kar sakte.
        if (start == nums.length)
            return 0;

        // Agar previous element exist karta hai aur
        // ye state pehle se calculate ho chuki hai,
        // to stored answer return kar do.
        if (prev != -1 && dp[start][prev] != -1)
            return dp[start][prev];

        // Choice 1: Current element ko pick karo.
        int take = 0;

        // Current element tabhi pick kar sakte hain
        // jab ya to abhi tak kuch pick nahi kiya (prev == -1)
        // ya current element previous picked element se bada ho.
        if (prev == -1 || nums[start] > nums[prev]) {
            take = 1 + solve(nums, start + 1, start, dp);
        }

        // Choice 2: Current element ko skip karo.
        int skip = solve(nums, start + 1, prev, dp);

        // Sirf prev != -1 wali states memoize ho rahi hain.
        // (Standard solution me prev+1 mapping use karke
        // har state ko memoize kiya jata hai.)
        if (prev != -1) {
            dp[start][prev] = Math.max(take, skip);
        }

        // Pick aur Skip me se maximum answer return karo.
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[start][prev]
        // start -> current index
        // prev -> last picked element ka index
        int[][] dp = new int[n + 1][n + 1];

        // DP table ko -1 se initialize kar rahe hain,
        // taki pata chal sake ki state pehle compute hui hai ya nahi.
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Initially koi bhi element pick nahi hua,
        // isliye prev = -1.
        return solve(nums, 0, -1, dp);
    }
}