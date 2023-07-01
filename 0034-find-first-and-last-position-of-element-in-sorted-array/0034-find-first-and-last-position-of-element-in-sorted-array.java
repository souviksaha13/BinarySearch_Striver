class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int start = lowerBound(nums, target);
        int end = upperBound(nums, target);
        if(start == end) return ans;

        ans[0] = start; ans[1] = end-1;
        return ans;
    }

    public int countOccurences(int[] nums, int target) {
        int start = lowerBound(nums, target);
        int end = upperBound(nums, target);

        return Math.abs(end - start);
        // here end -> first element > target;
        // start ->  first occurence of target
    }

    public int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < target) lo = mid+1;
            else hi = mid-1;
        }

        return lo;
    }

    public int upperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] <= target) lo = mid+1;
            else hi = mid-1;
        }

        return lo;
    }
}