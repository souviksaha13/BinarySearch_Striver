class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n-1];
        int cnt = 3;
        n -= 2;

        while(n>=0) {
            if(nums[n] != nums[n+1]) cnt--;
            if(cnt == 1) break;
            n--;
        }
        if(n<0) return ans;
        return nums[n];
    }
}