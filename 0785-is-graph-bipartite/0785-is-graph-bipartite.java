class Solution {
    public static boolean dfs( int n,int v, int [][] graph, int[] color,int c) {
        
        color[n] = c;
        
       
            for (int neigh : graph[n]) {
                if (color[neigh] == -1) {
                    if(!dfs(neigh, v, graph, color,1-c)){
                        return false;
                    }
                } 
                else if (color[neigh] == c) {
                    return false;
                }
            }
        // }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!dfs(i, v, graph, color,0)) {
                    return false;
                }
            }
        }
        return true;
    }
}