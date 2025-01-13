class Solution {
    public static boolean dfs(int i, int[][] graph, int[] color, int c) {
        color[i] = c;
        
        for (int neigh : graph[i]) {
            if (color[neigh] == -1) {
                // Recursive call; propagate `false` if conflict detected
                if (!dfs(neigh, graph, color, 1 - c)) {
                    return false;
                }
            } else if (color[neigh] == c) {
                // Conflict detected
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1); // Initialize all nodes as uncolored
        
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                // Start DFS for every uncolored component
                if (!dfs(i, graph, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
