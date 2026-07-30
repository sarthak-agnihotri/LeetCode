class Solution {
    public int solve(int[]nums,int start,int end){
        int prev1=0;
        int prev2=0;
        for(int i=start;i<=end;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int ans1=solve(nums,0,n-2);
        int ans2=solve(nums,1,n-1);
        return Math.max(ans1,ans2);
    }
}