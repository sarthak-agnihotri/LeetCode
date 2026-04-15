class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwise = Math.abs(i - startIndex);
                int counterClockwise = n - clockwise;
                int dist = Math.min(clockwise, counterClockwise);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}