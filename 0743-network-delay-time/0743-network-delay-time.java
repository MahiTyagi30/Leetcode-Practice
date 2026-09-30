class Solution {

    class Pair {
        int node;
        int distance;

        public Pair(int n, int d) {
            this.node = n;
            this.distance = d;
        }
    }

    public int networkDelayTime(int[][] times, int n, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Nodes are 1 to n
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            adj.get(u).add(new Pair(v, w));
        }

        // Min heap based on distance
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[src] = 0;

        // Pair(node, distance)
        pq.add(new Pair(src, 0));

        // Dijkstra
        while (!pq.isEmpty()) {

            int d = pq.peek().distance;
            int nd = pq.peek().node;

            pq.remove();

            if (d > dist[nd]) {
                continue;
            }

            for (int i = 0; i < adj.get(nd).size(); i++) {

                int wt = adj.get(nd).get(i).distance;
                int node = adj.get(nd).get(i).node;

                if (d + wt < dist[node]) {

                    dist[node] = d + wt;

                    pq.add(new Pair(node, dist[node]));
                }
            }
        }

        // Find maximum shortest distance
        int mx = 0;

        for (int i = 1; i <= n; i++) {

            // Node is unreachable
            if (dist[i] == (int) 1e9) {
                return -1;
            }

            mx = Math.max(mx, dist[i]);
        }

        return mx;
    }
}