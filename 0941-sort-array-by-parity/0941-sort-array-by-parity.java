class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ev = 0, odd = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2 == 0) {
                int temp = nums[odd];
                nums[odd++] = nums[ev];
                nums[ev++] = temp;
            }
            else odd++;
        }

        return nums;
    }
}