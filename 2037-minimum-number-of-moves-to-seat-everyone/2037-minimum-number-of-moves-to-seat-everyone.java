class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] seatFreq=new int[101];
        int[] studentFreq=new int[101];

        for(int seat: seats){
            seatFreq[seat]++;
        }

        for(int student: students){
            studentFreq[student]++;
        }

        int moves=0;
        int j=1;
        for(int i=1;i<=100;i++){
            while(seatFreq[i]>0){
                while(studentFreq[j]==0){
                    j++;
                }
                moves+=Math.abs(j-i);
                seatFreq[i]--;
                studentFreq[j]--;
            }
        }
        return moves;
    }
}