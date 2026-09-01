class Solution {
    public boolean check(String s, int i, int j){
        if(i>j)return true;
        if(s.charAt(i)==s.charAt(j)) return(check(s,i+1,j-1));
        return false;
    }
    public int countSubstrings(String s) {
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(check(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
}