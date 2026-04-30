class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, adj, vis, comp);

                int k = comp.size();
                boolean isComplete = true;

                // Check degree condition
                for(int node : comp) {
                    if(adj.get(node).size() != k - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if(isComplete) count++;
            }
        }

        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, 
                     boolean[] vis, ArrayList<Integer> comp) {
        vis[node] = true;
        comp.add(node);

        for(int nei : adj.get(node)) {
            if(!vis[nei]) {
                dfs(nei, adj, vis, comp);
            }
        }
    }
}