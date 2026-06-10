class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

           for (int i = 0; i < n; i++) {
    parent[i] = i;
    rank[i] = 1;
}
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

         void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
                rank[py] += rank[px];
            } else {
                parent[py] = px;
                rank[px] += rank[py];
            }
        }
    }
    public boolean isValid(int i,int j,int n){
        if(i>=0&&i<n&&j>=0&&j<n){
            return true;
        }
        return false;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DSU obj=new DSU(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    continue;
                }
                int[] dr={-1,0,1,0};
                int[] dc={0,-1,0,1};
                for(int idx=0;idx<4;idx++){
                    int row=i+dr[idx];
                    int col=j+dc[idx];
                    if(isValid(row,col,n)&&grid[row][col]==1){
                        int node=i*n+j;
                        int adjnode=row*n+col;
                        obj.union(node,adjnode);
                    }
                }
            }
        }


        int mx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    continue;
                }
                int[] dr={-1,0,1,0};
                int[] dc={0,-1,0,1};
                HashSet<Integer> set=new HashSet<>();
                for(int idx=0;idx<4;idx++){
                    int row=i+dr[idx];
                    int col=j+dc[idx];
                    if(isValid(row,col,n)){
                        if(grid[row][col]==1){
                            set.add(obj.find(row*n+col));
            
                        }
                        ;
                    }


                }
                int sum=0;
        for(Integer it: set){
         sum=sum+obj.rank[it];
        }
        mx=Math.max(mx,sum+1);
            }
        }
        
       
        for(int cell=0;cell<n*n;cell++){
            mx=Math.max(mx,obj.rank[obj.find(cell)]);
        }
        return mx;


        
    }
}