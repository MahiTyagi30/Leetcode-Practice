import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third) {
        this.first = first;   // stops
        this.second = second; // node
        this.third = third;   // cost
    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int K) {

        // Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < flights.length; i++) {

            adj.get(flights[i][0]).add(
                    new Pair(flights[i][1], flights[i][2])
            );
        }

        // Queue -> (stops, node, cost)
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src, 0));

        // Distance array
        int[] dist = new int[n];

        Arrays.fill(dist, (int)(1e9));

        dist[src] = 0;

        while (!q.isEmpty()) {

            Tuple it = q.peek();
            q.remove();

            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // If stops exceed K
            if (stops > K)
                continue;

            // Traverse adjacent nodes
            for (Pair iter : adj.get(node)) {

                int adjNode = iter.first;
                int edW = iter.second;

                // Relaxation
                if (cost + edW < dist[adjNode]
                        && stops <= K) {

                    dist[adjNode] = cost + edW;

                    q.add(new Tuple(
                            stops + 1,
                            adjNode,
                            cost + edW
                    ));
                }
            }
        }

        // Destination unreachable
        if (dist[dst] == (int)(1e9))
            return -1;

        return dist[dst];
    }
}