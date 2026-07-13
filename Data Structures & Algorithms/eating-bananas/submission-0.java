class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int high = -1;
        for(int i = 0; i < len; i++) {
            high = Math.max(high, piles[i]);
        }
        int low = 1;
        int k = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (high + low) / 2;
            double totalTime = calTime(mid, piles);
            if(totalTime <= h) {
                k = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return k;
    }

    public double calTime(int rate, int[] piles) {
        double totalTime = 0;
        for(int i = 0; i < piles.length; i++) {
            totalTime += Math.ceil((double)piles[i] / (double)rate);
        }
        return totalTime;
    }
}
