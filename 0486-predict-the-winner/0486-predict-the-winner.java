class Solution {
    public int solve(int[]nums,int start,int end,Integer[][]dp){
        if(start==end)return nums[start];
        if(dp[start][end]!=null)return dp[start][end];
        int leftpick=nums[start]-solve(nums,start+1,end,dp);
        int rightpick=nums[end]-solve(nums,start,end-1,dp);
        return dp[start][end]=Math.max(leftpick,rightpick);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        Integer[][]dp=new Integer[n][n];
        int diff=solve(nums,0,n-1,dp);
        if(diff>=0)return true;
        else return false;
    }
}