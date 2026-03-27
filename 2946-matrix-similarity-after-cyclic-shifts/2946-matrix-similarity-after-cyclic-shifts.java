class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        k = k % n; // normalize k
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int shiftedIndex;
                
                if (i % 2 == 0) {
                    // even row → left shift
                    shiftedIndex = (j + k) % n;
                } else {
                    // odd row → right shift
                    shiftedIndex = (j - k + n) % n;
                }
                
                if (mat[i][j] != mat[i][shiftedIndex]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}