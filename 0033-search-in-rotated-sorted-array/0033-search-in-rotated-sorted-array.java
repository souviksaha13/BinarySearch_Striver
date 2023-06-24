class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target) return mid;

            // left sorted
            if(nums[lo] <= nums[mid]) {
                // element present in the left side
                if(nums[lo] <= target && nums[mid] > target) hi = mid-1;
                // element not present in left side
                else lo = mid+1;
            }

            // right sorted
            else {
                // element present in the right side
                if(nums[mid] < target && target <= nums[hi]) lo = mid+1;
                // element not present in right side
                else hi = mid-1;
            }
        }

        return -1;
    }
}