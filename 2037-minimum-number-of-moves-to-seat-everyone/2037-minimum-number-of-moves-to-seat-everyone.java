class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int minmoves=0;
        int n=seats.length;
        for(int i=0;i<n;i++){
            minmoves+=Math.abs(seats[i]-students[i]);
        }
        return minmoves;
    }
}