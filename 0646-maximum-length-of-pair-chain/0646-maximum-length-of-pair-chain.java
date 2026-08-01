class Solution {

    // curr = current index
    // prev = last selected pair ka index (-1 matlab abhi tak koi pair select nahi hua)
    public int solve(int curr, int prev, int[][] pairs, int[][] dp) {

        // Base case: saare pairs dekh liye
        if (curr == pairs.length)
            return 0;

        // Agar answer pehle se calculate hai to direct return karo
        if (dp[curr][prev + 1] != -1)
            return dp[curr][prev + 1];

        // Option 1: Current pair ko skip karo
        int skip = solve(curr + 1, prev, pairs, dp);

        // Option 2: Current pair ko lo (agar valid hai)
        int take = 0;

        // Agar koi previous pair nahi hai
        // ya current pair ka start, previous pair ke end se bada hai
        // to chain continue ho sakti hai
        if (prev == -1 || pairs[curr][0] > pairs[prev][1]) {

            // 1 current pair ke liye
            // + baaki answer recursion se
            take = 1 + solve(curr + 1, curr, pairs, dp);
        }

        // Take aur Skip me se maximum answer store karo
        return dp[curr][prev + 1] = Math.max(take, skip);
    }

    public int findLongestChain(int[][] pairs) {

        // First element ke basis par sorting
        // Taaki recursion left se right easily chale
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int n = pairs.length;

        // dp[curr][prev+1]
        // prev+1 isliye kyunki prev = -1 bhi ho sakta hai
        int[][] dp = new int[n][n + 1];

        // DP ko -1 se initialize karo (matlab abhi answer calculate nahi hua)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion
        // curr = 0
        // prev = -1 (abhi tak koi pair choose nahi kiya)
        return solve(0, -1, pairs, dp);
    }
}