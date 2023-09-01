class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        
        for(int i=1; i<=n; i++) {
            dp[i] = dp[i/2];
            if(i%2 == 1) dp[i]++;
        }

        return dp;
    }
}


// intuition is -> for any number i, if we remove the last bit, it is same as the number i/2
//                 so we can take the number of 1's from i/2 (except for the last bit)
//                 now, for the last bit, if the number i is divisible by 2 -> then the last bit is 0, otherwise the last bit is 1