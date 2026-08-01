class Solution {
    public int solve(int curr,int prev,int[][]pairs,int[][]dp){
        if(curr==pairs.length)return 0;
        if(dp[curr][prev+1]!=-1)return dp[curr][prev+1];
        int skip=solve(curr+1,prev,pairs,dp);
        int take=0;
        if(prev==-1||pairs[curr][0]>pairs[prev][1]){
            take=1+solve(curr+1,curr,pairs,dp);
        }
        return dp[curr][prev+1]=Math.max(take,skip);
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int n=pairs.length;
        int[][]dp=new int[n][n+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,-1,pairs,dp);
    }
}