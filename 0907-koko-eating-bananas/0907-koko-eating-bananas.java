class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = maxElement(piles);

        while(lo <= hi) {
            int mid = (hi-lo)/2 + lo;
            if(checkTime(piles, h, mid)) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }

    public boolean checkTime(int[] piles, int h, int k) {
        int time = 0;
        for(int i=0; i<piles.length; i++) {
            time += piles[i]/k;
            if(piles[i]%k != 0) time++;
            if(time > h) return false;
            // if we calculate whole reqd time, it may overflow for small k
            // eg -> [805306368,805306368,805306368], h = 1000000000
        }
        return true;
    }
    // calculate the maximum no. of bananas in a pile
    public int maxElement(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++) maxi = Math.max(maxi, piles[i]);
        return maxi;
    }
}