class Solution {

    // dp[index][flag]
    // index -> current position
    // flag = 1 -> next picked element '+' banega
    // flag = 0 -> next picked element '-' banega
    Long[][] dp;

    public long solve(int start, int[] nums, int flag) {

        // Base Case:
        // Agar array ke end tak pahunch gaye,
        // to aur koi element pick nahi kar sakte.
        if (start == nums.length)
            return 0;

        // Agar ye state pehle se calculate ho chuki hai,
        // to directly stored answer return kar do.
        if (dp[start][flag] != null)
            return dp[start][flag];

        // Choice 1:
        // Current element ko skip kar do.
        // Flag same rahega kyunki kuch pick hi nahi kiya.
        long skip = solve(start + 1, nums, flag);

        // Choice 2:
        // Current element ko pick karo.
        long take;

        if (flag == 1) {

            // Current element '+' sign ke saath add hoga.
            // Next picked element '-' sign ke saath hoga.
            take = nums[start] + solve(start + 1, nums, 0);

        } else {

            // Current element '-' sign ke saath subtract hoga.
            // Next picked element '+' sign ke saath hoga.
            take = -nums[start] + solve(start + 1, nums, 1);
        }

        // Dono choices me jo maximum answer de,
        // usse memo table me store kar do.
        return dp[start][flag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {

        // Total states = n * 2
        // n indices aur 2 possible flags.
        dp = new Long[nums.length][2];

        // Initially next picked element '+' hoga,
        // isliye flag = 1 se start karte hain.
        return solve(0, nums, 1);
    }
}