class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] res = new char[n];
        
        // Step 1: Assign characters
        char ch = 'a';
        
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                if (ch > 'z') return ""; // more than 26 chars needed
                
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        res[j] = ch;
                    }
                }
                ch++;
            }
        }
        
        // Step 2: Validate LCP matrix
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int expected = 0;
                
                if (res[i] == res[j]) {
                    if (i + 1 < n && j + 1 < n) {
                        expected = 1 + lcp[i + 1][j + 1];
                    } else {
                        expected = 1;
                    }
                }
                
                if (lcp[i][j] != expected) {
                    return "";
                }
            }
        }
        
        return new String(res);
    }
}