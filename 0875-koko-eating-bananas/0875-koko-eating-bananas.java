class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Integer.MIN_VALUE, n = piles.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            end = Math.max(end, piles[i]);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int totalTime = 0;

            for (int i = 0; i < n; i++) {
                totalTime += Math.ceil((double) piles[i] / (double) mid);
            }

            if (totalTime > h) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
