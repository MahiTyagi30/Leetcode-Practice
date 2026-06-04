import java.util.*;

class Solution {

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {

        // Step 1: not enough edges
        if (connections.length < n - 1) return -1;

        DSU dsu = new DSU(n);

        // Step 2: union all edges
        int extra=0;
        for (int[] edge : connections) {
            int u=edge[0];
            int v=edge[1];
            if(dsu.find(u)==dsu.find(v)){
                extra++;
            }
            else{
                    dsu.union(edge[0], edge[1]);
            }
           
        }

        // Step 3: count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        // Step 4: answer = components - 1
        return components - 1;
    }
}