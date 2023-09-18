class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] pair = new int[n][2];
        int[] ans = new int[k];

        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 1) cnt++;
                else break;
            }
            pair[i][0] = cnt;
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a,b) -> a[0]-b[0]);

        for(int i=0; i<k; i++) {
            ans[i] = pair[i][1];
        }

        return ans;
    }
}