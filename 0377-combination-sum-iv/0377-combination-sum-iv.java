class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target+1];
        for(int i=0; i<=target; i++) {
            dp[i] = -1;
        }

        return rec(nums, target, dp);
    }

    public int rec(int[] nums, int target, int[] dp) {
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(dp[target] != -1) return dp[target];
        int ans = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= target) ans += rec(nums, target-nums[i], dp);
        }
        dp[target] = ans;
        return ans;
    }
}