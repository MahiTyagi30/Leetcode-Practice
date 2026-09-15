class Solution {

    public boolean dfs(int node, int[] vis, int[] pathVis,
                       ArrayList<ArrayList<Integer>> adj,
                       Stack<Integer> st) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (Integer it : adj.get(node)) {

            if (vis[it] == 0) {

                if (dfs(it, vis, pathVis, adj, st)) {
                    return true;
                }

            } else if (pathVis[it] == 1) {

                // Cycle detected
                return true;
            }
        }

        pathVis[node] = 0;
        st.push(node);

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Create graph
        for (int[] p : prerequisites) {

            int u = p[1];  // prerequisite
            int v = p[0];  // course

            adj.get(u).add(v);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        Stack<Integer> st = new Stack<>();

        // DFS for every component
        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {

                if (dfs(i, vis, pathVis, adj, st)) {

                    // Cycle exists
                    return new int[0];
                }
            }
        }

        // Generate answer from stack
        int[] ans = new int[numCourses];
        int i = 0;

        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }
}