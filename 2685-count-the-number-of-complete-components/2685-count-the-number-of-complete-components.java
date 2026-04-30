class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Build graph
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

       boolean vis[]=new boolean[n];
       int c=0;
       for(int i=0;i<n;i++){
        if(!vis[i]){

                ArrayList<Integer> comp = new ArrayList<>();
            dfs(comp,adj,i,vis);
            int k=comp.size();
             boolean flag = true;
            for(int j=0;j<k;j++){
                int nd=comp.get(j);
                if(adj.get(nd).size()!=k-1){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                c++;
            }
        }
       }
       return c;

    }
    public static void dfs(ArrayList<Integer> comp,List<List<Integer>> adj,int node,boolean [] vis){
        vis[node]=true;
        comp.add(node);
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(!vis[neigh]){
                dfs(comp,adj,neigh,vis);
            }
        }
    }

    
}