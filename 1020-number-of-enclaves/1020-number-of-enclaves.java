class Solution {
    public static void dfs(int i,int j,int[][] vis,int[][] grid,int[] delr,int[] delc){
        vis[i][j]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int k=0;k<4;k++){
            int nr=i+delr[k];
            int nc=j+delc[k];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0&&grid[nr][nc]==1){
                dfs(nr,nc,vis,grid,delr,delc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
         int [] delr={-1,0,1,0};
        int [] delc={0,1,0,-1};
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                dfs(i,0,vis,grid,delr,delc);
            }
            if(grid[i][m-1]==1){
                dfs(i,m-1,vis,grid,delr,delc);
            }
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                dfs(0,j,vis,grid,delr,delc);
            }
            if(grid[n-1][j]==1){
                dfs(n-1,j,vis,grid,delr,delc);
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
        
    }
}