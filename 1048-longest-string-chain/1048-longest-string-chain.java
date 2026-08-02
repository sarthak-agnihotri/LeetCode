class Solution {
    int n;
    int[][] dp;

    // Check karta hai ki 'prev' word, 'curr' ka valid predecessor hai ya nahi
    public boolean predecessor(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        // Length exactly 1 se chhoti honi chahiye
        if (M >= N || N - M != 1) return false;

        int i = 0, j = 0;

        // Two pointers se characters match karte hain
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            // curr me ek extra character skip ho sakta hai
            j++;
        }

        // Agar prev ke saare characters match ho gaye to valid predecessor hai
        return i == M;
    }

    // curr = current index
    // prev = last selected word ka index (-1 matlab abhi tak koi word select nahi hua)
    public int LIS(String[] words, int curr, int prev) {

        // Saare words process ho gaye
        if (curr == n) return 0;

        // Agar state pehle calculate ho chuki hai to directly return karo
        if (dp[curr][prev + 1] != -1)
            return dp[curr][prev + 1];

        int take = 0;

        // Agar first word hai ya current word predecessor condition satisfy karta hai
        if (prev == -1 || predecessor(words[prev], words[curr])) {
            // Current word ko chain me include karo
            take = 1 + LIS(words, curr + 1, curr);
        }

        // Current word ko skip karo
        int skip = LIS(words, curr + 1, prev);

        // Dono options me se maximum store karo
        return dp[curr][prev + 1] = Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {

        n = words.length;

        // Memoization table
        // prev = -1 ko handle karne ke liye prev + 1 use kar rahe hain
        dp = new int[n + 1][n + 1];

        // DP array ko -1 se initialize karo
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Pehle length ke according sort karenge
        // Taaki chhote words hamesha bade words se pehle aaye
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        // Recursion start karo
        return LIS(words, 0, -1);
    }
}