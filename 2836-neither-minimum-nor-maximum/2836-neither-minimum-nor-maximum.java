class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length <= 2) return -1;
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;

        for(int el : nums) {
            lo = Math.min(lo, el);
            hi = Math.max(hi, el);
        }

        for(int el : nums) {
            if(el != lo && el != hi) return el;
        }

        return -1;
    }
}