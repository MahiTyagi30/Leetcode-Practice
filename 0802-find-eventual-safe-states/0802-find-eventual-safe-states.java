class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=graph.length;
        for(int i = 0; i < n; i++){
    adj.add(new ArrayList<>());
}
 int indeg[]=new int[n];
        for(int i=0;i<n;i++){
            int m=graph[i].length;
            for(int j=0;j<m;j++){
                int a=graph[i][j];
                adj.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);

            }
        }
         ArrayList<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            list.add(node);
            for(Integer it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }

        }
        Collections.sort(list);
        return list;
       
       
    }
}