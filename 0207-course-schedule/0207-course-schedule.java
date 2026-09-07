class Solution {
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] par){
        vis[node]=1;
        par[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(dfs(i,adj,vis,par)==true){
                    return true;
                }
                
            }
            else if(par[i]==1){
                    return true;
                }
        }
        par[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=numCourses;

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:pre){
            int u=p[0];
            int b=p[1];
            adj.get(b).add(u);
        }
     int vis[]=new int[v];
     int par[]=new int[v];
     for(int i=0;i<v;i++){
        if(vis[i]==0){
            if(dfs(i,adj,vis,par)==true){
                return false;
            }
        }
       
     }
      return true;

    }
}