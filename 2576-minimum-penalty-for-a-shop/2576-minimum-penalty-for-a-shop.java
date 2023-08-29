class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int pen = 0, prof = 0, ans = n;

        for(int i=n-1; i>=0; i--) {
            if(customers.charAt(i) == 'N') {
                prof--;
                if(prof <= 0) {
                    ans = i;
                    prof = 0;
                }
            }
            else prof++;
        }
        return ans;
    }
}