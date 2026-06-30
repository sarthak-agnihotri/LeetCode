class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int a:asteroids){
            while(!st.isEmpty()&& st.peek()>0 && a<0){
                if(st.peek()<-a)st.pop();
                else if(st.peek()==-a){
                    st.pop();
                    a=0;
                    break;
                }
                else {
                    a=0;
                    break;
                }
            }
            if(a!=0)st.push(a);
        }
        int[]ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}