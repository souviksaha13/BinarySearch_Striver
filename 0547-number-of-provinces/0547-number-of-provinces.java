class Solution {
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        int ans = 0;
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(vis[i]) continue;
            ans++;
            q.add(i);
            vis[i] = true;
            while(!q.isEmpty()) {
                Integer n = q.poll();
                // vis[n] = true;
                
                for(int j=0; j<V; j++) {
                    if(adj[n][j]==1 && !vis[j]) {
                        q.add(j);
                        vis[j] = true;
                    }
                }
            }
        }
        
        return ans;
    }
}