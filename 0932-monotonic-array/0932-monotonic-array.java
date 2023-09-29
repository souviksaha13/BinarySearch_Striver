class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = true;

        int i=1;
        while(i<nums.length && nums[i] == nums[i-1]) i++;
        if(i == nums.length) return true;
        if(nums[i] < nums[i-1]) inc = false;

        for(i=i; i<nums.length; i++) {
            if(inc && nums[i] < nums[i-1]) return false;
            else if(!inc && nums[i] > nums[i-1]) return false;
        }

        return true;
    }
}