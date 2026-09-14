class Solution {
    public static boolean dfs(int i,int col,int[] colors,int[][] graph,int v){
        colors[i]=col;
        for(int neigh:graph[i]){
             if (colors[neigh] == -1) {
            if(dfs(neigh,1-col,colors,graph,v)==false){
                return false;
            }
             }
            else if(colors[neigh]==col){
                return false;
            }


        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
                int v=graph.length;
        // ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        // for(int i=0;i<v;i++){
        //     int 

        // }
        int [] colors=new int[v];
        for(int i=0;i<v;i++){
            colors[i]=-1;

        }
        for(int i=0;i<v;i++){
            if(colors[i]==-1){
                if(dfs(i,0,colors,graph,v)==false){
                    return false; 
                }
            }
        }
        return true;
    }
}