class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e16;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (canFinish(mid, mountainHeight, workerTimes))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {

        long removed = 0;

        for (int w : workerTimes) {

            long x = (long)((Math.sqrt(1 + (8.0 * time) / w) - 1) / 2);

            removed += x;

            if (removed >= mountainHeight)
                return true;
        }

        return false;
    }
}