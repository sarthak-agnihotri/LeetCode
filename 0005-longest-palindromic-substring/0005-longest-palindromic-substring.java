class Solution {
    String s;
    Boolean[][] memo;

    public String longestPalindrome(String s) {
        this.s = s;
        int n = s.length();
        memo = new Boolean[n][n];

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j) && (j - i + 1) > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(int i, int j) {
        // Base cases
        if (i >= j) {
            return true;
        }

        // Already calculated
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Check first and last characters
        if (s.charAt(i) != s.charAt(j)) {
            return memo[i][j] = false;
        }

        // Check the inside substring
        return memo[i][j] = isPalindrome(i + 1, j - 1);
    }
}
