class Solution {
    public int solve(int[] dp,int n){
        if(n<=1)return n;
        if(dp[n]!=-1)return dp[n];
        dp[n]=fib(n-1)+fib(n-2);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(dp,n);
    }
}