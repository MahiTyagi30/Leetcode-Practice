class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         List<List<Integer>> adj = new ArrayList<>();
         ArrayList<Integer> list = new ArrayList<>();
        int V=graph.length;
        int[] indeg=new int[V];
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        // graph creation
for(int i=0;i<V;i++){
     for(int j = 0; j < graph[i].length; j++){

            int u = graph[i][j];
            

            adj.get(u).add(i);
            indeg[i]++;
        }

}
       
         Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){

            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()){

            int a = q.peek();
            q.remove();

            list.add(a);
            count++;

            for(int it : adj.get(a)){

                indeg[it]--;

                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
         
Collections.sort(list);
return list;
    }
}