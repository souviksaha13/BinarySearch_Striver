class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++) {
            ans.add(comb(rowIndex, i));
        }
        return ans;
    }

    public int comb(int n, int r) {
        // long is used to avoid int overflow
        long ans = 1;
        int k = 1;

        // n!/r!*(n-r)!  == nCr
        for(int i=r+1; i<=n; i++) {
            ans *= i;
            ans /= k++;
        }

        return (int)ans;
    }
}