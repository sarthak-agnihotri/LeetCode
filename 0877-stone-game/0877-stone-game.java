class Solution {
    int[][]dp;
    public int solve(int[]piles,int i,int j){
        if(i==j)return piles[i];
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int takeleft=piles[i]-solve(piles,i+1,j);
        int takeright=piles[j]-solve(piles,i,j-1);
        dp[i][j]=Math.max(takeleft,takeright);
        return dp[i][j];
    }

    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        dp=new int[n][n];
        for(int [] row:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        return solve(piles,0,n-1)>0;
    }
}