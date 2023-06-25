class Solution {
    public int findPeakElement(int[] nums) {
        // array has only one element -> that is the peak
        if(nums.length == 1) return 0;

        int n = nums.length;

        // check for corner cases
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int lo = 1, hi = n-2;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            // check if mid is peak
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            // check if mid is in increasing slope
            if(nums[mid] < nums[mid+1]) lo = mid+1;
            // check if mid is in decreasing slope
            if(nums[mid] > nums[mid+1]) hi = mid-1;
            // not checking for nums[i] == nums[i-1] or nums[i+1] bcz 
            //  constraint -> nums[i] != nums[i + 1] for all valid i
        }

        return -1; // for the completion of function
    }
}