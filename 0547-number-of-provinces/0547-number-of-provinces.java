class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = adjListConvertion(isConnected);
        int vertex = adj.size();
        boolean vis[] =  new boolean[vertex];
        int ans = 0;

       for(int i=0;i<vertex;i++){
        if(!vis[i]){
            ans++;
            dfsHelper(adj,i,vis);
        }
       }
       return ans;      
        
    }

    public  void  dfsHelper(List<List<Integer>> adjList,int node,boolean[] vis) {
        vis[node]=true;

        for(Integer it:adjList.get(node)){
            if(!vis[it])
                dfsHelper(adjList, it, vis);
        }

    }

    public List<List<Integer>> adjListConvertion(int [][]isConnected){
        
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }

            }
        }
        return adj;

    }
}