class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int el : nums) sum += el;
        if(sum%2 != 0) return false;

        // // recursive solution
        // return rec(nums, sum/2, 0);

        // // memoization solution
        // int[][] dp = new int[n+1][sum/2+1];
        // for(int i=0; i<dp.length; i++) {
        //     for(int j=0; j<dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // int ans = memo(nums, sum/2, 0, dp);
        // if(ans == 1) return true;
        // return false;

        // // tabulation solution
        // return tabu(n, sum/2, nums);

        // space optimization
        return spaceOpt(n, sum/2, nums);
    }

    // // recursive solution
    // public boolean rec(int[] nums, int target, int idx) {
    //     if(target == 0) return true;
    //     if(idx == nums.length) return false;  
    //     // means sum not achieved but array is exhausted

    //     boolean take = rec(nums, target-nums[idx], idx+1);
    //     if(take) return true;
    //     boolean ntake = rec(nums, target, idx+1);
    //     return ntake;
    // }


    // memoization solution
    public int memo(int[] nums, int target, int idx, int[][] dp) {
        // -1 unvisited, 0 false, 1 true
        // dp[idx][target]
        if(target==0) return 1;  
        if(idx == nums.length) return 0;
        if(dp[idx][target] != -1) return dp[idx][target];

        // if target<nums[idx], then  "dp[idx+1][target-nums[idx]]"  will go outOfBounds
        int take = -1;
        if(target >= nums[idx])
            take = dp[idx+1][target-nums[idx]] = memo(nums, target-nums[idx], idx+1, dp);
        int ntake = dp[idx+1][target] = memo(nums, target, idx+1, dp);

        return Math.max(take, ntake);
    }


    // public static boolean tabu(int n, int k, int nums[]) {
    //     // it is true when target is achieved at a particular index
    //     boolean[][] dp = new boolean[n][k+1];
    //     for(int i=0; i<dp.length; i++) dp[i][0] = true;  // at any idx, when target == 0, it is true
    //     if(nums[0] <= k) dp[0][nums[0]] = true;  // at idx == 0, only target with nums[0] can be true
    //     for(int idx=1; idx<dp.length; idx++) {
    //         for(int target=1; target<dp[0].length; target++) {
    //             boolean ntake = dp[idx-1][target];
    //             boolean take = false;
    //             if(target >= nums[idx]) take = dp[idx-1][target-nums[idx]];
    //             dp[idx][target] = (take || ntake);
    //         }
    //     }
    //     return dp[n-1][k];
    // }


    // space optimization
    public static boolean spaceOpt(int n, int k, int nums[]) {
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        if(nums[0] <= k) dp[nums[0]] = true;

        for(int idx=1; idx<n; idx++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target=1; target<=k; target++) {
                boolean ntake = dp[target];
                boolean take = false;
                if(target >= nums[idx]) take = dp[target-nums[idx]];
                curr[target] = (take || ntake);
            }
            dp = curr;
        }
        return dp[k];
    }
}