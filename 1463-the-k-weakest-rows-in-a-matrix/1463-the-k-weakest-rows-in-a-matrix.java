class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[k];
        int cnt = 0;
        Set<Integer> hs = new HashSet<>();
        loop:
        for(int j=0; j<=m; j++) {
            for(int i=0; i<n; i++) {
                if(j == m || mat[i][j] == 0) {
                    if(!hs.contains(i)) {
                        ans[cnt++] = i;
                        System.out.println(i + " " + j);
                        hs.add(i);
                    }
                    if(cnt == k) break loop;
                }
            }
        }
        return ans;
    }
}