class Solution {
    public boolean checkStrings(String s1, String s2) {
        // Count arrays for even and odd positions:
        // count[0] for even index positions
        // count[1] for odd index positions
        int[][] count = new int[2][26];

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            // Determine parity: 0 for even, 1 for odd
            int parity = i % 2;

            // Increase count for s1's character
            count[parity][s1.charAt(i) - 'a']++;

            // Decrease count for s2's character
            count[parity][s2.charAt(i) - 'a']--;
        }

        // After counting, if any non-zero remains
        // in even or odd group then they differ.
        for (int i = 0; i < 26; i++) {
            if (count[0][i] != 0 || count[1][i] != 0) {
                return false;
            }
        }

        return true;
    }
}