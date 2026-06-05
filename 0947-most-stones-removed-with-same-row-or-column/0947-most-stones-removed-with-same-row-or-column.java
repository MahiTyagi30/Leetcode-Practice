class Solution {
    static class DSU{
        int[] parent;
        int rank[];
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int node){
            if(parent[node]!=node){
                parent[node]=find(parent[node]);
            }
            return parent[node];
        }
       void union(int x,int y){
            int px=find(x);
            int py=find(y);
            if(px==py){
                return ;
            }
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
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        for(int [] stone:stones){
            maxRow=Math.max(maxRow,stone[0]);
            maxCol=Math.max(maxCol,stone[1]);
        }
        DSU obj=new DSU(maxRow+maxCol+2);
        HashMap<Integer,Integer> map=new HashMap<>();
          for(int [] stone:stones){

            int nodeRow=stone[0];
            int nodeCol=stone[1]+maxRow+1;
            obj.union(nodeRow,nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol,1);

          }
          int c=0;
          for(int n:map.keySet()){
            if(obj.find(n)==n){
                c++;
            }
          }
          return stones.length-c;
    }
}