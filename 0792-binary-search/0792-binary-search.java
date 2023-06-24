class Solution {
    // // Iterative Solution
    // public int search(int[] nums, int target) {
    //     int lo = 0, hi = nums.length-1;
    //     while(lo <= hi){
    //         int mid = (lo+hi)/2;
    //         if(nums[mid] == target) return mid;
    //         else if(nums[mid] < target) lo = mid+1;
    //         else hi=mid-1;
    //     }
    //     return -1;   // target is not in nums
    // }

    // Recursive Solution
    public int search(int[] nums, int target) {
        return rec(nums, 0, nums.length-1, target);
    }
    public int rec(int[] nums, int lo, int hi, int target) {
        if(lo > hi) return -1;
        int mid = (lo+hi)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return rec(nums, mid+1, hi, target);
        return rec(nums, lo, mid-1, target);
    }
}