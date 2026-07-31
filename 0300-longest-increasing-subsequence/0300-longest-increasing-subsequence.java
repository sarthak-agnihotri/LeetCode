class Solution {
    public int solve(int[] nums,int start,int prev,int[][]dp){
        if(start==nums.length)return 0;
        if(prev!=-1 && dp[start][prev]!=-1)return dp[start][prev];
        int take=0;
        if(prev==-1||nums[start]>nums[prev]){
            take=1+solve(nums,start+1,start,dp);
        }
        int skip=solve(nums,start+1,prev,dp);
        if(prev!=-1){
            dp[start][prev]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+1][n+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1,dp);
    }
}