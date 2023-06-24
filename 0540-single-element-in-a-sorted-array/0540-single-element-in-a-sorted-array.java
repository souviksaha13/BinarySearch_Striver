/**
When we are in the left of the single element
    (a,a) -> (even index, odd index)
When we are in the right of the single element
    (b,b) -> (odd, index, even index)
we will use this concept to BinarySearch in nums
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        // Base Cases -> single element, leftmost, rightmost
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int lo = 1, hi = n-2;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            // mid is at left half
            if((mid%2 == 1 && nums[mid] == nums[mid-1]) ||
               (mid%2 == 0 && nums[mid] == nums[mid+1])) {
                lo = mid+1;
            }
            else hi = mid-1;
        }

        return -1;  // incase single element not present
    }
}