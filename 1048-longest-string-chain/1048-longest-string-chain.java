class Solution {
    public boolean predecessor(String prev,String curr){
        int M=prev.length();
        int N=curr.length();
        if(M>=N || N-M!=1) return false;
        int i=0,j=0;
        while(i<M && j<N){
            if(prev.charAt(i)==curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i==M;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(predecessor(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}