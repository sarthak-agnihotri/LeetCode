class Solution {
    Long[][]dp;
    public long solve(int start,int[]nums,int flag){
        if(start==nums.length)return 0;
        if (dp[start][flag] != null) return dp[start][flag];
        long skip=solve(start+1,nums,flag);
        long val=nums[start];
        long take;
        if(flag==1){
            take=nums[start]+solve(start+1,nums,0);
        }
        else{
            take= -nums[start]+solve(start+1,nums,1);
        }
        return dp[start][flag]=Math.max(take,skip);
    }
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        dp=new Long[n][2];
        return solve(0,nums,1);
    }
}